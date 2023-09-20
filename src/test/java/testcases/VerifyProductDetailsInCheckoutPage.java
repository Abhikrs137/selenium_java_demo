package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BasePage;
import Pages.HomePage;
import Pages.addToCartPage;
import Pages.checkoutPage;

public class VerifyProductDetailsInCheckoutPage extends BasePage {

	public static Logger logger = LogManager.getLogger(VerifyProductDetailsInCheckoutPage.class);
	
	@Test
	public void checkoutPage() {
		
		logger.info("----- Verifying the product present in checkout Page -----");
		
		HomePage homePage = new HomePage(driver);
		addToCartPage addCart = new addToCartPage(driver);
		checkoutPage cOutPage = new checkoutPage(driver);
		
		homePage.addingProductToCart();
		homePage.clickCartButton();
		addCart.cilckBtnProceedToCheckout();
		
		logger.info("----- Matching the cucumber present in cart with the homepage name -----");
		Assert.assertEquals(homePage.dispalyCucumberText(),cOutPage.displayDetailsCucumberInCheckoutText() );
		
		logger.info("----- Matching the product Beetroot present in cart ans checking is it is present in checkout page or not -----");
		Assert.assertEquals(addCart.dispalyBeetRootPresentInCartText(),cOutPage.displayDetailsBeetRootInCheckoutText() );
		
	}
	
}
