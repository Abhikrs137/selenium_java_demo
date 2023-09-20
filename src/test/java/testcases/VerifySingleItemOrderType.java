package testcases;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BasePackage.BasePage;
import Pages.HomePage;
import Pages.addToCartPage;
import Pages.checkoutPage;
import Pages.finalCheckOutPage;
import Utilities.ReadingPropertiesFile;

public class VerifySingleItemOrderType extends BasePage {
	
	public static Logger logger = LogManager.getLogger(VerifySingleItemOrderType.class);
	
	@Test
	public void VerifySingleLineOrder() {
		
		logger.info("----- Ordering single item -----");
	    
		HomePage homePage = new HomePage(driver);
		addToCartPage addCart = new addToCartPage(driver);
		checkoutPage cOutPage = new checkoutPage(driver);
		finalCheckOutPage termCond = new finalCheckOutPage(driver);
		
		String country = ReadingPropertiesFile.getProperty("country");
		
		homePage.clickCucumberAddToCartBtn();
		homePage.clickCartButton();
		addCart.cilckBtnProceedToCheckout();
		cOutPage.clickPlaceOrderBtn();
		termCond.termsandConditionProcess(country);
		String ActualFInalMsg = termCond.textFinalOrderMessage();
		boolean isContainMsg = termCond.isContain( ActualFInalMsg);
		
		logger.info("----- Verifying that message when order is placed -----");
		assertTrue(isContainMsg);
	}
	
	@Test
	public void VerifySingleLineMultiQtyOrder()  {
		
		logger.info("----- Ordering single item -----");
		
		HomePage homePage = new HomePage(driver);
		addToCartPage addCart = new addToCartPage(driver);
		checkoutPage cOutPage = new checkoutPage(driver);
		finalCheckOutPage termCond = new finalCheckOutPage(driver);
		
		String country = ReadingPropertiesFile.getProperty("country");
		int cucumberQuant = Integer.parseInt(ReadingPropertiesFile.getProperty("cucumberQuantity"));
		int actualPriceOfbeet = Integer.parseInt(homePage.getBeetRootPrice())*2;
		
		homePage.quantityOfBeetRoot(cucumberQuant);
		int expectedPriceOfBeet = Integer.parseInt(homePage.getTotalPriceOfCart());
		
		logger.info("----- verifying the price of product with price of cart -----");
		assertEquals(expectedPriceOfBeet,actualPriceOfbeet);
		
		homePage.clickCartButton();
		addCart.cilckBtnProceedToCheckout();
		cOutPage.clickPlaceOrderBtn();
		termCond.termsandConditionProcess(country);
		String ActualFInalMsg = termCond.textFinalOrderMessage();
		boolean isContainMsg = termCond.isContain( ActualFInalMsg);
		
		logger.info("----- Verifying that message when order is placed -----");
		assertTrue(isContainMsg);
		
		
	}

}
