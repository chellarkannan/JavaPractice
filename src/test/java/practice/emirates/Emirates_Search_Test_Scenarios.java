package practice.emirates;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Emirates_Search_Test_Scenarios {

    @DataProvider(name = "flightSearchData") // packing data
    public Object[][] flightSearchDataProvider() {
        return new Object[][] {
            {"New York", "London", "2023-12-01", "2023-12-15"},
            {"San Francisco", "Tokyo", "2024-01-10", "2024-01-20"},
            {"Dubai", "Paris", "2024-02-05", "2024-02-15"}
        };
    }

    @DataProvider(name = "flightSearchDataMap")
    public Object[][] flightSearchDataMapProvider() {
        return new Object[][] {
            {Map.of("origin", "New York", "destination", "London", "departureDate", "2023-12-01", "returnDate", "2023-12-15")},
            {Map.of("origin", "San Francisco", "destination", "Tokyo", "departureDate", "2024-01-10", "returnDate", "2024-01-20")},
            {Map.of("origin", "Dubai", "destination", "Paris", "departureDate", "2024-02-05", "returnDate", "2024-02-15")}
        };
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

    @Test    
    public void testDefaultPassengerCount() {
        // Test Function - Check if user is able to perform search flights with default passenger count.
        System.out.println("Testing default passenger count...");
        // Add your test code here
    }

   // Check if user is able to perform search flights with default passenger count
    @Test
    public void checkUserAbleToPerformSearchFlightsWithDefaultPassengerCount() {
        System.out.println("Testing user able to perform search flights with default passenger count...");
        // Add your test code here
    }

    @Test
    public void simpleTicketBooking(){

    }
   

    @Test(dataProvider = "flightSearchData") // unpacking data one by one
    public void testFlightSearch(String origin, String destination, String departureDate, String returnDate) {
        System.out.println("Testing flight search with: " + origin + " to " + destination + 
                           ", Departure: " + departureDate + ", Return: " + returnDate);
        // Add your test code here searchFlight
        // Example: searchFlight(origin, destination, departureDate, returnDate);
    }

    @Test(dataProvider = "flightSearchDataMap")
    public void testFlightSearchWithMap(Map<String, String> flightData) {
        System.out.println("Testing flight search with Map: " + flightData);
        // Add your test code here
    }

    @AfterClass
    public void tearDown() {
        // Clean up and close the WebDriver here
        System.out.println("Tearing down the test environment...");
    }
}
