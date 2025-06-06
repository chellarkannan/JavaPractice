package practice.emirates;
import java.nio.file.Path;
import java.util.Map;

import org.checkerframework.framework.qual.DefaultQualifier.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonScenario;
import Utils.ExcelUtils;
import Utils.ExtentTestManager;
import Utils.TestNGListenerClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(TestNGListenerClass.class) // Registering the TestNG listener
public class Emirates_Search_Test_Scenarios extends CommonScenario{

    @DataProvider(name = "flightSearchDataExcel") // packing data
    public Object[][] flightSearchDataProvider() {
        try{
            String sheetPath = Path.of(System.getProperty("user.dir"),"TestData", "Emirates_Flight_Search_Data.xlsx").toString();
            return ExcelUtils.readExcelSheet(sheetPath,"Test");
        }catch(Exception e){
            System.out.println("Error reading Excel data: " + e.getMessage());
            return new Object[][] {};
        }
    }

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver and other configurations here
        System.out.println("Setting up the test environment...");
    }

    @BeforeMethod
    public void beforeMethod() {
        // This method will run before each test method
        System.out.println("Running before each test method...");
    }

    @AfterMethod
    public void afterMethod() {
        // This method will run after each test method
        System.out.println("Running after each test method...");
    }

    @Test(groups = {"smoke", "regression"})
    public void testGroupExample() {
        System.out.println("Testing with groups: smoke and regression...");
        // Add your test code here
    }

    @Test(dataProvider = "flightSearchDataExcel")
    public void TestMethod_1(Map<Object, Object> flightData) {
        ExtentTestManager.pass("Dpearture Airport: " + flightData.get("DepartureAirport").toString());
        ExtentTestManager.pass("Departure Code: " + flightData.get("DepartureCode").toString());
    }

    @Test(dataProvider = "flightSearchDataExcel")
    public void TestMethod_2(Map<Object, Object> flightData) {
        ExtentTestManager.pass("Dpearture Airport: " + flightData.get("DepartureAirport").toString());
        ExtentTestManager.pass("Departure Code: " + flightData.get("DepartureCode").toString());
    }

    @Test(dataProvider = "flightSearchDataExcel")
    public void TestMethod_3(Map<Object, Object> flightData) {
        ExtentTestManager.pass("Dpearture Airport: " + flightData.get("DepartureAirport").toString());
        ExtentTestManager.pass("Departure Code: " + flightData.get("DepartureCode").toString());
    }

    @AfterClass
    public void tearDown() {
        // Clean up and close the WebDriver here
        System.out.println("Tearing down the test environment...");
    }
}
