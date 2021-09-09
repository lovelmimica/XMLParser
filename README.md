# XML Parser
Project made in context of employment selection procedure at one Croatian IT company. Developed in Spring MVC framework, application parses XML files and writes them in DB. 

##Specification: 

Create an application that will accept XML documents, parse them, and store them in a database.
The XML documents are in the following format: 

&lt;?xml version="1.0" encoding="UTF-8"?&gt;
&lt;entries&gt; &lt;entry>Adam&lt;/entry> 
  &lt;entry parentName="Adam"&gt;Stjepan&lt;/entry&gt; 
  &lt;entry parentName="Stjepan"&gt;Luka&lt;/entry&gt; 
  &lt;entry parentName="Adam"&gt;Leopold&lt;/entry&gt; 
  &lt;entry parentName="Leopold"&gt;Fran&lt;/entry&gt; 
  &lt;entry parentName="Leopold"&gt;Ivan&lt;/entry&gt;
  &lt;entry parentName="Ivan"&gt;Marko&lt;/entry&gt;
  &lt;entry parentName="Marko"&gt;Robert&lt;/entry&gt;
&lt;/entries&gt;

After parsing the document, the application should form a tree of parent-child relationships and write the tree in a database table called ENTRY. An entry can have a single parent, but multiple children. If an entry does not have a parent, then it is considered to be the root of the tree.

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
