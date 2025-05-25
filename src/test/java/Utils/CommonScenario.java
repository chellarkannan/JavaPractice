package Utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonScenario {

    public final static String TEST_URL = "https://www.emirates.com/english/"; // URL to be tested
    public CommonScenario(){
        
    }
    
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void launchBrowser(){
        if (getDriver() == null) {
            initializeDriver();
            getDriver().get(TEST_URL);
        } else {
            System.out.println("WebDriver is already initialized.");
        }
    }
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void removeDriver() {
        driver.remove();
    }

    public static void initializeDriver() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setDriver(webDriver);
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            removeDriver();
        }
    }

    public static String takeScreenshot(){
        // Placeholder for screenshot functionality
        System.out.println("Taking screenshot...");
        // Implement screenshot logic here
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"screenshots"+File.separator+"screenshot_" + timestamp + ".png";
        try {
            FileUtils.copyFile(source, new File(screenshotPath));
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot: " + e.getMessage(), e);
        }
        return screenshotPath;
    }
    

    
}
