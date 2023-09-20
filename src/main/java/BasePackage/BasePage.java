package BasePackage;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Utilities.ExtentManager;
import Utilities.ReadingPropertiesFile;
import Utilities.Screenshot;

public class BasePage {
    public static Logger logger = LogManager.getLogger(BasePage.class);
    protected  WebDriver driver;
    public static ExtentReports extent_report;
    public static ExtentTest extent_test;

    @SuppressWarnings("deprecation")
	@BeforeMethod
    public void setUp(Method method) {
        String browserName = ReadingPropertiesFile.getProperty("browser");
        String runMode = ReadingPropertiesFile.getProperty("runmode");

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (runMode.equalsIgnoreCase("headless")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (runMode.equalsIgnoreCase("headless")) {
                options.setHeadless(true);
            }
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (runMode.equalsIgnoreCase("headless")) {
                options.addArguments("--headless");
            }
            driver = new EdgeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ReadingPropertiesFile.getProperty("url"));
        extent_report = ExtentManager.getInstance("Reports//Extent_demo.html");
        extent_test = extent_report.startTest(method.getName());
    }

    @AfterMethod
    public void testStatus(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
        	logger.info("Test case got passed");
        	logger.info("__________________________________________________________________________________");
            extent_test.log(LogStatus.PASS, "Test case got passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            Screenshot.takeScreenShot(driver, result.getName());
            extent_test.log(LogStatus.ERROR, extent_test.addScreenCapture(System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".jpg"));
            extent_test.log(LogStatus.ERROR, result.getThrowable());
            extent_test.log(LogStatus.FAIL, "Test case got failed");
        }
        extent_report.flush();
        driver.quit();
    }
    
}
