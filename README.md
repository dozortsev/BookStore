BookStore
========================


System requirements
-------------------

All you need to build this project is Java 7.0 ([Java SDK 1.7][1]), [Apache Maven 3.1.1][2] and [JBoss AS 7.1.1.Final][3].

The application this project produces is designed to be run on JBoss AS 7.

Configure Maven and Start JBoss AS
-------------------------

1. If you have not yet done so, you must Configure Maven before testing.
2. Start the JBoss Server
3. Open a command line and navigate to the root of the JBoss server directory.
4. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat

Build and Deploy the Application
--------------------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory.
3. Type this command to build and deploy the archive:

        mvn clean package jboss-as:deploy

4. This will deploy `target/BookStore.war` to the running instance of the server.


Access the application
----------------------

The application will be running at the following URL: <http://localhost:8080/BookStore/SignIn>


Undeploy the Archive and Shutdown JBoss AS
--------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory.
3. When you are finished testing, type this command to undeploy the archive:

        mvn clean jboss-as:undeploy
        
4. And then type following command line to shutdown the JBoss Server with the web profile:

        For Linux:   JBOSS_HOME/bin/jboss-cli.sh --connect command=:shutdown
        For Windows: JBOSS_HOME\bin\jboss-cli.bat --connect command=:shutdown

Versioning
----------

For transparency into our release cycle and in striving to maintain backward compatibility,
BookStore is maintained under the [Semantic Versioning][4] guidelines.

Releases will be numbered with the following format: `<major>.<minor>.<patch>`

Author
------

**Dozortsev Anton**


[1]: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.
[2]: http://maven.apache.org/download.cgi
[3]: http://www.jboss.org/jbossas/downloads/
[4]: http://semver.org/