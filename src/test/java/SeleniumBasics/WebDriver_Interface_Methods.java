package SeleniumBasics;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


public class WebDriver_Interface_Methods {

    public void findElementById(String id) {
           
    }

    public static void main(String[] args) {
       
        String testURL = "https://rahulshettyacademy.com/AutomationPractice/";        
        System.out.println("Basic Browser Actions Placeholder");
        WebDriver driver = new ChromeDriver();  // 
        driver.get(testURL);

        // maximize the browser window
        driver.manage().window().maximize(); // Maximize the browser window

        // Enter Text
        String nameTextField= "//input[@id='name']";
        WebElement textField = driver.findElement(By.xpath(nameTextField));
        textField.sendKeys("Selenium WebDriver"); // Enter text in the text field
        System.out.println("Text entered in the text field: " + textField.getAttribute("value")); // Print the entered text
        
        // Click Option 2
        String selectOption="2";
        String checkboxElement = "//input[@id='checkBoxOption<Option>']";
        checkboxElement = checkboxElement.replace("<Option>", selectOption); // Replace <Option> with the selected option
        WebElement checkbox = driver.findElement(By.xpath(checkboxElement));
        checkbox.click(); // Click the checkbox

        
        String selectDropDown= "//select[@id='dropdown-class-example']";
        WebElement selectDropDownElement = driver.findElement(By.xpath(selectDropDown));
        Select dropDown = new Select(selectDropDownElement);
        dropDown.selectByValue("option2"); // Select the option with value "option2"
        System.out.println("Selected option: " + dropDown.getFirstSelectedOption().getText()); // Print the selected option
    
        String availableOptions = "//select[@id='dropdown-class-example']/option";
        List<WebElement> availableOptionsElement = driver.findElements(By.xpath(availableOptions));
        System.out.println("Total Options :"+availableOptionsElement.size()); // Get the second option from the dropdown
    
        // Enter search Textt and select the matching suggestion
        String searchText = "Ind";
        String searchTextField = "//input[@id='autocomplete']";
        
        // use Expected Conditions to wait for the element to be present
        WebElement searchField = driver.findElement(By.xpath(searchTextField));
        searchField.sendKeys(searchText); // Enter text in the search field
        System.out.println("Text entered in the search field: " + searchField.getAttribute("value")); // Print the entered text
        
    }
}
