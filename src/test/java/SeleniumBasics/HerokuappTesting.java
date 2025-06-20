package SeleniumBasics;
import java.io.File;
import java.util.HashMap;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class HerokuappTesting {
    private static final String TEST_URL = "https://the-internet.herokuapp.com/";
    private static final String DOWNLOADS_DIR = System.getProperty("user.dir") + File.separator + "downloads";
    private WebDriver driver;

    // Constructor to initialize WebDriver
    public HerokuappTesting() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-password-manager-reauthentication");
        options.setExperimentalOption("prefs", new HashMap<String, Object>() {{
            put("download.default_directory", DOWNLOADS_DIR);
            put("download.prompt_for_download", false);
            put("download.directory_upgrade", true);
        }});
        driver = new ChromeDriver(options);
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void launchURL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void uploadSampleFile(String filePath) {
        try {
            WebElement fileUploadLink = driver.findElement(By.linkText("File Upload"));
            fileUploadLink.click();
            WebElement fileInput = driver.findElement(By.id("file-upload"));
            fileInput.sendKeys(filePath);
            WebElement uploadButton = driver.findElement(By.id("file-submit"));
            uploadButton.click();
            takeScreenshot("upload_screenshot_");
            System.out.println("File uploaded successfully: " + filePath);
        } catch (Exception ex) {
            System.out.println("An error occurred while uploading the file: " + ex.getMessage());
        }
    }

    public void downloadFile(String filename) {
        try {
            WebElement fileDownloadLink = driver.findElement(By.linkText("File Download"));
            fileDownloadLink.click();
            WebElement fileLink = driver.findElement(By.linkText(filename));
            fileLink.click();
            Thread.sleep(2000);
            File downloadedFile = new File(DOWNLOADS_DIR + File.separator + filename);
            if (downloadedFile.exists()) {
                System.out.println("File downloaded successfully: " + filename);
            } else {
                throw new RuntimeException("File download failed: " + filename);
            }
        } catch (Exception ex) {
            System.out.println("An error occurred while downloading the file: " + ex.getMessage());
        }
    }

    public void handleCookies() {
        try {
            driver.findElement(By.linkText("Form Authentication")).click();
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            
            var cookies = driver.manage().getCookies();
            System.out.println("Current cookies:");
            for (var cookie : cookies) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
            org.openqa.selenium.Cookie customCookie = new org.openqa.selenium.Cookie("testCookie", "testValue");
            driver.manage().addCookie(customCookie);
            driver.navigate().to(TEST_URL);
            driver.get("https://the-internet.herokuapp.com/secure");
            takeScreenshot("secure_page_screenshot_");
            driver.manage().deleteCookieNamed("testCookie");
            driver.manage().deleteAllCookies();
        } catch (Exception e) {
            System.out.println("Error handling cookies: " + e.getMessage());
        }
    }

    public void shadowDomExample() {
        try {
            WebElement shadowHost = driver.findElement(By.cssSelector("shadow-host-selector"));
            WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].shadowRoot", shadowHost);
            WebElement elementInsideShadowDom = shadowRoot.findElement(By.cssSelector("element-selector"));
            System.out.println(elementInsideShadowDom.getText());
        } catch (Exception ex) {
            System.out.println("Error accessing Shadow DOM: " + ex.getMessage());
        }
    }

    private void takeScreenshot(String prefix) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = String.valueOf(System.currentTimeMillis());
            File destination = new File(prefix + timestamp + ".png");
            FileUtils.copyFile(screenshot, destination);
            System.out.println("Screenshot saved as: " + destination.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error taking screenshot: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        HerokuappTesting herokuapp = new HerokuappTesting();
        try {
            herokuapp.launchURL(TEST_URL);
            String filePath = System.getProperty("user.dir") + File.separator + "README.md";
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File does not exist: " + filePath);
                return;
            }
            //herokuapp.uploadSampleFile(filePath);
            //herokuapp.downloadFile("Jpeg_with_exif.jpeg");
            herokuapp.handleCookies();
        } finally {
            herokuapp.quit();
        }
    }
}
