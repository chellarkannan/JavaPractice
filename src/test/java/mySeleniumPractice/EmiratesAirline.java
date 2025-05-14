package mySeleniumPractice;

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
        driver.get("https://www.emirates.com/us/english/book/");
       
        try {
            Thread.sleep(5000);

            WebElement acceptbutton = driver.findElement(By.xpath("//div[@id='onetrust-consent-sdk']//button[text()='Accept']"));
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        //wait.until(ExpectedConditions.visibilityOf(acceptbutton));
        wait.until(ExpectedConditions.elementToBeClickable(acceptbutton));
        acceptbutton.click();

        // Makesure the Emirates Logo is displaying
        WebElement logo= driver.findElement(By.xpath("//div[@class='main-navigation']//img[@class='brand-logo__image-small']"));
        //wait.until(ExpectedConditions.visibilityOf(logo));
        if(logo.isDisplayed()){
            System.out.println("Emirates Logo is displayed");
        }
        else{
            System.out.println("Emirates logo is not displayed");
        }

        // Type Departure Airport
        Thread.sleep(5000);
        WebElement departureInput = driver.findElement(By.xpath("//div[contains(@class,'origin-destination__airport')]//label[text()='Departure Airport']/parent::span//input"));
        
        departureInput.click();
        departureInput.sendKeys("New York");

        // Select JFK from the list
        WebElement departureToSelect = driver.findElement(By.xpath("//div[@class='auto-suggest__list']/button[@data-testid='options_2']/div[@class='station-suggest-item__icons']/span[@class='auto-suggest__code' and text()='JFK']"));
        wait.until(ExpectedConditions.elementToBeClickable(departureToSelect));

        departureToSelect.click();

        //Enter Arrival Airport
        WebElement arrivalInput = driver.findElement(By.xpath("//div[@class='origin-destination__airportField']//label[text()='Arrival Airport']/parent::span//input"));
        arrivalInput.click();
        arrivalInput.sendKeys("Chennai");

        // Select 'MAA' from the list
        WebElement arrivalToSelect = driver.findElement(By.xpath("//div[@class='auto-suggest__list']/button[@data-testid='options_0']/div[@class='station-suggest-item__icons']/span[@class='auto-suggest__code' and text()='MAA']"));
        arrivalToSelect.click();

        // Select Departure Date
        Thread.sleep(5000);
        WebElement departureDate = driver.findElement(By.xpath("//div[@id='May_2025']/parent::div/parent::div[@class='CalendarMonth CalendarMonth_1']/table//a[text()='14']"));
        //WebElement departureDate = driver.findElement(By.xpath("//div[@id='May_2025']/parent::div/parent::div[@class='CalendarMonth CalendarMonth_1']/table//td[@id='14-05-2025']"));
        wait.until(ExpectedConditions.visibilityOf(departureDate));
        departureDate.click();

        // Select Return Date
        WebElement returnDate = driver.findElement(By.xpath("//div[@id='June_2025']/parent::div/parent::div[@class='CalendarMonth CalendarMonth_1']/table//a[text()='20']"));
        wait.until(ExpectedConditions.elementToBeClickable(returnDate));
        returnDate.click();

        // Click 'Continue'
        WebElement continueButton= driver.findElement(By.xpath("//div[@class='call-to-action__multiline-wrapper' and text()='Continue']"));
        continueButton.click();

        // Select No of Passengers
        WebElement selectPassengers = driver.findElement(By.xpath("//div[@id='passenger-combobox']//a[@class='link call-to-action-icon rsw-passengers_PASSENGER_TYPES call-to-action']"));
        selectPassengers.click();
        // By default 1 Adult passenger, increment one more adult passenger
        WebElement incrementAdult = driver.findElement(By.xpath("//div[@class='rsw-increment-field']//button[@id='increment-ADT']"));
        incrementAdult.click();

        // By default 0 child passenger,increment one child passenger
        WebElement incrementChild = driver.findElement(By.xpath("//div[@class='rsw-increment-field']//button[@id='increment-CHD']"));
        incrementChild.click();

        // Click 'Confirm'
        WebElement confirmButton= driver.findElement(By.xpath("//div[@class='call-to-action__multiline-wrapper' and text()='Confirm']"));
        confirmButton.click();

        // Make sure the Total No of Passengers 
        WebElement totalPassengers= driver.findElement(By.xpath("//div[@id='passenger-combobox']//input[@value='3 Passengers']"));
        String noOfPassengers = totalPassengers.getAttribute("value");
        if(noOfPassengers.equals("3 Passengers")){
            System.out.println("Correct, Total No of Passengers:"+noOfPassengers);
        }
        else{
            System.out.println("Inorrect No of Passengers:");
        }
        

        

        

        
            

       
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        
        //driver.quit();
    }

    
    
    
}
