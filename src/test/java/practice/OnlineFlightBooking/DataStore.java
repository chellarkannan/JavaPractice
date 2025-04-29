package practice.OnlineFlightBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DataStore {
    public static void main(String[] args) {
        // ArrayList for storing flight numbers
        ArrayList<String> flightNumbers = new ArrayList<>();
        flightNumbers.add("FL123");
        flightNumbers.add("FL456");
        flightNumbers.add("FL789");

        // HashSet for storing booked flight numbers
        HashSet<String> bookedFlights = new HashSet<>();
        bookedFlights.add("FL123");

        // HashMap for storing customer bookings
        HashMap<String, String> customerBookings = new HashMap<>();
        customerBookings.put("CUST001", "FL123");

        // Displaying the data
        System.out.println("Available Flights: " + flightNumbers);
        System.out.println("Booked Flights: " + bookedFlights);
        System.out.println("Customer Bookings: " + customerBookings);
    }
}
