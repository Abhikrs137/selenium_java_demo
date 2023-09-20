package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import BasePackage.BasePage;
import Pages.HomePage; // Updated import statement for the new HomePage class

public class VerifyProductsAreDisplayedOnTheHomePage extends BasePage {
    
	public static Logger logger = LogManager.getLogger(VerifyProductsAreDisplayedOnTheHomePage.class);
	
    @Test
    public void imageAreDisplayedOrNot() {
    	
    	logger.info("----- Verifying the product is displayed on homepage or not -----");
    	
        HomePage homePage = new HomePage(driver); 
        boolean isBrocolliImageVisible = homePage.isBrocolliImageVisible();
        
        if (isBrocolliImageVisible) {
            logger.info("Brocolli image is visible.");
        } else {
            logger.error("Brocolli image is not visible.");
        }

        logger.info("----- Verifying the brocolli image  is displayed visible -----");
        Assert.assertTrue(isBrocolliImageVisible, "Brocolli image is not visible.");
        
        
    	}
}
