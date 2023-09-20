package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BasePage;
import Pages.HomePage;
import Pages.addToCartPage;
import Pages.checkoutPage;
import Pages.finalCheckOutPage;
import Utilities.ReadingPropertiesFile;

public class VerifyMultipleItemOrderType  extends BasePage{

	public static Logger logger = LogManager.getLogger(VerifyMultipleItemOrderType.class);
	
	@Test
	public void VerifyMultiLIneOrder() {
		
		logger.info("----- Verifying Multiple item Order -----");
		
		HomePage homePage = new HomePage(driver);
		addToCartPage addCart = new addToCartPage(driver);
		checkoutPage cOutPage = new checkoutPage(driver);
		finalCheckOutPage termCond = new finalCheckOutPage(driver);
	
		String country = ReadingPropertiesFile.getProperty("country");
		
		homePage.clickCucumberAddToCartBtn();
		homePage.clickBeetRootAddToCartBtn();
		homePage.clickCartButton();
		addCart.cilckBtnProceedToCheckout();
		cOutPage.clickPlaceOrderBtn();
		termCond.termsandConditionProcess(country);
		String ActualFInalMsg = termCond.textFinalOrderMessage();
		boolean isContainMsg = termCond.isContain( ActualFInalMsg);
		
		logger.info("----- Verifying that message when order is placed -----");
		Assert.assertTrue(isContainMsg);
	}
	
	@Test
	public void VerifyMultiLineMultiQtyOrder() {
		
		logger.info("----- Verifying Multiple item Order with multiple quantity -----");
		
		HomePage homePage = new HomePage(driver);
		addToCartPage addCart = new addToCartPage(driver);
		checkoutPage cOutPage = new checkoutPage(driver);
		finalCheckOutPage termCond = new finalCheckOutPage(driver);
		
		String country = ReadingPropertiesFile.getProperty("country");
		int cucumberQuant = Integer.parseInt(ReadingPropertiesFile.getProperty("cucumberQuantity"));
		int beetQuant = Integer.parseInt(ReadingPropertiesFile.getProperty("beetRootQuantity"));
		
		homePage.quantityOfCucumber(cucumberQuant);
		homePage.quantityOfBeetRoot(beetQuant);
		homePage.clickBeetRootAddToCartBtn();
		homePage.clickCartButton();
		addCart.cilckBtnProceedToCheckout();
		cOutPage.clickPlaceOrderBtn();
		termCond.termsandConditionProcess(country);
		String ActualFInalMsg = termCond.textFinalOrderMessage();
		boolean isContainMsg = termCond.isContain( ActualFInalMsg);
		
		logger.info("----- Verifying that message when order is placed -----");
		Assert.assertTrue(isContainMsg);
		
	}
}
