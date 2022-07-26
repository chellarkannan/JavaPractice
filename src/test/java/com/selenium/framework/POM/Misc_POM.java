package com.selenium.framework.POM;

import org.openqa.selenium.WebDriver;

import com.selenium.framework.Utils.DriverUtils;
import com.selenium.framework.Utils.ReportUtils;

public class Misc_POM {

	public final String photoSource="//*[.='High Tatras']/..";
	public final String targetTray="//div[@id='trash']";
	WebDriver driver;
	ReportUtils reportUtils;
	DriverUtils driverUtils;
	
	public Misc_POM(WebDriver driver,ReportUtils reportUtils) {
		this.driver=driver;
		this.reportUtils=reportUtils;
		driverUtils=new DriverUtils(driver);		
	}
	
	public void dragImageToTrash() {
		driverUtils.dragNdrop(photoSource, targetTray);
	}
	
}
