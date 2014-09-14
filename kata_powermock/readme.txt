Instructions
---------------------

Write test cases for all the "production" code. Suggested order:
1) Test hellopower HelloWorld
2) Test staticmocking ServiceRegistrator
3) Test partialmocking ProviderServiceImpl
4) Test domainmocking SampleServiceImpl



Notice that the sub package "withoutpowermock" contains refactored "production" 
code and traditional test cases that doesn't use PowerMock. Of course, there 
are typically several ways to refactor the code and we have only shown one
example solution. 


!Important!

The code here is only intended as a tutorial for how to use various PowerMock 
techniques and not a recommended way of coding! 