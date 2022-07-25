package com.selenium.framework.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.selenium.framework.base.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.*;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentTestManager {
	
	private static ExtentReports extentReport=null;
	private static ExtentTest extentTest=null;
	private static String extentReportPath=null;
	public static WebDriver driver;
	public static void flush() {
		extentReport.flush();
	}
	
	public static void setDriver(WebDriver driver) {
		
	}
	public static void getReporter(File extentReportHTML) {
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportHTML);
		extentReport=new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.flush();
	}
	
	public static void setTest(String methodName,String description) {
		extentTest = extentReport.createTest(methodName, description);
	}
	
	public static void setReportPath(String path) {
		extentReportPath=path;
	}
	
	public static String getReportPath() {
		return extentReportPath;
	}
	public static ExtentTest getTest() {
		return extentTest;
	}
	
}
