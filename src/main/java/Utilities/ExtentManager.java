package Utilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import java.io.File;

public class ExtentManager {
    public static ExtentReports extent;

    public static ExtentReports getInstance(String FailCases) {
        if (extent == null) {
            extent = new ExtentReports(FailCases, true, DisplayOrder.NEWEST_FIRST);
            
            extent.loadConfig(new File(System.getProperty("user.dir") + "//resources//reportConfig.xml"));
            extent.addSystemInfo("Selenium Version", "3.141.59").addSystemInfo("Environment", "QA");
        }

        return extent;
    }
}
