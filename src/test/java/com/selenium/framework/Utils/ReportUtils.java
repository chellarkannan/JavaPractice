package com.selenium.framework.Utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.selenium.framework.base.TestBase;
import com.selenium.framework.extentReports.ExtentTestManager;

import java.util.*;

public class ReportUtils {

	WebDriver driver;
	String reportFolder=ExtentTestManager.getReportPath();
	String screenshotsFolder=reportFolder+"/screenshots";
	public ReportUtils(WebDriver driver) {
		this.driver=driver;
		new File(screenshotsFolder).mkdir();
	}
	
	private String takeScreenshot() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd_HH_mm_ss");
		String fileName=sdf.format(date);
		File screenshotName=new File(screenshotsFolder+"/"+fileName+".png");
		File scrnshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrnshotFile, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotName.getPath();
	}
	/**
	 * function to log pass message in extent report
	 */
	public void pass(String message) {
		ExtentTestManager.getTest().log(Status.PASS, message);
	}
	
	public void fail(String message) {
		ExtentTestManager.getTest().log(Status.FAIL, message);
	}
	
	public void passWithScreenshot(String message) {
		ExtentTestManager.getTest().log(Status.PASS, message, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
	}
	
	public void failWithScreenshot(String message) {
		ExtentTestManager.getTest().log(Status.FAIL, message, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
	}
}
