package mySeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmiratesAirline_Flight_Search {


// declare  all xpath vriables here 
        private static WebDriver driver = new ChromeDriver();
        private static final String acceptButtonLocator = "//div[@id='onetrust-consent-sdk']//button[text()='Accept']";
        private static final String clearDepartureLocator = "//div[@id='search-flight-control']//label[text()='Departure airport']/../button[@name='clear Departure airport']";
        private static final String departureInputLocator = "//div[@id='search-flight-control']//input[@name='Departure airport']";
        //private static final String departureEleToSelectLocator = "//*[contains(@class,'location-list')]//*[contains(@aria-label,'New York') and contains(@aria-label,'JFK')]/parent::li";
         private static String departureEleToSelectLocator = "//*[contains(@class,'location-list')]//*[contains(@aria-label,'New York') and contains(@aria-label,'";
        private static final String arrivalInputLocator = "//div[@id='search-flight-control']//input[@name='Arrival airport']";
        //private static final String arrivalEleToSelectLocator = "//div[@class='destination-dropdown']//*[contains(@class,'location-list')]//*[contains(@aria-label,'Chennai') and contains(@aria-label,'MAA')]/parent::li";
        private static String arrivalEleToSelectLocator = "//div[@class='destination-dropdown']//*[contains(@class,'location-list')]//*[contains(@aria-label,'Chennai') and contains(@aria-label,'";
        //private static final String departureDateLocator = "//*[@class='search-flight__section grid']//*[contains(@aria-label,'Sunday, 25  May 2025')]";
        //private static final String returnDateLocator = "//*[@class='search-flight__section grid']//*[contains(@aria-label,'Friday, 20  June 2025')]";
        private static String departureDateLocator = "//*[@class='search-flight__section grid']//*[contains(@aria-label,'";
        private static String returnDateLocator = "//*[@class='search-flight__section grid']//*[contains(@aria-label,'";
        private static final String searchButtonLocator = "//span[text()='Search flights']/parent::button";
        private static final String defaultPassengerCountLocator = "//div[@class='search-details__trip-details']//span[@class='search-details__trip-details-pax-count']";
        private static final String incrementAdultLocator = "//section[@class='location passenger-container']//div[@data-type='adults']//button[@class='js-increment-increase increment-field__button increment-field__increase']";
        private static final String noOfAdultAddedLocator = "//section[@class='location passenger-container']//span[text()='Adult' or text()='Adults']/../span[@class='increment-field__value js-increment-value']";
        private static final String noOfChildAddedLocator = "//section[@class='location passenger-container']//span[text()='Child' or text()='Children']/../span[@class='increment-field__value js-increment-value']";
        private static final String noOfInfantAddedLocator = "//section[@class='location passenger-container']//span[text()='Infant' or text()='Infants']/../span[@class='increment-field__value js-increment-value']";

        //private static final String incrementAdultLocator = "//div[@class='rsw-increment-field']//button[@id='increment-ADT']";
        private static final String incrementChildLocator = "//section[@class='location passenger-container']//div[@data-type='children']//button[@class='js-increment-increase increment-field__button increment-field__increase']";
        private static final String incrementInfantLocator = "//section[@class='location passenger-container']//div[@data-type='infants']//button[@class='js-increment-increase increment-field__button increment-field__increase']";

        private static int totalAdultChild;
        private static int adultCount;
        private static int childCount;
        private static int infantCount;
        String name;

        

        @DataProvider(name="flightSearchData") //packing Data
        public Object[][] flightSearchDataProvider(){
                return new Object[][]{
                        {"New York", "JFK", "London", "LDY", "Friday, 30  May 2025", "Friday, 20  June 2025"},
                         {"San Francisco", "SFO", "Tokyo", "NRT", "Friday, 30  May 2025", "Friday, 20  June 2025"},
                        {"Dubai", "DXB", "Paris", "XYD","Friday, 30  May 2025", "Friday, 20  June 2025"}
                };
        }

        private static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

// function to launch browser and navigate to testURL
        @BeforeClass
        public void launchBrowser(){
                 driver.get("https://www.emirates.com/in/english/");
                 driver.manage().window().maximize();
                 handlePopup();
        }

// function to check handle accept pop up button
        public void handlePopup(){
                try {
                        Thread.sleep(5000);                       

                        WebElement acceptbutton = driver.findElement(By.xpath(acceptButtonLocator));

                        // wait.until(ExpectedConditions.visibilityOf(acceptbutton));
                        wait.until(ExpectedConditions.elementToBeClickable(acceptbutton));
                        acceptbutton.click();
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
                
        }

        // function to clear the departure airport
        public void clearDeparture(){
                        //Thread.sleep(5000);
                        WebElement clearDepartureInput = driver.findElement(By.xpath(clearDepartureLocator));
                        clearDepartureInput.click();
        }

        // function to select the departure airport
        public void departureAirport(String departureFrom, String departureCode){
                try{
                        // Type Departure Airport
                        WebElement departureInput = driver.findElement(By.xpath(departureInputLocator));

                        departureInput.click();
                        departureInput.sendKeys(departureFrom);

                        //departureEleToSelectLocator = "//*[contains(@class,'location-list')]//*[contains(@aria-label,'New York') and contains(@aria-label,'JFK')]/parent::li";
                        departureEleToSelectLocator = departureEleToSelectLocator.concat(departureCode).concat("')]/parent::li");
                        
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(departureEleToSelectLocator)));
                        WebElement departureToSelect = driver.findElement(By.xpath(departureEleToSelectLocator));
                        departureToSelect.click();
                }catch (Exception e){
                        System.out.println(e.getMessage());
                }
                
        }

        // function to select the arrival airport
        public void arrivalAirport(String arrivalTo, String arrivalCode){
                try {
                        Thread.sleep(5000);
                        // Enter Arrival Airport
                        WebElement arrivalInput = driver.findElement(By.xpath(arrivalInputLocator));
                        //arrivalInput.click();
                        arrivalInput.sendKeys(arrivalTo);
                        
                        //private static final String arrivalEleToSelectLocator = "//div[@class='destination-dropdown']//*[contains(@class,'location-list')]//*[contains(@aria-label,'Chennai') and contains(@aria-label,'MAA')]/parent::li";
                        arrivalEleToSelectLocator = arrivalEleToSelectLocator.concat(arrivalCode).concat("')]/parent::li");

                        // Select 'MAA' from the list
                        
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(arrivalEleToSelectLocator)));
                        WebElement arrivalToSelect = driver.findElement(By.xpath(arrivalEleToSelectLocator));
                        arrivalToSelect.click();
                    
                } catch (Exception e) {
                         System.out.println(e.getMessage());
                }
                
        }

        // function to select the departure date
        public void departureDate(String fromDate){
                try{
                        // Select Departure Date
                        //departureDateLocator = "//*[@class='search-flight__section grid']//*[contains(@aria-label,'Sunday, 25  May 2025')]";
                        departureDateLocator = departureDateLocator.concat(fromDate).concat("')]");
                        WebElement departureDate = driver.findElement(By.xpath(departureDateLocator));
                        departureDate.click();
                }catch (Exception e) {
                         System.out.println(e.getMessage());
                }
            
        }

        // function to select the return date
        public void returnDate(String toDate){
                try {
                        // Select Return Date
                        //private static final String returnDateLocator = "//*[@class='search-flight__section grid']//*[contains(@aria-label,'Friday, 20  June 2025')]";
                        returnDateLocator = returnDateLocator.concat(toDate).concat("')]");
                        WebElement returnDate = driver.findElement(By.xpath(returnDateLocator));
                        returnDate.click();
                } catch (Exception e) {
                         System.out.println(e.getMessage());
                }
        
        }

        // function to click continue button
        public void clickSearchFlight(){
                try {
                        WebElement continueButton = driver.findElement(By.xpath(searchButtonLocator));
                        continueButton.click();
                } catch (Exception e) {
                         System.out.println(e.getMessage());
                }
            
        }

        // Entering Departure Airport, Arrival Airport, Departure Date, Return Date
        @Test(dataProvider = "flightSearchData")
        public void enterFlightSearchDetails(String departure, String depCode, String arrival, String arrCode, String depDate, String arrDate ){
                
                //Entering Departure and arrival location
                departureAirport(departure, depCode);
                arrivalAirport(arrival, arrCode);

                //Entering Departure Date, Return Date
                departureDate(depDate);
                returnDate(arrDate);
                
                
             /*   //Entering Departure and arrival location
                departureAirport("New York", "JFK");
                arrivalAirport("Chennai");

                //Entering Departure Date, Return Date
                departureDate("Sunday, 25  May 2025");
                returnDate("Friday, 20  June 2025");
                */
        }

        
        // add adult passenger 
        @Test
        public void addAdult(int noOfAdult){
                try{
                                System.out.println("Entered All the search details");
                                // By default 1 Adult passenger, add given number of adult passenger
                                Thread.sleep(5000);
                                WebElement incrementAdult = driver.findElement(By.xpath(incrementAdultLocator));
                                wait.until(ExpectedConditions.elementToBeClickable(incrementAdult));
                                for (int i = 0; i < noOfAdult; i++) {
                                        incrementAdult.click();
                                }
                        
                        
                        if(noOfAdult >= 9){
                                System.out.println("You can add max 9 passenders");
                        }
                        
                 } catch (Exception e) {
                         System.out.println(e.getMessage());
                } 
        }
            

        // add child passenger
        @Test
        public void addChild(int noOfChild){
                try{
                        // By default 0 child passenger, add 2 more child passenger
                        WebElement incrementChild = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(incrementChildLocator)));
                        for (int i = 0; i < noOfChild; i++) {
                                incrementChild.click();
                        }
                } catch (Exception e) {
                         System.out.println(e.getMessage());
                }
                
        }

           // add infant passenger 
        @Test
        public void addInfant(int noOfInfant){
                try{
                        getAddedAdultCount();

                        WebElement incrementInfant = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(incrementInfantLocator)));
                
                       for (int i = 0; i < adultCount; i++) {
                                incrementInfant.click();
                        }

                        getAddedInfantCount();

                        if(noOfInfant > adultCount){
                                System.out.println("Given Infants count is greater than added Adults count");
                                System.out.println("Added only "+infantCount + " Infants as we have " +adultCount + " Adults");
                        }
                        else if(noOfInfant == adultCount){
                                 System.out.println("Infant count is equal to Adult count. Total " +infantCount + " Infants added");
                        }
                        else{
                                System.out.println(infantCount + " Infants added");
                        }

                } catch (Exception e) {
                         System.out.println(e.getMessage());
                }
                
        }

        // Check 'Add' button disabled for Adult
        public void addButtonDisabledAdult(){
                try{
                        WebElement incrementAdult = driver.findElement(By.xpath(incrementAdultLocator));
                        String addButtonDisabledAdult = incrementAdult.getAttribute("aria-disabled");
                                if(addButtonDisabledAdult.equals("true")){
                                        System.out.println("Adult Passenger Add button is Disabled");
                                }
                }catch(Exception e){
                        System.out.println(e.getMessage());
                }
        }

        // Check 'Add' button diabled for Child
        public void addButtonDisabledChild(){
                try{
                        String incButtonDisabledChild = driver.findElement(By.xpath(incrementChildLocator)).getAttribute("aria-disabled");
                                if(incButtonDisabledChild.equals("true")){
                                        System.out.println("Child Passenger Add button is Disabled");
                                }
                }catch(Exception e){
                        System.out.println(e.getMessage());
                }
        }

        // Get the added Adult passengers count
        public void getAddedAdultCount(){
                try{
                        // To get the added Adult count
                        WebElement addedAdult = driver.findElement(By.xpath(noOfAdultAddedLocator));
                        String getAdultCount = addedAdult.getText();
                        adultCount = Integer.parseInt(getAdultCount.trim());
                         System.out.println("The number of added Adult is:"+adultCount);
                } catch(Exception e){
                        System.out.println(e.getMessage());
                }
        }
        
        // Get the added Child passengers count
        public void getAddedChildCount(){
                try{
                         // To get the added Child count
                         WebElement addedChild = driver.findElement(By.xpath(noOfChildAddedLocator));
                         String getChildCount = addedChild.getText();
                         childCount = Integer.parseInt(getChildCount.trim());
                         System.out.println("The number of added Child is:"+childCount);

                } catch(Exception e){
                        System.out.println(e.getMessage());
                }
        }

        // Get the added Infant passengers count
        public void getAddedInfantCount(){
                try{
                         // To get the added Child count
                         WebElement addedInfant = driver.findElement(By.xpath(noOfInfantAddedLocator));
                         String getInfantCount = addedInfant.getText();
                         infantCount = Integer.parseInt(getInfantCount.trim());
                         System.out.println("The number of added Infant is:"+infantCount);

                } catch(Exception e){
                        System.out.println(e.getMessage());
                }
        }

         // Total Adult+Child passengers
                         //totalAdultChild = Integer.parseInt(adultCount.trim()) + Integer.parseInt(childCount.trim());
                         //System.out.println("The total number of Adult & Child passengers:"+totalAdultChild);


        // Test Function - Check if user is able to perform search flights with default passenger count. 
        @Test
        public void defaultNoOfPassenger(){
                enterFlightSearchDetails();
                clickSearchFlight();
                
                try {
                        WebElement defaultPassengerCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(defaultPassengerCountLocator)));
                
                        String passengerCount = defaultPassengerCount.getText();
                        System.out.println("Hello");
                        if(passengerCount.equals("1 passenger")){
                        System.out.println("Succesfully search flights with default passenger count");
                }
                } catch (Exception e) {
                         System.out.println(e.getMessage());
                }
        }


        // Test Function - check if I can add adult passenger - 9 and see add button is disabled
        @Test
        public void maxAdultPassenger(){
                try{

                        enterFlightSearchDetails();
                        addAdult(8);

                         //Checking the Add button is disabled for Adult
                        addButtonDisabledAdult();
                     
                         //Checking the Add button is disabled for Child
                        addButtonDisabledChild();

                } catch (Exception e) {
                         System.out.println(e.getMessage());
                }
                
        }


        // Test Function - check maximum 9 passengers including Adult & Child
         // Test Function - check if I can add adult passenger - 7, child 1, infant 1 and see all add buttons are disabled
        @Test
        public void maxNineAdultChild(){
                try {
                        enterFlightSearchDetails();
                        addAdult(4);
                        addChild(6);
                        addInfant(1);
                        getAddedAdultCount();
                        getAddedChildCount();

                        //Checking the Add button is disabled for Adult
                        addButtonDisabledAdult();
                     
                         //Checking the Add button is disabled for Child
                        addButtonDisabledChild();

                } catch (Exception e) {
                }
        }


        // Test Function - check if I can add equal number of Infant for Adult
        // Test Function - check if I can add Infant>Adult 
        @Test
        public void addButtonDisabled(){
                try{
                        enterFlightSearchDetails();
                        addAdult(2);
                        addInfant(5);

                } catch (Exception e) {
                         System.out.println(e.getMessage());
                }
                
        }


        // function to check if page navigate to expected page 
        /*  Test Function - check if I can add child passenger - 6
        @Test
        public void addSixChild(){
                try{
                        // By default 0 child passenger, add 6 child passenger
                        WebElement incrementChild = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(incrementChildLocator)));
                        for (int i = 0; i < 6; i++) {
                        incrementChild.click();
                        }
                } catch (Exception e) {
                         System.out.println(e.getMessage());
                }
                

        } */
}
  
