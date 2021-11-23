Running instructions:

1.to run the test of the calculator,
go to the terminal when on the root of the project
and write gradle test

2.to run the java Question
use (on intellij ide)
the gree run button on the left of the start of the main code
on class:
GroupsToSitesMatch

On the Test:
i used the PageObject
to use abstraction and to simplfy the maintainance
and writing of tests
all the test inherit this way
TestClass-->baseTests-->base
so all tests can use the WebDriver driver
and open the browser
and that TearDown will be automaticly done without need
to add it to all tests.
also divided type of classes to packages:
utils,pageObjects,and Tests according to the provided functionality.

On the java question:
devided code to Group,Site and GroupsoiteMatch
to get the correct encapsulation of objects
to improve the code i would have used the builder(to initialize the objects) 
and factory(to create Group or site) design pattern and 


