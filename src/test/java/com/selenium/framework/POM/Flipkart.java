package com.selenium.framework.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.framework.Utils.DriverUtils;
import com.selenium.framework.Utils.ReportUtils;
import com.selenium.framework.extentReports.ExtentTestManager;

import java.util.List;

import org.openqa.selenium.By;


public class Flipkart {

	private WebDriver driver;
	private ReportUtils reportUtils;
	public final String closeLoginPopUp="//div[@class='_2QfC02']/button";
	public final String searchForProducts="//input[contains(@title,'Search for products')]";
	public final String productNames="//div[@class='_4rR01T']";
	public final String productSearchResults="//span[@class='_10Ermr']/span[.='${variable}']";
	public final String mainProductCategories="//div[span[.='Electronics']]/span"; //main category items 
	public final String subProductCategoriesHeaders=""; //sub category items - main classification
	public final String productsWithBankOffer="//a[@class='_1fQZEK' and (descendant::*[.='Bank Offer']]//div[@class='_4rR01T']";
	public final String productsWithoutBankOffer="//a[@class='_1fQZEK' and not(descendant::*[.='Bank Offer'])]//div[@class='_4rR01T']";
	public final String productsWithoutAnyOffer="//a[@class='_1fQZEK' and not(descendant::*[.='Bank Offer']) and not(descendant::*[normalize-space()='Off on Exchange'])]//div[@class='_4rR01T']";
	
	//identify mobile names with Exchange offer
	//identify mobile names without Exchange offer
	//identify main categories in sub category section which has child nodes
	
	DriverUtils driverUtils;
		
	public Flipkart(WebDriver driver,ReportUtils reportUtils) {
		this.driver=driver;
		this.reportUtils=reportUtils;
		driverUtils=new DriverUtils(driver);		
	}
	
	/**
	 * get the page title
	 * @return
	 */
	public boolean getPageTitle() {
		driver.findElement(By.xpath(closeLoginPopUp)).click();
		if(driver.getTitle().trim().contains("Online")) {
			reportUtils.passWithScreenshot("Landed in Flipkart Main Page");
		}
		return true;
	}
	
	/**
	 * check if search text box is present
	 */
	public boolean checkIfSearchTextBoxExists() {
		if(driverUtils.checkIfElementExists(searchForProducts)) {
			reportUtils.pass("Search textbox is present");
			return true;
		}
		else
			reportUtils.fail("Search textbox is not present");
		return false;
	}
	
	/**
	 * To get the product names from the search results
	 */
	public boolean getProductNamesFromsearchResults(String productType) {
		driverUtils.typeInTextBox(searchForProducts, productType);	
		driverUtils.checkIfElementExists(productSearchResults.replace("${variable}", productType));
		if(driverUtils.checkIfElementExists(productNames)) {
			List<WebElement> elements=driverUtils.getElements(productNames);
			reportUtils.pass(elements.size()+" - Search Results for "+productType);
			for(WebElement element:elements) {
				reportUtils.pass(element.getText());
			}
			return true;
		}
		return false;
	}
}
