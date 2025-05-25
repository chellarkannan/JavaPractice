package Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


    public class ExtentTestManager {
        private static ExtentReports extent;
        private static ExtentTest test;
        private static ExtentTest currentNode;
        private static ExtentSparkReporter sparkReporter;
        private static String REPORT_PATH = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "$Test.html";
        private static String screenshotsPath=System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "screenshots";
        // Initialize the ExtentReports
        public static void initializeReporter(String testClassName) {
            REPORT_PATH=REPORT_PATH.replace("$Test",testClassName);
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

        // Add a node to the current test
        public static ExtentTest addNode(String nodeName, String description) {
            if (test == null) {
            throw new IllegalStateException("No active test. Start a test before adding a node.");
            }
            currentNode= test.createNode(nodeName, description);
            return currentNode;
          
        }

        
        // Mark test as Pass
        public static void pass(String message) {
            currentNode.pass(message);
           // attachScreenshot(message);
           
        }

        

        // Mark test as Fail
        public static void fail(String message) {
            test.fail(message);
        }

        // Take a screenshot and attach to the report
        public static void attachScreenshot(String name) {
            try {
                File dir = new File(screenshotsPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                name = name.replaceAll("[^a-zA-Z0-9-_.]", "_") + "_" + System.currentTimeMillis();
                String path = Path.of(screenshotsPath,name+".png").toString();
                File screenshot = new File(path);
                if (screenshot.exists()) {
                    test.addScreenCaptureFromPath(path);
                } else {
                    test.warning("Screenshot not found at: " + path);
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

        public static void flush(){
            extent.flush();
        }

        // Generate a test reporter
        public static ExtentReports getReporter() {
            if (extent == null) {
                throw new IllegalStateException("ExtentReports is not initialized. Call initializeReporter() first.");
            }
            return extent;
        }
    }

