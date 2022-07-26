package com.selenium.framework.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.framework.POM.Flipkart;
import com.selenium.framework.POM.Misc_POM;
import com.selenium.framework.Utils.ReportUtils;
import com.selenium.framework.base.TestBase;

public class Misc extends TestBase {

	ReportUtils reportUtils;
	Misc_POM misc;
	@BeforeClass()
	public void initialization() {
		launchBrowser("https://www.globalsqa.com/demo-site/draganddrop/");	
		reportUtils = new ReportUtils(driver);
		misc=new Misc_POM(driver,reportUtils);
	}
	
	@Test()
	public void dragNdropImages() {
		misc.dragImageToTrash();
	}
}
