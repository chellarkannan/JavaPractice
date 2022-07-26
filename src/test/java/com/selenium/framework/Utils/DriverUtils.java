package com.selenium.framework.Utils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

	WebDriver driver;
	WebDriverWait wait;
	Wait<WebDriver> fluentWait;

	public DriverUtils(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
	}

	/**
	 * To ensure availability of a webElement
	 * 
	 * @param elementXpath
	 * @return
	 */
	public boolean checkIfElementExists(String elementXpath) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}

	}

	/**
	 * get list of elements
	 * 
	 * @param elementXpath
	 * @return
	 */
	public List<WebElement> getElements(String elementXpath) {
		List<WebElement> elements = driver.findElements(By.xpath(elementXpath));
		return elements;
	}

	public boolean typeInTextBox(String elementXpath, String text) {
		JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
		if (checkIfElementExists(elementXpath)) {
			driver.findElement(By.xpath(elementXpath)).sendKeys(Keys.CONTROL + "a");
			driver.findElement(By.xpath(elementXpath)).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(elementXpath)).sendKeys(text);
			driver.findElement(By.xpath(elementXpath)).sendKeys(Keys.ENTER);
			String valueInText = (String) jsExecutor.executeScript("return arguments[0].value",
					driver.findElement(By.xpath(elementXpath)));
			if (valueInText.equals(text))
				return true;
		}
		return false;
	}

	public boolean dragNdrop(String source, String target) {

		Actions action = new Actions(driver);
		if (checkIfElementExists(target) && checkIfElementExists(source)) {
			WebElement objSource = driver.findElement(By.xpath(source));
			WebElement objTarget = driver.findElement(By.xpath(target));
			action.clickAndHold(objSource).moveToElement(objTarget).build().perform();
			return true;
		}
		return false;
	}
}
