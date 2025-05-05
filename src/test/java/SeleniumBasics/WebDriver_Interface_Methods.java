package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver_Interface_Methods {

    public static void main(String[] args) {
       
        String testURL = "https://rahulshettyacademy.com/AutomationPractice/";
        System.out.println("Basic Browser Actions Placeholder");
        WebDriver driver = new ChromeDriver();
        driver.get(testURL);
       
        System.out.println(driver.getTitle()); // Print the title of the page
        System.out.println(driver.getCurrentUrl()); // Print the current URL of the page
        System.out.println(driver.getPageSource()); // Print the page source

        // Locators






        
    }
}
