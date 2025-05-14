package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SeleniumActionsExample {


    /**
     * Demonstrates how to work with Chrome DevTools Protocol
     * For advanced browser automation and network monitoring
     */
    private static void chromeDevToolsExample(WebDriver driver) {
        // Note: This requires ChromeDriver 75+ and Selenium 4+
        
        // Example usage would be:
        // 1. Network interception and modification
        // 2. Performance metrics collection
        // 3. Console log monitoring
        // 4. JavaScript coverage analysis
        // 5. Geolocation mocking
        
        System.out.println("Chrome DevTools Protocol integration requires Selenium 4");
        System.out.println("Example implementation would involve DevTools class usage");
    }    /**
     * Sets up Chrome with various ChromeOptions configurations
     * Demonstrates the most commonly used Chrome options for WebDriver
     */
    private static WebDriver setupChromeOptionsExample() {
        ChromeOptions options = new ChromeOptions();
        
        // 1. Browser Window Options
        options.addArguments("--start-maximized");               // Maximize window
        // options.addArguments("--window-size=1920,1080");      // Set specific window size
        // options.addArguments("--headless=new");               // Run in headless mode (no UI)
        
        // 2. Performance Options
        options.addArguments("--disable-extensions");            // Disable extensions
        options.addArguments("--disable-gpu");                   // Disable GPU acceleration
        options.addArguments("--disable-dev-shm-usage");         // Overcome limited resource problems
        options.addArguments("--no-sandbox");                    // Bypass OS security model
        
        // 3. Network Options
        options.addArguments("--proxy-server=http://proxy:8080"); // Set proxy
        options.addArguments("--ignore-certificate-errors");     // Ignore SSL certificate errors
        
        // 4. Privacy & Security Options
        options.addArguments("--incognito");                     // Run in incognito mode
        options.addArguments("--disable-notifications");         // Disable notifications
        
        // 5. Mobile Emulation
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        // options.setExperimentalOption("mobileEmulation", mobileEmulation);  // Uncomment to enable
        
        // 6. File Downloads
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "downloads");
        prefs.put("download.prompt_for_download", false);
        prefs.put("plugins.always_open_pdf_externally", true);   // Auto-download PDFs instead of opening them
        options.setExperimentalOption("prefs", prefs);
        
        // 7. User Agent Modification
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36");
        
        // 8. Browser Logging
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-logging"}); // Disable "DevTools listening on..."
        
        // 9. Language Options
        options.addArguments("--lang=en-US");                    // Set browser language
        
        // 10. Geolocation
        // Note: Requires browser permissions at runtime
        Map<String, Object> geoLocation = new HashMap<>();
        geoLocation.put("latitude", 37.422);                     // Google HQ coordinates
        geoLocation.put("longitude", -122.084);
        geoLocation.put("accuracy", 100);
        
        // Create and return the WebDriver with options
        System.out.println("Chrome browser starting with configured options...");
        return new ChromeDriver(options);
    }

    public static void main(String[] args) {
              
        // Display Chrome options examples
        WebDriver driver = setupChromeOptionsExample();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // Create Actions object
            Actions actions = new Actions(driver);
            
            // Example 1: Drag and Drop
            dragAndDropExample(driver, actions, wait);
            
            // Example 2: Mouse Hover (hover to display dropdown)
           /* mouseHoverExample(driver, actions, wait);
            
            // Example 3: Right Click (Context Click)
            rightClickExample(driver, actions, wait);
            
            // Example 4: Double Click
            doubleClickExample(driver, actions, wait);
            
            // Example 5: Click and Hold (Bonus example)
            clickAndHoldExample(driver, actions, wait);
            
            // Example 6: Move by Offset (Bonus example)
            moveByOffsetExample(driver, actions, wait);
            
            // Example 7: Key combinations with mouse actions
            keyboardWithMouseExample(driver, actions, wait);*/
            
        } finally {
            // Close the browser
            driver.quit();
        }
    }
    
    private static void dragAndDropExample(WebDriver driver, Actions actions, WebDriverWait wait) {
        // Navigate to a site with drag-and-drop functionality
        driver.get("https://jqueryui.com/droppable/");
        
        // Switch to the iframe containing the elements
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        
        // Find source and target elements
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        
        // Method 1: Using the dragAndDrop method
        actions.dragAndDrop(source, target).perform();
        
        // Verify drop was successful
        wait.until(ExpectedConditions.textToBePresentInElement(target, "Dropped!"));

        // Switch back to the main content
        driver.switchTo().defaultContent();
        
        System.out.println("Drag and drop completed successfully!");
        
        // Alternative approach for sites where direct dragAndDrop doesn't work
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        
        source = driver.findElement(By.id("draggable"));
        target = driver.findElement(By.id("droppable"));
        
        // Method 2: Using clickAndHold, moveToElement, and release
        actions.clickAndHold(source)
              .moveToElement(target)
              .release()
              .perform();
              
        driver.switchTo().defaultContent();
    }
    
    private static void mouseHoverExample(WebDriver driver, Actions actions, WebDriverWait wait) {
        // Navigate to a site with hover menus
        driver.get("https://the-internet.herokuapp.com/hovers");
        
        // Find the element to hover over
        WebElement hoverElement = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        
        // Perform hover action
        actions.moveToElement(hoverElement).perform();
        
        // Wait for the hidden element to become visible after hover
        WebElement hiddenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='figure'])[1]//div[@class='figcaption']/h5")));
        
        System.out.println("Hover revealed text: " + hiddenElement.getText());
    }
    
    private static void rightClickExample(WebDriver driver, Actions actions, WebDriverWait wait) {
        // Navigate to a site for right-click testing
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        
        // Find the element to right-click on
        WebElement rightClickElement = driver.findElement(By.xpath("//span[text()='right click me']"));
        
        // Perform right-click action (contextClick)
        actions.contextClick(rightClickElement).perform();
        
        // Find and click on a context menu item
        WebElement menuItem = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(@class, 'context-menu-item')]/span[text()='Edit']")));
        menuItem.click();
        
        // Handle the alert that pops up
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        
        System.out.println("Right-click context menu item clicked. Alert text: " + alertText);
    }
    
    private static void doubleClickExample(WebDriver driver, Actions actions, WebDriverWait wait) {
        // Navigate to a site with double-click functionality
        driver.get("https://demoqa.com/buttons");
        
        // Find the element to double-click
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        
        // Perform double-click action
        actions.doubleClick(doubleClickBtn).perform();
        
        // Verify the double-click was successful
        WebElement doubleClickMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("doubleClickMessage")));
        
        System.out.println("Double-click message: " + doubleClickMsg.getText());
    }
    
    private static void clickAndHoldExample(WebDriver driver, Actions actions, WebDriverWait wait) {
        // Navigate to a site for click and hold testing
        driver.get("https://jqueryui.com/slider/");
        
        // Switch to the iframe
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        
        // Find the slider handle
        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
        
        // Get the initial position of the slider
        int initialPosition = slider.getLocation().getX();
        
        // Click and hold the slider, move it to the right, then release
        actions.clickAndHold(slider)
               .moveByOffset(50, 0) // Move 50 pixels to the right
               .release()
               .perform();
        
        // Verify the slider moved
        int newPosition = slider.getLocation().getX();
        System.out.println("Slider moved from X=" + initialPosition + " to X=" + newPosition);
        
        driver.switchTo().defaultContent();
    }
    
    private static void moveByOffsetExample(WebDriver driver, Actions actions, WebDriverWait wait) {
        // Navigate to a drawing canvas page
        driver.get("https://www.youidraw.com/apps/painter/");
        
        // Find the canvas element
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("svgcanvas")));
        WebElement canvas = driver.findElement(By.id("svgcanvas"));
        
        // Move to the canvas center first
        actions.moveToElement(canvas).perform();
        
        // "Draw" a simple shape by moving the mouse with clickAndHold
        actions.clickAndHold()
               .moveByOffset(50, 0)
               .moveByOffset(0, 50)
               .moveByOffset(-50, 0)
               .moveByOffset(0, -50)
               .release()
               .perform();
        
        System.out.println("Drew a square shape using moveByOffset");
    }
    
    private static void keyboardWithMouseExample(WebDriver driver, Actions actions, WebDriverWait wait) {
        // Navigate to a text editor
        driver.get("https://www.example.com"); // Replace with a suitable site
        
        // Find a text input element
        WebElement textInput = driver.findElement(By.tagName("body"));
        
        // Click on the text input to focus it
        actions.moveToElement(textInput).click().perform();
        
        // Perform a keyboard shortcut (Ctrl+A to select all text)
        actions.keyDown(org.openqa.selenium.Keys.CONTROL)
               .sendKeys("a")
               .keyUp(org.openqa.selenium.Keys.CONTROL)
               .perform();
        
        System.out.println("Performed keyboard shortcut (Ctrl+A)");
    }
}