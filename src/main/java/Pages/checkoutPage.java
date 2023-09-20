package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPage {

	public WebDriver driver;
	
	@FindBy(xpath = "(//table[@class='cartTable']//p)[1]")
	private WebElement detailsCucumberInCheckoutText;
	
	@FindBy(xpath = "(//p[@class='product-name'])[2]")
	private WebElement detailsBeetRootInCheckoutText;
	
	@FindBy(xpath = "//button[text()='Place Order']")
	private WebElement placeOrderBtn;
	
	
	
	
	public checkoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
    }
	
	public String displayDetailsCucumberInCheckoutText() {
		return detailsCucumberInCheckoutText.getText();
	}
	
	public String displayDetailsBeetRootInCheckoutText() {
		return detailsBeetRootInCheckoutText.getText();
	}
	
	public void clickPlaceOrderBtn() {
		placeOrderBtn.click();
	}
	
	
	
}
