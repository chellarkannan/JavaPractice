package practice.emirates;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListenerClass implements ITestListener {

    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
        
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("All tests finished.");
    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
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
