# Documentation in Javadoc
One part of documentation is _internal_ documentation. Internal documentation is documentation which is written inside the program itself.

Java was one of the first programming languages to come with a tool which can extract information in source comments and produce HTML based documentation from those comments.

Javadoc allow you to write comments associated with:

- Projects
- Packages
- Classes
- Methods
- Fields

All of the places makes sense, and we will look at them all.

The tool Javadoc processes the contents of the special comments to produce html. There is a seperate note on how to use Javadoc inside of Netbeans

## Structure of a javadoc comment
The javadoc tool will process the comments on the form:

```java
/**
Javadoc comments start with /**
and ends as a normal comment 
*/
```
The first sentence - up until the first period is used in headings and should be short and and to the point. 

Inside the comments you can use special documentation tags to control how the final html is generated. The most commonly used tags are:

- @param name - comment about the parameter
- @return - comment about what the method returns
- @throws - comment about which exception is thrown
- @author - who wrote this class
- @version - what version of the class is this

When using git, both author and version are better tracked using the version history than through these tags.

A full description of tags is at this page at the [official java documentation](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html#format)

## Documenting classes

The important thing to document about a class is 

- who uses it 
- for what is it used
- who makes objects from this class

For example, a comment for a servlet should say which jsp pages has forms that sends requests to this servlet, and which jsp pages it forwards to.

A domain class could document which database tables it mirrors, and if how it is instantiated - in the presentation layer, the database layer, or both.

## Documenting methods
When documenting a method, there focus is on describing these four aspects of a method:

- the parameters, what they are used for and if there are expected values (e.g. not null)
- the return value - how does it depend on the paramters and the state of the object
- state change - how does this method change the state of the object
- thows - if the method thows an exception, state under what condition it is thrown.

## Documenting packages
Documenting packages is done in a special file named "package-info.java". 

Such a file can be made using the usual netbeans "new". Package-info is one of the files that can be created under the Java category.

For packages you should document:

- its cohesion principle
- how the major classes work together

The cohesion priciple can for instance be that _this package contains the classes of the system's domain layer_". 

Documenting how the major classes work together can often be illustrated using a sequence diagram.

## Overview documentation
The overview documentation should say how the various packages work together, and how key classes provide the coupling between the packages.
