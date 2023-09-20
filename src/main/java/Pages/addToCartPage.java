package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addToCartPage {
	public WebDriver driver;

	
	@FindBy(xpath = "(//p[@class='product-name'])[1]")
	private WebElement cucumberInMiniBasket;
	
	@FindBy(xpath = "(//p[@class='product-name'])[2]")
	private WebElement beetRootInMiniBasket;
	
	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	private WebElement btnProceedToCheckout;
	
    
	public addToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
	
	public String displayCucumberPresentInCartText() {
		return cucumberInMiniBasket.getText();
	}
	
	public String dispalyBeetRootPresentInCartText() {
		return beetRootInMiniBasket.getText();
	}
	
	public void cilckBtnProceedToCheckout() {
		btnProceedToCheckout.click();
	}
	
	
	
	
	 
}
