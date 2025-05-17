package SeleniumBasics;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Herokuapp_testing {

    private static final String TEST_URL = "https://the-internet.herokuapp.com/"; // URL to be tested
    private static WebDriver driver;


    // Constructor to initialize WebDriver
    public Herokuapp_testing() {
        driver = new ChromeDriver(); // Initialize the WebDriver
    }

    public void shadowDom() {
        // Locate the shadow host
        WebElement shadowHost = driver.findElement(By.cssSelector("shadow-host-selector"));

        // Access the shadow root
        WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", shadowHost);

        // Now locate the element inside the shadow root
        WebElement elementInsideShadowDom = shadowRoot.findElement(By.cssSelector("element-selector"));

        // Perform actions on the element
        System.out.println(elementInsideShadowDom.getText());
    
    }

    //Methods
    public void launchURL(String url) {
        
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void main(String[] args) {
        
        Herokuapp_testing herokuapp= new Herokuapp_testing();
        
        herokuapp.launchURL(TEST_URL);
        // Close the browser
        
    }
}
