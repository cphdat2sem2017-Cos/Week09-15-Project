# Unit Testing Database Code

### by Lasse Koskela
(Edited by Kasper)

Have you ever tried to write unit tests for a class that does some data munging on a database? Many have tried and surrendered after a while because of a number of reasons. Some have complained about the test running for too long or about the test needing a set of fixed test data, which easily gets out of synch. Most problems related to testing database related code can be summarized under lack of encapsulation.

This article's goal is to show some ways to organize your database code in such a way that writing those unit tests with JUnit and its extensions becomes possible.

We'll use a fictious Data Access Object pattern (DAO) implementation called UserDAO as an example. The actual pattern is not relevant here so we've left out most of the elements the pattern suggests. For more context on the DAO pattern itself, please refer to the pattern documentation at http://java.sun.com/blueprints/corej2eepatterns/Patterns/DataAccessObject.html (our UserDAO and User classes map to the CustomerDAO and Customer in the blueprints).

In general, the key in writing testable database code is to separate logic from access. For example, a DAO class should not encapsulate both the code for querying data over JDBC and the code for obtaining the JDBC connection. Listing 1 shows an example of this kind of flaw.

### Listing 1. Badly encapsulated database code

```java
public class MyNonTestableUserDAO implements UserDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mckoi://localhost/",
            "admin_user",
            "aupass00");
    }

    public User createUser(String userId, String firstName, String lastName)
        throws DAOException {
        try {
            PreparedStatement ps = getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, userId);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.executeUpdate();
            ps.close();
            return new User(userId, firstName, lastName);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
```
## The mock approach
(You can skip this section, it is not the recommended solution)

The problem in testing the DAO class in Listing 1 is that unless we can replace the JDBC connection implementation, running the test successfully would require a real database with the right data. Now, how do we manage to do that?

One could intercept the getConnection() call with the help of AspectJ or other AOP frameworks, but that's too much work and results in unnecessarily complex code. Also, one could consider making the getConnection() method protected, and subclassing the DAO class in the test code overriding that particular method, which is already a pretty clean and compact solution (illustrated in Listing 2).

### Listing 2. Letting the test code extend the class under test, overriding the nasty getConnection() method

```java
public class MyTestableUserDAO1 implements UserDAO {

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mckoi://localhost/",
            "admin_user",
            "aupass00");
    }

    public User createUser(String userId, String firstName, String lastName)
        throws DAOException {
        try {
            PreparedStatement ps = getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, userId);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.executeUpdate();
            ps.close();
            return new User(userId, firstName, lastName);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
```

```java
public class TestMyTestableUserDAO1 extends TestCase {

    public void testCreateUser() {
        // configure a mock implementation for the java.sql.Connection interface
        final MockConnection mock = new MockConnection();
        mock.setExpectedCloseCalls(0);
        mock.setupAddPreparedStatement(new MockPreparedStatement());

        // replacing the real Connection implementation with
        // a mock implementation
        UserDAO dao = new MyTestableUserDAO1() {
            protected Connection getConnection() {
                return mock;
            }
        };

        // exercise the class under test and assert expectations
        User user = dao.createUser("laskos", "Lasse", "Koskela");
        assertNotNull(user);
        assertEquals("laskos", user.getUserId());
        assertEquals("Lasse", user.getFirstName());
        assertEquals("Koskela", user.getLastName());

        // afterwards, we can check with the mock implementation that the
        // class under test collaborated with it as expected
        mock.verify();
    }
}
```

## Mistaken encapsulation
(This is the suggested solution)

Often the best approach, in my opinion, is to fix the root problem -- the bad encapsulation. Once the logic inside getConnection() is moved out of the class under test, it is trivial to pass in a mock implementation in the unit test code instead of the real thing. Listing 3 illustrates this change.

### Listing 3  A better structure enabling us to test the class-under-test as it is

```java
public class MyTestableUserDAO2 implements UserDAO {

    private Connection connection;

    public MyTestableUserDAO(Connection connection) {
        this.connection = connection;
    }

    public User createUser(String userId, String firstName, String lastName)
        throws DAOException {
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setString(1, userId);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.executeUpdate();
            ps.close();
            return new User(userId, firstName, lastName);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
```

```java
public class TestMyTestableUserDAO2 extends TestCase {

    public void testCreateUser() {
        // configure a mock implementation for the java.sql.Connection interface
        final MockConnection mock = new MockConnection();
        mock.setExpectedCloseCalls(0);
        mock.setupAddPreparedStatement(new MockPreparedStatement());
        ...

        // replacing the real Connection implementation with
        // a mock implementation
        UserDAO dao = new MyTestableUserDAO2(mock);

        // exercise the class under test and assert expectations
        User user = dao.createUser("laskos", "Lasse", "Koskela");
        assertNotNull(user);
        assertEquals("laskos", user.getUserId());
        assertEquals("Lasse", user.getFirstName());
        assertEquals("Koskela", user.getLastName());

        // afterwards, we can check with the mock implementation that the
        // class under test collaborated with it as expected
        mock.verify();
    }
}
```

Note that even though this example hands an instance of java.sql.Connection to the DAO implementation, it could just as easily be a javax.sql.DataSource or some custom interface for ultimately obtaining a JDBC connection.

For details about writing tests using the mock objects approach and the different frameworks at your disposal, please refer to the resources section.

## The sandbox approach
(This is most likely the best approach, but requires new tools)

As always, there's more than one way of doing things. If refactoring the code to accommodate the mock objects approach illustrated above is too big a task and if it's acceptable to have the unit test run for a bit longer, there's always the option to use the real database and simply setup a "sandbox" for the test code to play with.

A great tool for this alternative method of testing, that I refer to as sandboxing, is dbUnit (http://dbunit.sourceforge.net). The dbUnit framework allows the developer to create a data set, which is automatically created into the real database before running the test code and can clean up its mess afterwards if necessary.

### Listing 4. The "sandbox" approach

```java
public class MyNonTestableUserDAO implements UserDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mckoi://localhost/",
            "admin_user",
            "aupass00");
    }

    public User createUser(String userId, String firstName, String lastName)
        throws DAOException {
        try {
            PreparedStatement ps = getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, userId);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.executeUpdate();
            ps.close();
            return new User(userId, firstName, lastName);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
```

```java
public class TestMyNonTestableUserDao extends DatabaseTestCase {

    private static final String TESTDATA_FILE =
        "TestMyNonTestableUserDao-dataset.xml";

    public TestMyNonTestableUserDao(String testName) {
        super(testName);
    }

    // dbUnit uses this method to obtain a connection to the database which
    // it is supposed to set up as a sandbox for the actual test methods
    protected IDatabaseConnection getConnection() throws Exception {
        Class driverClass = Class.forName("com.mckoi.JDBCDriver");
        String url = "jdbc:mckoi://localhost/";
        String usr = "admin_user";
        String pwd = "aupass00";
        Connection jdbcConnection = DriverManager.getConnection(url, usr, pwd);
        return new DatabaseConnection(jdbcConnection);
    }

    // dbUnit uses this method to obtain the set of data that needs to be
    // inserted into the database to set up the sandbox
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new FileInputStream(TESTDATA_FILE));
    }

    public void testCreateUser() throws Exception {
        UserDAO dao = new MyNonTestableUserDAO();
        User user = dao.createUser("laskos", "Lasse", "Koskela");
        assertNotNull(user);
        assertEquals("laskos", user.getUserId());
        assertEquals("Lasse", user.getFirstName());
        assertEquals("Koskela", user.getLastName());
        makeSureUserWasInserted(user);
    }

    private void makeSureUserWasInserted(User user)
        throws AssertionFailedError, Exception {
        Connection jdbcConnection = getConnection().getConnection();
        // actual verification emitted for brevity ...
    }
}
```

Note that the test data is located in an XML file named MyNonTestableUserDAO-dataset.xml in the local filesystem. Listing 5 shows a possible example of its contents.

### Listing 5. A sample dataset file for the dbUnit test in Listing 4

```xml
<?xml version='1.0' encoding='UTF-8'?>
<dataset>
  <MY_USERS USER_ID='fb' FIRST_NAME='Foo' LAST_NAME='Bar'/>
  <MY_USERS USER_ID='tgpaul' FIRST_NAME='Thomas' LAST_NAME='Paul'/>
  <MY_USERS USER_ID='efh' FIRST_NAME='Ernest' LAST_NAME='Friedmann-Hill'/>
</dataset>
```

For details about writing tests using dbUnit, please refer to resources section.

## Resources

<http://www.junit.org> 
The definitive source for JUnit extensions

<http://www.mockobjects.com/> 
Perhaps the most widely used mock object library

<http://www.mockmaker.org> 
Creates mock objects for your classes

<http://www.easymock.org> 
A handy mock object framework based on dynamic proxies

<http://www.ibm.com/developerworks/library/j-mocktest.html> 
A very nice article about unit testing with mock objects

<http://dbunit.sourceforge.net>
A testing framework for testing with a real database
