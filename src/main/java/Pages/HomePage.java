package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage { // Renamed class to follow conventions
    private WebDriver driver;
    
    //------------ Image -------------------------------

    @FindBy(xpath = "//img[@alt='Brocolli - 1 Kg']")
    private WebElement brocolliImage;
    
    
    //------------ Product Name ------------------------
    
    @FindBy(xpath = "//h4[text()='Cucumber - 1 Kg']")
    private WebElement itemcucumberText;
    
    @FindBy(xpath = "//h4[text()='Beetroot - 1 Kg']")
    private WebElement itemBeetRoorText;
    
    @FindBy(xpath = "//form[@class='search-form']//input[1]")
    private WebElement searchBoxTextField;
    
    @FindBy(xpath = "//form[@method='get']//button[1]")
    private WebElement searchBoxButton;
    
    @FindBy(xpath = "(//button[text()='ADD TO CART'])[3]")
    private WebElement cucumberAddToCartBtn;
    
    
    @FindBy(xpath = "(//div[@class='product-action']//button)[4]")
    private WebElement beetRootAddToCartBtn;
    
    @FindBy(xpath = "//a[@class='cart-icon']//img[1]")
    private WebElement cartButton;
	
	@FindBy(xpath = "(//p[@class='product-name'])[1]")
	private WebElement ElementCucumberPresentInCart;
	
	@FindBy(xpath = "(//div[@class='product']//p)[3]")
	private WebElement cucumberPrice;
	
	@FindBy(xpath = "//h4[text()='Beetroot - 1 Kg']/following-sibling::p")
	private WebElement beetRootPrice;
	
	@FindBy(xpath = "(//div[@class='cart-info']//strong)[2]")
	private WebElement totalPriceOfCart;
	
	@FindBy(xpath = "(//div[@class='cart-info']//strong)[1]")
	private WebElement totalNumberOfItenInCart;
	
    
 // Method to generate a dynamic XPath based on the index for product images
    private String generateProductImageXPath(int index) {
        return "(//div[@class='product-image']//img)[" + index + "]";
    }

    // Method to generate a dynamic XPath based on the index for product names
    private String generateProductTitleXPath(int index) {
        return "(//div[@class='product-image']/following-sibling::h4)[" + index + "]";
    }

    // Method to generate a dynamic XPath based on the index for Add to Cart buttons
    private String generateAddToCartButtonXPath(int index) {
        return "(//div[@class='product-action']//button)[" + index + "]";
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
    }

    public boolean isBrocolliImageVisible() {
        return brocolliImage.isDisplayed();
    }
    
    public String dispalyCucumberText() {
    	return itemcucumberText.getText();
    }
    
    public String displayBeetRootText() {
    	return itemBeetRoorText.getText();
    }
    
    public void fillDataInSearchbox(String data) {
    	searchBoxTextField.sendKeys(data);
    }
    
    public void clickSearchBoxButton() {
    	searchBoxButton.click();
    }
    
    public void clickCucumberAddToCartBtn() {
        cucumberAddToCartBtn.click();
    }
    
    public void clickBeetRootAddToCartBtn() {
    	beetRootAddToCartBtn.click();
    }
    
    public void clickCartButton() {
    	cartButton.click();
	}
	
	public String isCucumberElementPresentInCart() {
		return ElementCucumberPresentInCart.getText();
	}
	
	public String getCucumberPrice() {
		return cucumberPrice.getText();
	}
    
	public String getBeetRootPrice() {
		return beetRootPrice.getText();
	}
    
	public String getTotalPriceOfCart() {
		return totalPriceOfCart.getText();
	}
	
	public String getTotalNumberOfItenInCart() {
		return totalNumberOfItenInCart.getText();
	}
	
    
 // Method to get a list of product image elements
    public List<WebElement> getProductImages(int count) {
        List<WebElement> productImages = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            String xpath = generateProductImageXPath(i);
            WebElement productImage = driver.findElement(By.xpath(xpath));
            productImages.add(productImage);
        }

        return productImages;
    }

    // Method to get a list of product title elements
    public List<WebElement> getProductTitles(int count) {
        List<WebElement> productTitles = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            String xpath = generateProductTitleXPath(i);
            WebElement productTitle = driver.findElement(By.xpath(xpath));
            productTitles.add(productTitle);
        }

        return productTitles;
    }

    // Method to get a list of Add to Cart button elements
    public List<WebElement> getAddToCartButtons(int count) {
        List<WebElement> addToCartButtons = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            String xpath = generateAddToCartButtonXPath(i);
            WebElement addToCartButton = driver.findElement(By.xpath(xpath));
            addToCartButtons.add(addToCartButton);
        }

        return addToCartButtons;
    }
    
    
    public boolean isTextContains(String str) {
		if (dispalyCucumberText().contains(str)) {
			return true;
		}
    	return false;
    }
    
    public void quantityOfCucumber(int quant ) {

    	
    	for(int i=0;i<quant;i++) {
    		cucumberAddToCartBtn.click();
    	}
    	
    }
    
    public void quantityOfBeetRoot(int quantity) {
    	for (int i = 0; i < quantity; i++) {
    		beetRootAddToCartBtn.click();
        }
    }
    
    public void addingProductToCart() {
    	clickCucumberAddToCartBtn();
    	clickBeetRootAddToCartBtn();
    }
    
    
}
