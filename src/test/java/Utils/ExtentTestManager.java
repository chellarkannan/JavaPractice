package Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.io.IOException;


    public class ExtentTestManager {
        private static ExtentReports extent;
        private static ExtentTest test;
        private static ExtentSparkReporter sparkReporter;
        private static final String REPORT_PATH = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "ExtentReport.html";

        // Initialize the ExtentReports
        public static void initializeReporter() {
            sparkReporter = new ExtentSparkReporter(REPORT_PATH);
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }

        // Start a new test
        public static void startTest(String testName, String description) {
            test = extent.createTest(testName, description);
        }

        // Mark test as Pass
        public static void pass(String message) {
            test.pass(message);
        }

        // Mark test as Fail
        public static void fail(String message) {
            test.fail(message);
        }

        // Take a screenshot and attach to the report
        public static void takeScreenshot(String screenshotPath) {
            try {
                File screenshot = new File(screenshotPath);
                if (screenshot.exists()) {
                    test.addScreenCaptureFromPath(screenshotPath);
                } else {
                    test.warning("Screenshot not found at: " + screenshotPath);
                }
            } catch (Exception e) {
                test.warning("Failed to attach screenshot: " + e.getMessage());
            }
        }

        // Generate the HTML report
        public static void generateHTML() {
            if (extent != null) {
                extent.flush();
            }
        }

        // Generate a test reporter
        public static ExtentReports getReporter() {
            if (extent == null) {
                throw new IllegalStateException("ExtentReports is not initialized. Call initializeReporter() first.");
            }
            return extent;
        }
    }

