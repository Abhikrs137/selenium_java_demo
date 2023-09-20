package testcases;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BasePage;
import Pages.HomePage;


public class VerifyProductImagePriceAndAddToCartButtonAreDisplayedForEachProduct extends BasePage {

	public static Logger logger = LogManager.getLogger(VerifyProductImagePriceAndAddToCartButtonAreDisplayedForEachProduct.class);
	
	 @Test
	 public void verifyAllElements() {
		 
		 logger.info("----- Verifying the product image and Add to cart button is displayed or not -----");
			
		 HomePage homePage = new HomePage(driver);
		 int productCountToVerify = 10; 

		 logger.info("----- Strong the web element of productImage productTitile and buttons in list -----");
			
	     List<WebElement> productImages = homePage.getProductImages(productCountToVerify);
	     List<WebElement> productTitles = homePage.getProductTitles(productCountToVerify);
	     List<WebElement> addToCartButtons = homePage.getAddToCartButtons(productCountToVerify);

	     logger.info("----- Asserting the size of the list of productImage and productTitle -----");
	     Assert.assertEquals(productImages.size(), productTitles.size());
	     
	     logger.info("----- Asserting the size of the list of productImage and buttons -----");
	     Assert.assertEquals(productImages.size(), addToCartButtons.size());

	     for (int i = 0; i < productImages.size(); i++) {
	    	 
	    	 logger.info("----- Verifying that the productImage , productTitle, buttons are displayed or not -----");
	    	 Assert.assertTrue(productImages.get(i).isDisplayed());
	         Assert.assertTrue(productTitles.get(i).isDisplayed());
	         Assert.assertTrue(addToCartButtons.get(i).isDisplayed());
	        
	     }
	    }
	
}
