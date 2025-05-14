package practice.emirates;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmiratesAirline {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Launch the URL
        driver.get("https://www.emirates.com/in/english/");

        try {
            Thread.sleep(5000);

            WebElement acceptbutton = driver
                    .findElement(By.xpath("//div[@id='onetrust-consent-sdk']//button[text()='Accept']"));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
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

            // Select JFK from the list
            WebElement departureToSelect = driver.findElement(By.xpath(
                    "//*[contains(@class,'location-list')]//*[contains(@aria-label,'New York') and contains(@aria-label,'JFK')]/parent::li"));
            wait.until(ExpectedConditions.elementToBeClickable(departureToSelect));

            departureToSelect.click();

            // Enter Arrival Airport
            WebElement arrivalInput = driver.findElement(By.xpath(
                    "//div[@id='search-flight-control']//input[@name='Arrival airport']"));
            arrivalInput.click();
            arrivalInput.sendKeys("Chennai");

            // Select 'MAA' from the list
            WebElement arrivalToSelect = driver.findElement(By.xpath(
                    "(//div[@id='search-flight-control']//*[contains(@class,'location-list')]//*[contains(@aria-label,'Chennai') and contains(@aria-label,'India')]/parent::li)[last()-1]"));
            arrivalToSelect.click();

            // Select Departure Date
            Thread.sleep(5000);
            WebElement departureDate = driver.findElement(By.xpath(
                    "(//*[contains(@aria-label,'Sunday, 25  May 2025')])[last()-1]"));
            // WebElement departureDate =
            // driver.findElement(By.xpath("//div[@id='May_2025']/parent::div/parent::div[@class='CalendarMonth
            // CalendarMonth_1']/table//td[@id='14-05-2025']"));
            wait.until(ExpectedConditions.visibilityOf(departureDate));
            departureDate.click();

            // Select Return Date
            WebElement returnDate = driver.findElement(By.xpath(
                    "(//*[contains(@aria-label,'Friday, 20  June 2025')])[last()-1]"));
            wait.until(ExpectedConditions.elementToBeClickable(returnDate));
            returnDate.click();

            // Click 'Continue'
            WebElement continueButton = driver
                    .findElement(By.xpath("//span[text()='Search flights']/parent::button"));
            continueButton.click();

            // // Select No of Passengers
            // WebElement selectPassengers = driver.findElement(By.xpath(
            //         "//div[@id='passenger-combobox']//a[@class='link call-to-action-icon rsw-passengers_PASSENGER_TYPES call-to-action']"));
            // selectPassengers.click();
            // // By default 1 Adult passenger, increment one more adult passenger
            // WebElement incrementAdult = driver
            //         .findElement(By.xpath("//div[@class='rsw-increment-field']//button[@id='increment-ADT']"));
            // incrementAdult.click();

            // // By default 0 child passenger,increment one child passenger
            // WebElement incrementChild = driver
            //         .findElement(By.xpath("//div[@class='rsw-increment-field']//button[@id='increment-CHD']"));
            // incrementChild.click();

            // // Click 'Confirm'
            // WebElement confirmButton = driver
            //         .findElement(By.xpath("//div[@class='call-to-action__multiline-wrapper' and text()='Confirm']"));
            // confirmButton.click();

            // // Make sure the Total No of Passengers
            // WebElement totalPassengers = driver
            //         .findElement(By.xpath("//div[@id='passenger-combobox']//input[@value='3 Passengers']"));
            // String noOfPassengers = totalPassengers.getAttribute("value");
            // if (noOfPassengers.equals("3 Passengers")) {
            //     System.out.println("Correct, Total No of Passengers:" + noOfPassengers);
            // } else {
            //     System.out.println("Inorrect No of Passengers:");
            // }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // driver.quit();
    }

}
