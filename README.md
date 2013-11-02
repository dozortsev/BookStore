BookStore
========================

What is it?
-----------

This is your project! It is a sample, deployable Maven 3 project to help you get your foot in the door developing with Spring on JBoss Enterprise Application Platform 6 or JBoss AS 7.1. 

This project is setup to allow you to create a compliant Java EE 6 application using JSP, JPA 2.0 and Spring 3.2. It includes a persistence unit and some sample persistence and transaction code to introduce you to database access in enterprise Java. 

The example uses the `java:jboss/datasources/SpringQuickstartDS` database, configured and deployed by the application.

* In `jboss-as-spring-mvc-context.xml` `<context:component-scan base-package="com.dozortsev.bookstore.controller"/>` and `<mvc:annotation-driven/>` are used to register both the non-rest and rest controllers.

* The controllers map the respective urls to methods using `@RequestMapping(url)`.

* To return JSON, the rest controller uses `@ResponseBody`.

* The datasource and entitymanager are retrieved via JNDI.

System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.

The application this project produces is designed to be run on JBoss Enterprise Application Platform 6 or JBoss AS 7.1. 

Configure Maven and Start JBoss Enterprise Application Platform 6 or JBoss AS 7.1
-------------------------

1. If you have not yet done so, you must Configure Maven before testing the quickstarts.
2. Start the JBoss Server
3. Open a command line and navigate to the root of the JBoss server directory.
4. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat

Build and Deploy the Application
--------------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Build and Deploy the Quickstarts](../README.md#build-and-deploy-the-quickstarts) for complete instructions and additional options._

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean package jboss-as:deploy

4. This will deploy `target/BookStore.war` to the running instance of the server.


Access the application
----------------------

The application will be running at the following URL: <http://localhost:8080/BookStore/>.


Undeploy the Archive
--------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn jboss-as:undeploy


Debug the Application
------------------------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

        mvn dependency:sources
        mvn dependency:resolve -Dclassifier=javadoc

