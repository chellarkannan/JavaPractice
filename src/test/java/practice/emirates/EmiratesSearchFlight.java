package practice.emirates;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmiratesSearchFlight {

    private static final String TEST_URL = "https://www.emirates.com/english/"; // URL to be tested
    private static final String OR_CALENDAR_LOWEST_PRICES = "//table[contains(@class,'calendar-grid')]//*[text()='Lowest price']";
    private static final String OR_continueButton= "(//*[text()='Continue'])[last()]";
    private static final String OR_FlightsAvailable= "//div[contains(@class,'flight-card-collapsed__wrapper')]";
    public static void main(String[] args) {
        System.out.println("Emirates Search Flight Placeholder");
       
        // Initialize WebDriver and navigate to the test URL
        WebDriver driver = new ChromeDriver();
        driver.get(TEST_URL);
        driver.manage().window().maximize();

        // List<WebElement> flightCards = driver.findElements(By.xpath(OR_FlightsAvailable));
        // for(WebElement flightCard : flightCards) {
            
        //     String flightDetails = flightCard.getText();
        //     System.out.println("Flight Details: " + flightDetails);
        // }
       //Click Search Flights and select the lowest price option

      

       // Take Screenshot of the page
       TakesScreenshot ts = (TakesScreenshot) driver;
       File src=ts.getScreenshotAs(OutputType.FILE);
       File dest = new File("screenshot.png");
       src.renameTo(dest); //move the screenshot to the destination
       System.out.println("Screenshot taken: " + dest.getAbsolutePath());
    

       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(OR_continueButton)));
         // Click on the "Search Flights" button
       js.executeScript("arguments[0].click();", driver.findElement(By.xpath(OR_continueButton)));
       
       // check document ready state using javascript executor  
        String readyState = (String) js.executeScript("return document.readyState");

        // Close the browser
        driver.quit();
    }
}
