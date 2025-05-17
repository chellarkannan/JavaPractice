package practice.emirates;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmiratesAirline {


// declare  all xpath vriables here 
        private static WebDriver driver = new ChromeDriver();
        private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        private static final String acceptButton="";
        private static final String originLocator = "//*[contains(@class,'location-list')]//*[contains(@aria-label,'$origin') and contains(@aria-label,'$airport')]/parent::li";
                                

// function to launch browser and navigate to testURL

// function to check handle accept pop up button

// function to clear the departure airport

// function to select the departure airport
public void selectDepartureAirport(String origin, String airport){

        try{
        String departureElementToSelect = originLocator.replace("$origin", origin).replace("$airport", airport);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(departureElementToSelect)));
        WebElement departureToSelect = driver.findElement(By.xpath(departureElementToSelect));
        departureToSelect.click();
        }catch(Exception e){
            System.out.println("Error in selecting departure airport: " + e.getMessage());
        }
}

// function to select the arrival airport

// function to select the departure date

// function to select the return date

// function to click continue button

// add adult passenger 

// add child passenger

// add infant passenger 

// function to check if page navigate to expected page 

// -- all function templates above are page object model functions --

// -- all function templates below are test functions --


// Test Function - Check if user is able to perform search flights with default passenger count. 

// Test Function - check if I can add child passenger - 6

// Test Function - check if I can add infant passenger - 2

// Test Function - check if I can reduce adult passenger below 1

// Test Function - check if I can add adult passenger - 9 and see add button is disabled

// Test Function - check if I can add adult passenger - 7, child 1, infant 1 and see all add buttons are disabled
  


public static void main(String[] args) {

        
        // Launch the URL
        driver.get("https://www.emirates.com/in/english/");
        driver.manage().window().maximize();

        try {
            Thread.sleep(5000);
            WebElement acceptbutton = driver
                    .findElement(By.xpath("//div[@id='onetrust-consent-sdk']//button[text()='Accept']"));

                        // wait.until(ExpectedConditions.visibilityOf(acceptbutton));
            wait.until(ExpectedConditions.elementToBeClickable(acceptbutton));
            acceptbutton.click();

            /* 
            // Makesure the Emirates Logo is displaying
            WebElement logo = driver
                    .findElement(By.xpath("//div[@class='main-navigation']//img[@class='brand-logo__image-small']"));
            // wait.until(ExpectedConditions.visibilityOf(logo));
            if (logo.isDisplayed()) {
                System.out.println("Emirates Logo is displayed");
            } else {
                System.out.println("Emirates logo is not displayed");
            }*/

            // Type Departure Airport
            Thread.sleep(5000);
            WebElement clearDepartureInput = driver.findElement(By.xpath("//div[@id='search-flight-control']//label[text()='Departure airport']/../button[@name='clear Departure airport']"));
            clearDepartureInput.click();
            WebElement departureInput = driver.findElement(By.xpath(
                    "//div[@id='search-flight-control']//input[@name='Departure airport']"));

            departureInput.click();
            departureInput.sendKeys("New York");

            

            // Enter Arrival Airport
            WebElement arrivalInput = driver.findElement(By.xpath(
                    "//div[@id='search-flight-control']//input[@name='Arrival airport']"));
            arrivalInput.click();
            arrivalInput.sendKeys("Chennai");

            // Select 'MAA' from the list
            String arrivalElementToSelect = "//div[@class='destination-dropdown']//*[contains(@class,'location-list')]//*[contains(@aria-label,'Chennai') and contains(@aria-label,'MAA')]/parent::li";;
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(arrivalElementToSelect)));
            WebElement arrivalToSelect = driver.findElement(By.xpath(
                        arrivalElementToSelect));
            arrivalToSelect.click();

            // Select Departure Date
            Thread.sleep(5000);
            WebElement departureDate = driver.findElement(By.xpath(
                    "//*[@class='search-flight__section grid']//*[contains(@aria-label,'Sunday, 25  May 2025')]"));
            // WebElement departureDate =
            // driver.findElement(By.xpath("//div[@id='May_2025']/parent::div/parent::div[@class='CalendarMonth
            // CalendarMonth_1']/table//td[@id='14-05-2025']"));
            //wait.until(ExpectedConditions.visibilityOf(departureDate));
            departureDate.click();

            // Select Return Date
            WebElement returnDate = driver.findElement(By.xpath(
                    "//*[@class='search-flight__section grid']//*[contains(@aria-label,'Friday, 20  June 2025')]"));
           // wait.until(ExpectedConditions.elementToBeClickable(returnDate));
            returnDate.click();

            // Click 'Continue'
            WebElement continueButton = driver
                    .findElement(By.xpath("//span[text()='Search flights']/parent::button"));
            continueButton.click();

            // check by default 1 adult passenger is selected, 0 child is listed o infant is displayed

            // check if 9 adults are selected

            // check if 10 adults are selected.

           

            
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // driver.quit();
    }

}
