Example of UI autotest for site http://blog.csssr.ru/qa-engineer/ link checking. 

To run this autotest:

    1. Install JDK, Maven and GIT and set all environment variables for these tools
    2. Setup Eclipse Java
    3. Clone repository for this autotest via Git or via Eclipse
    4. Open project with Eclipse
    5. Go to: Run - Run As - jUnit tests
   
Expected results:
    SoftLinkCheckingTest should be failed
    VKLinkCheckingTest should be passed
    
To get allure test report:
    
    1. Run Command line and go to the project directory
    2. Execute: mvn clean test -e
    2. Execute: mvn allure:serve
    
    Browser will open testreport automatically.
    
