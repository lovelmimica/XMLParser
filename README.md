# xml-parser-spring
Project made in context of employment selection procedure, as a challenge. Application parses XML files and writes them in DB. Project has been made in Spring MVC framework. 

Specification: 

Create an application that will accept XML documents, parse them, and store them in a database.
The XML documents are in the following format: 
'''xml
<?xml version="1.0" encoding="UTF-8"?> 
<entries> <entry>Adam</entry> 
  <entry parentName="Adam">Stjepan</entry> 
  <entry parentName="Stjepan">Luka</entry> 
  <entry parentName="Adam">Leopold</entry> 
  <entry parentName="Leopold">Fran</entry> 
  <entry parentName="Leopold">Ivan</entry> 
  <entry parentName="Ivan">Marko</entry> 
  <entry parentName="Marko">Robert</entry>
</entries>
'''
Upon parsing the document, the application should form a tree of parent-child relationships and write the tree in a database table called ENTRY. An entry can have a single parent, but multiple children. If an entry does not have a parent, then it is considered to be the root of the tree.

The application should be a Spring MVC application, and the XML documents can be sent to the application in two ways:
1. Via HTTP POST requests (Content-Type: application/xml)
2. By placing the files to a predefined directory (the application should check this directory in a regular interval, e.g. every 30 seconds).

Other requirements:

-Project should use Java 8.
-You can use Spring Boot if you'd like.

-Maven should be used for resolving external libraries, and for running the tests from command line.

-Separate Spring profiles should be used for test and development. Development profile can use any database of your choice (PostgreSQL, MySQL...) while test profile should use H2 or HSQL in-memory database.

-Functionalities should be covered by unit tests as well as integration tests. Tests should be able to be executed from command line (Maven).

-Use properties files to parameterize application (e.g. processing interval duration, input directory...).

-Code should be organized in layers: controller, service, utils...

-Base package should be hr.altima.

Once done, please zip the solution (just the source code) and send it to us. Alternatively, you can put it to a public repository such as GitHub or Bitbucket.
