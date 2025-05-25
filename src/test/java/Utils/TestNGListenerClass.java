package Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;


public class TestNGListenerClass implements ITestListener {

    List<String>testMethods = new ArrayList<String>();

    public void onStart(ITestContext context) {
   
    System.out.println("Test suite started: " + context.getName());
    try {
        
       
    } catch (Exception e) {
        System.out.println("Error while reading DataProvider values: " + e.getMessage());
    }
            
       
    }
    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.flush();
        System.out.println("All tests finished.");
    }
    @Override
    @SuppressWarnings("unchecked")
    public void onTestStart(ITestResult result) {
    String methodName = result.getMethod().getMethodName();
    if(!testMethods.contains(methodName)){
        ExtentTestManager.startTest(methodName, "");
        testMethods.add(methodName);
    }

    if(result.getParameters().length>0){
    Map<Object,Object> testData=(Map<Object,Object>)result.getParameters()[0];
    
     String testObjective= testData.get("TestObjective").toString() !=null ? testData.get("TestObjective").toString() : " Add Proper Test Objective";
     ExtentTest node= ExtentTestManager.addNode(testObjective, "First Iteration of the test");
     node.pass("Test started: " + result.getName());
    }   
}     
    

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    // Other overridden methods can be added here as needed



}
