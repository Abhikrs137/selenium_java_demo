package testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BasePage;
import Pages.HomePage;
import Utilities.ReadingPropertiesFile;


public class VerifyAddToCartFuntionality extends BasePage{
	
	public static Logger logger = LogManager.getLogger(VerifyAddToCartFuntionality.class);
	
	@Test
	public void AddToCart() {
		
		logger.info("----- Checking the total of selected item price -----");
		
		int realPrice,expectedPrice;
		String expitemSelected = ReadingPropertiesFile.getProperty("itemSelected");
		HomePage homePage = new HomePage(driver);
		
		homePage.addingProductToCart();
		realPrice = Integer.parseInt(homePage.getCucumberPrice())+Integer.parseInt(homePage.getBeetRootPrice());
		expectedPrice = Integer.parseInt(homePage.getTotalPriceOfCart());
		
		logger.info("----- Verifying the total of selected item price -----");
		Assert.assertEquals(realPrice, expectedPrice);
		
		logger.info("----- Verifying the total of selected item selected -----");
		Assert.assertEquals(expitemSelected,homePage.getTotalNumberOfItenInCart());
		
		
	}

}
