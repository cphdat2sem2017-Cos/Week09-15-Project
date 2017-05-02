#How to use javadoc from Netbeans
Javadoc has been a part of the standard java toolbox since the [beginning of java](http://www.literateprogramming.com/javadoc95.pdf)


## The simple version using Netbeans
Netbeans support javadoc without having to do any install.

- Select the project for which you want to run javadoc
- Select "Generate Javadoc" from the "Run" menu

![Generate Javadoc](img/runjavadoc.jpg)

The files are generated in the folder "target/site/apidocs".

Notice, most of you will have the `target` folder listed in your .gitignore file. This is the right thing - one should not have generated files under version control (though we will violate that below). 


## How to put the javadoc online on github
If you are interested in seeing your javadocs as part of the documents on github, here is what can be done. 

Along with the normal files making up a project, it is possible to also have a number of static web-pages on github. There are called [_github pages_](https://pages.github.com).

This is useful in itself, and can be used to make your github project look very good and proffessional. However, here we will use this as a way to expose the documents used by javadoc.

### Making github show your javadoc files
Github pages has three ways of showing html pages. One of them is to tell github to use the projects `docs` folder.

#### Javadocs on github pages - by hand

1. create a folder named "docs" at the root of your github project
2. manually copy the javadoc files from dist/javadoc to this doc folder
3. add, commit and push the docs folder to github.
4. On the github page for your project, locate the settings (it is in the upper right side).<br> ![Settings](img/Settings.jpg)
5. On the settings page you scroll down to the section on Github Pages and set the source to "master branch /docs folder"<br>
![use doc folder](img/UseDocFolder.jpg)
6. The url to your Github pages are now listed in the green area. Copy the URL, and go back to the front page of your project. You can put in the link to the pages file at the top. <br>
![PagesURL](img/ProjectURL.jpg)

#### Change where Javadoc stores the generated files
Rather than copying the files from dist/javadoc to the docs folder you can change where javadoc puts its files in the first place.

You need to change the maven `pom.xml` file of your project. There is a section named `<build>`, and within that there is a section named `<plugins>`(notice the plural-s). You need to insert this javadoc plugin to change javadoc to put the javadoc in the `docs` folder.

```xml
<plugin>
	<artifactId>maven-javadoc-plugin</artifactId>
	<version>2.9</version>
	<configuration>
		<destDir>./docs</destDir>
		<reportOutputDirectory>${basedir}</reportOutputDirectory>
	</configuration>
</plugin>
```

Now when you run javadoc, it stores the javadoc into the docs folder instead of the .gitignored `target/site/apidocs` folder.

## How to use pegdown instead of normal javadoc
In 2004 Javadoc introduced the possibility for third party developers to make their own tools to process the information in the javadoc comments. 

Several of those third party javadoc extensions allow javadoc to be written in markdown. We will use one of these named [Markdown-doclet](https://github.com/Abnaxos/markdown-doclet) as it works well with the markdown as used in github, and with a textual syntax for most UML diagrams (class diagrams, sequence diagrams, activity diagrams and others), it allow us to embed diagrams directly in javadoc.

To get pegdown to work in netbeans, we have to change the javadoc part of the `pom.xml` above to:

```xml
<plugin>
    <artifactId>maven-javadoc-plugin</artifactId>
    <version>2.9</version>
    <configuration>
        <doclet>ch.raffael.doclets.pegdown.PegdownDoclet</doclet>
        <docletArtifact>
            <groupId>ch.raffael.pegdown-doclet</groupId>
            <artifactId>pegdown-doclet</artifactId>
            <version>1.3</version>
        </docletArtifact>
        <destDir>./docs</destDir>
        <reportOutputDirectory>${basedir}</reportOutputDirectory>
        <overview>${basedir}/overview.md</overview>
    </configuration>
</plugin>
```

[comment]: # (![pegdown](img/PegdownDoclet.jpg))

## Using the UML aspects of markdown
Besides being able to use the normal markdown for headings, lists, tables and so forth, pegdown allow usage of ["plantuml"](http://plantuml.com). Plant uml provides a text based way to write UML diagrams, which means you can put diagrams in your java comments.

- There is a [manual for the plant-uml part of markdown](http://plantuml.com/PlantUML_Language_Reference_Guide.pdf).

The prototypical way is illustrated by this comment taken from the package-info of my sample app:

```java
/**
 Encapsulates the database layer.
 The database is accessed through the BDFacade class. The DBConncection provides
 the database connection used for instantiating the DBFacace.

 Example showing how the getBuildings method is called.

 ![DBUsageDiagram](dbfacadeusage.png)

 @uml dbfacadeusage.png
 DomainLayer -> DBConnection: getConnection
 DomainLayer <-- DBConnection: aConnection
 DomainLayer -> DBFacade: new DBFacade( aConnection )
 DomainLayer <-- DBFacade: aFacade
 DomainLayer -> aFacade: getBuildings()\n(for example)
 DomainLayer <-- aFacade: List of Building
 */
```
Which produces this html page:

<iframe src="https://kaspercphbusiness.github.io/2semWebbuildingsWithTest/dbaccess/package-summary.html" height="1000" width="100%"></iframe>


I suggest you focus on the diagrams which is part of the curriculum, namely class diagrams, sequence diagrams and activity diagrams.
