package practice.OnlineFlightBooking;

public class MakeMyTrip implements FlightBooking {
    private String flightNumber;
    private String bookingId;
    private String customerId;

    public MakeMyTrip(String flightNumber, String bookingId, String customerId) {
        this.flightNumber = flightNumber;
        this.bookingId = bookingId;
        this.customerId = customerId;
    }

    @Override
    public void bookFlight(String flightNumber) {
        System.out.println("Booking flight: " + flightNumber);
        // Logic to book the flight
    }

    @Override
    public void cancelBooking(String bookingId) {
        System.out.println("Cancelling booking: " + bookingId);
        // Logic to cancel the booking
    }

    @Override
    public void searchFlights(String origin, String destination) {
        System.out.println("Searching flights from " + origin + " to " + destination);
        // Logic to search for flights
    }

    @Override
    public void viewBookingDetails(String bookingId) {
        System.out.println("Viewing details for booking ID: " + bookingId);
        // Logic to view booking details
    }

    @Override
    public void viewFlightDetails(String flightNumber) {
        System.out.println("Viewing details for flight number: " + flightNumber);
        // Logic to view flight details
    }

    @Override
    public void viewAvailableFlights(String origin, String destination) {
        System.out.println("Viewing available flights from " + origin + " to " + destination);
        // Logic to view available flights
    }

    @Override
    public void viewFlightStatus(String flightNumber) {
        System.out.println("Viewing status for flight number: " + flightNumber);
        // Logic to view flight status
    }

    @Override
    public void viewBookingHistory(String customerId) {
        System.out.println("Viewing booking history for customer ID: " + customerId);
        // Logic to view booking history
    }
    
    public static void main(String[] args) {
        MakeMyTrip makeMyTrip = new MakeMyTrip("AI2023", "BKG123", "CUST456");
        makeMyTrip.bookFlight("AI2023");
    }
}
