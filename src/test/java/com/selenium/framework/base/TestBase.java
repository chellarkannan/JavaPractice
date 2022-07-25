package com.selenium.framework.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.awt.Desktop;
import java.io.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import com.selenium.framework.extentReports.ExtentTestManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public String workDir=System.getProperty("user.dir");
	Properties prop = new Properties();
	public String testBrowser="";
	public WebDriver driver;
	public String extentReportFolderPath="ExtentReport";
	String extentReportHTML=null;
	
	public TestBase(){
	try {
		FileInputStream fs = new FileInputStream(workDir+"/src/test/java/com/selenium/framework/properties/config.properties");
		prop.load(fs);
		testBrowser=prop.getProperty("browser");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
		String timestamp=sdf.format(date);		
		String folderName=getClass().getSimpleName()+"_"+timestamp;
		extentReportFolderPath=workDir+"/"+extentReportFolderPath+"/"+folderName;
		File extentReportFolder = new File(extentReportFolderPath);
		if(!extentReportFolder.exists())
			extentReportFolder.mkdirs();		
		extentReportHTML=extentReportFolderPath+"/"+folderName+".html";
		ExtentTestManager.getReporter(new File(extentReportHTML));
		ExtentTestManager.setReportPath(extentReportFolderPath);
		
	}catch(FileNotFoundException ex) {
		
	}
	catch(IOException ex) {
		
	}
	}
	
	public boolean launchBrowser(String URL) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		driver.manage().window().maximize();		
		driver.get(URL);
		return true;
	}
	
	@AfterClass()
	public void openReport() {
		Desktop deskApp= Desktop.getDesktop();
		ExtentTestManager.flush();
		try {
			deskApp.open(new File(extentReportHTML));
			driver.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
