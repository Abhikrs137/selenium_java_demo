package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class termsAndConditionPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//div[@class='wrapperTwo']")
	private WebElement termsInfo;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement homepageBtn;
	
	public termsAndConditionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String termsAndConditionPageInfo() {
		return termsInfo.getText();
	}
	
	public void clickHomepageBtn() {
		homepageBtn.click();
		driver.close();
	}
	
	

}
