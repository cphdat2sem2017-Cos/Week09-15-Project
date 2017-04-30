#How to use javadoc from Netbeans
Javadoc has been a part of the standard java toolbox since the [beginning of java](http://www.literateprogramming.com/javadoc95.pdf)


## The simple version using Netbeans
Netbeans support javadoc without having to do any install.

- Select the project for which you want to run javadoc
- Select "Generate Javadoc" from the "Run" menu

![Generate Javadoc](img/runjavadoc.jpg)

The files are placed in the folder "dist/javadoc".

Notice, most of you will have the dist folder listed in your .gitignore file. This is the right thing - one should not have generated files under version control. 


## How to put the javadoc online on github
If you are interested in seeing your javadocs as part of the documents on github, here is what can be done. 

Along with the normal files making up a project, it is possible to also have a number of static web-pages on github. There are called [_github pages_](https://pages.github.com).

This is useful in itself, and can be used to make your github project look very good and proffessional. But here we will use this as a way to expose the documents used by javadoc.

### Making github show your javadoc files
Github pages has three ways of showing html pages. One of them is to tell github to use the projects docs folder.

##### Javadocs on github pages - by hand

1. create a folder named "docs" at the root of your github project
2. manually copy the javadoc files from dist/javadoc to this doc folder
3. add, commit and push the docs folder to github.
4. On the github page for your project, locate the settings (it is in the upper right side).<br> ![Settings](img/Settings.jpg)
5. On the settings page you scroll down to the section on Github Pages and set the source to "master branch /docs folder"<br>
![use doc folder](img/UseDocFolder.jpg)
6. The url to your Github pages are now listed in the green area. Copy the URL, and go back to the front page of your project. You can put in the link to the pages file at the top. <br>
![PagesURL](img/ProjectURL.jpg)

### Change where Javadoc stores the generated files
Rather than copying the files from dist/javadoc to the docs folder you can change where javadoc puts its files in the first place.

- A tricky thing - if you find a better way, please say so in an issue! <br> In the nbbuild folder there is a file named "project.properties" - you need to locate the one named dist.javadoc.dir, and change it from <br>dist.javadoc.dir=${dist.dir}/javadoc<br>to <br>dist.javadoc.dir=docs/javadoc<br>
I often leave the old value line with a # sign in front to comment it out and help me locate it again if need be

Now when you run javadoc, it stores the javadoc into the docs folder instead of the .gitignored dist/javadoc folder.

## How to use pegdown instead of normal javadoc
In 2004 Javadoc introduced the possibility for third party developers to make their own tools to process the information in the javadoc comments. 

Several of those third party javadoc extensions allow javadoc to be written in markdown. We will use one of these named [Pegdown](https://github.com/Abnaxos/pegdown-doclet) as it works well with the markdown as used in github, and with a textual syntax for most UML diagrams (class diagrams, sequence diagrams, activity diagrams and others), it allow us to embed diagrams directly in javadoc.

To get pegdown to work in netbeans, we have to:

- download it from <https://oss.sonatype.org/content/repositories/releases/ch/raffael/pegdown-doclet/pegdown-doclet/1.3/pegdown-doclet-1.3-all.jar>
- place the jar somewhere where it is available to Netbeans. I have located it in the libs folder of the project, which will work, but you might want to place it elsewhere.
- Update the project properties to make javadoc use pegdown. In the additional Javadoc options you have to specify the name of the doclet, and where to find it. 
- My line looks like this<br>
 	-doclet ch.raffael.doclets.pegdown.PegdownDoclet -docletpath ${basedir}/libs/pegdown-doclet-1.3-all.jar -overview ${basedir}/overview.md<br>
Notice the useage of ${basedir} <br>
**However** - I recommend to locate the appropriate line in the "nbbuild/project.properties" and set the line for javadoc.additionalparam explicitly, it seems to be a more stable solution that plays better with git. Mine then becomes:<br>
>javadoc.additionalparam=-doclet ch.raffael.doclets.pegdown.PegdownDoclet -docletpath ${basedir}/libs/pegdown-doclet-1.3-all.jar -overview ${basedir}/overview.md

[comment]: # (![pegdown](img/PegdownDoclet.jpg))

## Using the UML aspects of pegdown
Besides being able to use the normal markdown for headings, lists, tables and so forth, pegdown allow usage of ["plantuml"](http://plantuml.com). Plant uml provides a text based way to write UML diagrams, which means you can put diagrams in your java comments.

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
