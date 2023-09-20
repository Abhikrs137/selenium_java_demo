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



public class VerifyOrderCannotBePlacedWithoutSelectingTermsAndConditions extends BasePage  {
	
	public static Logger logger = LogManager.getLogger(VerifyOrderCannotBePlacedWithoutSelectingTermsAndConditions.class);
	
	@Test
	public void selectTermsAndCondition() throws InterruptedException {
		
		logger.info("----- Verifying the TermsAndCondition is selected or not -----");
		
		HomePage homePage = new HomePage(driver);
		addToCartPage addCart = new addToCartPage(driver);
		checkoutPage cOutPage = new checkoutPage(driver);
		finalCheckOutPage termCond = new finalCheckOutPage(driver);
		
		String country = ReadingPropertiesFile.getProperty("country");
		
		homePage.addingProductToCart();
		homePage.clickCartButton();
		addCart.cilckBtnProceedToCheckout();
		cOutPage.clickPlaceOrderBtn();
		termCond.selectFromCountryDropdown(country);
		termCond.selectCheckbox();
		boolean isCheckSelect = termCond.isCheckBox_selected();
		
		logger.info("----- is checkbox is selected -----");
		Assert.assertTrue(isCheckSelect);
		termCond.clickToProceed();
		
		
	}
	
	@Test
	public void FailingTestCase_notSelectTermsAndCondition() throws InterruptedException {
		
		logger.info("----- This testcase will failed because we are not clicking the checkbox and proceed for checkout -----");
		
		HomePage homePage = new HomePage(driver);
		addToCartPage addCart = new addToCartPage(driver);
		checkoutPage cOutPage = new checkoutPage(driver);
		finalCheckOutPage termCond = new finalCheckOutPage(driver);
		
		String country = ReadingPropertiesFile.getProperty("country");
		String notOrder = ReadingPropertiesFile.getProperty("not_order");
		
		homePage.addingProductToCart();
		homePage.clickCartButton();
		addCart.cilckBtnProceedToCheckout();
		cOutPage.clickPlaceOrderBtn();
		termCond.selectFromCountryDropdown(country);
		boolean isCheckSelect = termCond.isCheckBox_selected();
		
		logger.info("----- Asserting that checkbox is selected or not -----");
		Assert.assertFalse(isCheckSelect);
		termCond.clickToProceed();
		String orderPlacedOrNot = termCond.textItemNotPlaced();
		
		logger.info("----- Verifying that message when order is not placed -----");
		Assert.assertEquals(orderPlacedOrNot, notOrder);
		
	}
	

}
