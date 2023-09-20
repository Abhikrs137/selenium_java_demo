package Utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    public static void takeScreenShot(WebDriver driver, String FailCases) {
        String screenshotFileName = System.getProperty("user.dir") + "\\Screenshots\\" + FailCases + ".jpg";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File(screenshotFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
