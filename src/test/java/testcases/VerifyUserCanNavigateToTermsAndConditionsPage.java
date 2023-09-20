package testcases;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BasePage;
import Pages.HomePage;
import Pages.addToCartPage;
import Pages.checkoutPage;
import Pages.finalCheckOutPage;
import Pages.termsAndConditionPage;
import Utilities.ReadingPropertiesFile;


public class VerifyUserCanNavigateToTermsAndConditionsPage extends BasePage{

	public static Logger logger = LogManager.getLogger(VerifySingleItemOrderType.class);
	
	@Test
	public void NavigateToTermsAndConditionsPage() {
		
		logger.info("----- navigating to terms and condition page -----");
		
		HomePage homePage = new HomePage(driver);
		addToCartPage addCart = new addToCartPage(driver);
		checkoutPage cOutPage = new checkoutPage(driver);
		finalCheckOutPage finalChOut = new finalCheckOutPage(driver);
		termsAndConditionPage termsAndCond = new termsAndConditionPage(driver);
		
		String actualTermsAndCondition = ReadingPropertiesFile.getProperty("termsAndCondition");
		String expectedTermsAndCondition;
		
		homePage.addingProductToCart();
		homePage.clickCartButton();
		addCart.cilckBtnProceedToCheckout();
		cOutPage.clickPlaceOrderBtn();
		finalChOut.cilckTermsAndCondition();
		
		String mainWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        
        expectedTermsAndCondition = termsAndCond.termsAndConditionPageInfo();
        
        logger.info("----- Verifying the terms and condition message with actual one -----");
        Assert.assertEquals(actualTermsAndCondition, expectedTermsAndCondition);
        
        
		
	}
}
