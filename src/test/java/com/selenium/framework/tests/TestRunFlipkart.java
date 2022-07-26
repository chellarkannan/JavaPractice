package com.selenium.framework.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.framework.POM.Flipkart;
import com.selenium.framework.Utils.ReportUtils;
import com.selenium.framework.base.TestBase;
import com.selenium.framework.extentReports.ExtentTestManager;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class TestRunFlipkart extends TestBase{
	public ExtentTest extentTest;
	ReportUtils reportUtils;
	Flipkart fk;
	
	@BeforeClass()
	public void initialization() {
		launchBrowser("https://www.flipkart.com");	
		reportUtils = new ReportUtils(driver);
		fk= new Flipkart(driver,reportUtils);
	}

	@BeforeMethod()
	public void setUpReport(Method method) {
		Test test = method.getAnnotation(Test.class);
		ExtentTestManager.setTest(test.description(), extentReportFolderPath);
		
	}
	@DataProvider(name="SearchProducts")
	public Object[][] allproductNames(){
		return new Object[][]{ {"Mobiles"},{"Laptops"},{"TV"}};
		
	}
	
	@Test(priority=0,description="Verify Page Title")
	public void verifyPageTitle() {
		fk.getPageTitle();
	}
	
	@Test(priority=2,description="Get Mobiles in First Page")
	public void getMobilesInFirstPage() {
		
	}
	
	@Test(priority=1,description="Check Search TextBox")
	public void checkIfSearchTextboxExists() {
		fk.checkIfSearchTextBoxExists();
			
	}
	@Test(priority=3,dataProvider="SearchProducts",description="Get Product names from First page of results")
	public void getProductNames(String productType) {
		fk.getProductNamesFromsearchResults(productType);
	}
	
}
