                    Selenium Test Application Project 

----------------------------------------------------------------------------------------------

1.Project Overview
___________________

     This Selenium test automation project is designed to demonstrate automated testing
     for a web application using the Selenium WebDriver framework. It includes various 
     test cases for a sample web application.

2.Project Structure
____________________

	The project follows a standard Maven project structure with the following key 
	directories and files:

	a). src/main/java: Java source code for production classes.
	b). src/test/java: Java source code for test classes.
	c). src/test/resources: Configuration files and test data.
	d). pom.xml: Maven project configuration file.
	e). log4j2.xml: Configuration file for logging.
	f). config.properties: Configuration file for test settings.
	g). reportConfig.xml: Configuration file for reporting.
	h). testng.xml: TestNG suite configuration.



3.Testcases
_______________________________

	a). VerifyProductsAreDisplayedOnTheHomePage
	b). VerifySearchFuntioanlityOnHomePage
	c). VerifyProductImagePriceAndAddToCartButtonAreDisplayedForEachProduct
	d). VerifyAddToCartFuntionality
	e). VerifyProductDetailsInMiniBasket
	f). VerifyProductDetailsInCheckoutPage
	g). VerifyOrderCannotBePlacedWithoutSelectingTermsAndConditions
	h). VerifyUserCanNavigateToTermsAndConditionsPage
	i). VerifySingleItemOrderType
	j). VerifyMultipleItemOrderType

	Note : There are total 14 Testcases in which 12 are positive test cases and 
	       2 are negative test cases
	   

4.Prerequisites
________________

	 Before running the tests, ensure you have the following prerequisites installed
	 on your system:

	a). Java Development Kit (JDK) - Version 1.7 or higher
	b). Maven - Build and dependency management tool
	c). WebDriver-compatible web browser - Supported browsers include Chrome, Firefox, etc.
	d). IDE for Java development - (e.g., Eclipse, IntelliJ IDEA)

5.Configuration
________________

    a). config.properties: This file in the src/test/resources directory contains various
                           test configuration properties such as the application URL, 
                           browser choice, and timeouts.

    b). testng.xml:        The TestNG suite configuration file allows you to specify test
					       class execution order, parallel execution, and more.

6.Test Data
____________

    a). src/test/resources:  This directory contains test data such as search keywords 
                          and test-specific data in various property files.
                         
7). Logging
____________

     The project uses Log4j2 for logging. Log configurations can be found in the log4j2.xml
     file in the src/test/resources directory. Logs are generated in the logs directory.

8). Reporting
_______________

     The project uses Extent Reports for test reporting. You can customize the reporting
     settings in the reportConfig.xml file in the src/test/resources directory. Reports 
     are generated in the test-output directory.
     
9). Running Tests
__________________

     You can run the tests using TestNG or your preferred IDE. Ensure you have the necessary
     configuration set up in your TestNG suite or IDE.

a). Using TestNG:

     mvn clean test -DsuiteXmlFile=testng.xml
     
b). Using IDE:

	 Import the project into your IDE and run the individual test classes or the testng.xml suite.
	 
	 A). Test in Headed Mode
	 	 Set runmode = headed in config File which is present in resource Folder
	 B). Test in Headless Mode
	 	 Set runmode = headless in config File which is present in resource Folder
