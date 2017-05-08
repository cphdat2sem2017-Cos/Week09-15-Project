/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import service.entity.User;
import service.exceptions.PolygonException;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk
 */
public class UserMapperTest {
    
    public UserMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsers method, of class UserMapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetUsers() throws Exception {
        System.out.println("getUsers");
        List<User> expResult = null;
        List<User> result = UserMapper.getUsers();
        assertTrue(result.size()>0);
        
    /**
     * Test of getUser method, of class UserMapper.
     * @throws java.lang.Exception
     */
    }
    @Test
    public void testGetUser() throws Exception{
        System.out.println("getUser");
        User user = UserMapper.getUser(1);
        assertNotNull(user);
    }
    
    /**
     * Test of getUser method, of class UserMapper to see if we can throw a PolygonException when a user is not found.
     * @throws java.lang.Exception
     */
    @Test(expected = PolygonException.class)
    public void testPolygonException() throws PolygonException{
        User user = UserMapper.getUser(100000);
    }
}
