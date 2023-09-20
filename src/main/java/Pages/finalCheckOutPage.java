package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.ReadingPropertiesFile;

public class finalCheckOutPage {
	public WebDriver driver;
	
	@FindBy(xpath ="//div[@class='wrapperTwo']//select[1]")
	private WebElement countryDropDown;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	private WebElement proceedBtn;
	
	@FindBy(xpath  ="//b[text()='Please accept Terms & Conditions - Required']")
	private WebElement itemNotPlaced;
	
	@FindBy(xpath = "//a[contains(text(),'Terms & Conditions')]")
	private WebElement termsAndCondition;
	
	@FindBy(xpath = "(//div[@class='wrapperTwo']//span)[1]")
	private WebElement finalOrderMessage;
	
	public finalCheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	String ExpectedFinalMsg = ReadingPropertiesFile.getProperty("thankYouMsg");

	public void selectFromCountryDropdown(String Country) {
		 	Select select = new Select(countryDropDown);
	        select.selectByVisibleText(Country);
	}
	
	public void selectCheckbox() {
		 checkbox.click();
	}
	
	public void clickToProceed() {
		proceedBtn.click();
	}
	
	public boolean isCheckBox_selected() {
		return checkbox.isSelected();
	}
	
	public String textItemNotPlaced() {
		return itemNotPlaced.getText();
	}
	
	public void cilckTermsAndCondition() {
		termsAndCondition.click();
	}
	
	public String textFinalOrderMessage() {
		return finalOrderMessage.getText();
	}
	
	public boolean isContain(String Actual) {
		if(Actual.contains(ExpectedFinalMsg)) {
			return true;
		}
		return false;
	}
	
public void termsandConditionProcess(String country) {
	selectFromCountryDropdown(country);
	selectCheckbox();
	clickToProceed();
		
	}
}
