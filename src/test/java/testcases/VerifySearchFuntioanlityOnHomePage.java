package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BasePage;
import Pages.HomePage;
import Utilities.ReadingPropertiesFile;

public class VerifySearchFuntioanlityOnHomePage extends BasePage{

	public static Logger logger = LogManager.getLogger(VerifySearchFuntioanlityOnHomePage.class);
	
	 @Test
	 public void matchingSearchedProduct() {
		 
		 logger.info("----- Verifying the search functionality -----");
	    	
		 HomePage homePage = new HomePage(driver); 
	        
		 logger.info("----- Giving data to the searchbox for searching -----");
	     String searchObject = ReadingPropertiesFile.getProperty("searchProduct");
	        
	     homePage.fillDataInSearchbox(searchObject);
	     homePage.clickSearchBoxButton();
	        
	     boolean isContain = homePage.isTextContains(searchObject);
	     
	     logger.info("----- Verifying that the name appers while searching the product is same or not -----");
	     Assert.assertTrue(isContain, "cucumber text is visible.");
	        
	        
	    }
	 
	 @Test
	 public void FailedTestcase_matchingSearchedProduct() {
		 
		 logger.info("-----(FailedTestcase) Verifying the search functionality -----");
	    	
		 HomePage homePage = new HomePage(driver); 
	        
		 logger.info("----- Giving data to the searchbox for searching -----");
	     String searchObject = ReadingPropertiesFile.getProperty("searchFailedProduct");
	        
	     homePage.fillDataInSearchbox(searchObject);
	     homePage.clickSearchBoxButton();
	        
	     boolean isContain = homePage.isTextContains(searchObject);
	     
	     logger.info("----- Verifying that the name appers while searching the product is same or not -----");
	     Assert.assertFalse(isContain);
	        
	        
	    	}
}
