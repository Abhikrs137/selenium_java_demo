package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BasePage;
import Pages.HomePage;
import Pages.addToCartPage;


public class VerifyProductDetailsInMiniBasket extends BasePage{

	public static Logger logger = LogManager.getLogger(VerifyProductDetailsInMiniBasket.class);
	
	@Test
	public void checkDetailsInMiniBasket() {
		
		logger.info("----- Verifying the product present in Mini Basket-----");
		
		HomePage homePage = new HomePage(driver);
		addToCartPage addCart = new addToCartPage(driver);
		
		homePage.addingProductToCart();
		homePage.clickCartButton();

		logger.info("----- Matching the cucumber present in cart with the homepage name -----");		
		Assert.assertEquals(homePage.dispalyCucumberText(), addCart.displayCucumberPresentInCartText());
		
		logger.info("----- Matching the beetroot present in cart with the homepage name -----");
		Assert.assertEquals(homePage.displayBeetRootText(), addCart.dispalyBeetRootPresentInCartText());
	}
	
	
}
