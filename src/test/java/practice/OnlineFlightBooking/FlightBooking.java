package practice.OnlineFlightBooking;

public interface FlightBooking {
    void bookFlight(String flightNumber);
    void cancelBooking(String bookingId);
    void searchFlights(String origin, String destination);
    void viewBookingDetails(String bookingId);
    void viewFlightDetails(String flightNumber);
    void viewAvailableFlights(String origin, String destination);
    void viewFlightStatus(String flightNumber);
    void viewBookingHistory(String customerId);
}