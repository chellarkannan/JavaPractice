package practice.OnlineFlightBooking;

public class Booking {
    private static int bookingCounter = 0; // initlialization of static variable to keep track of booking count
    private String bookingId;  // declaration of booking ID
    private String flightNumber; // declaration of flight number
    private static int ticketLimit = 3; // declaration of ticket limit

    public Booking(){
        // Default constructor
    }
    // overloaded constructor to initialize flight number and booking ID
    public Booking(String flightNumber) {
        this.flightNumber = flightNumber;
        this.bookingId = "BKG" + (++bookingCounter);
    }

    public void displayBookingDetails() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Flight Number: " + flightNumber);
    }

    public static int getTotalBookings() {

        return bookingCounter;
    }

    // main method for testing
    public static void main(String[] args) {
        

        Booking booking1 = new Booking("FL123");
        booking1.displayBookingDetails();

        Booking booking2 = new Booking("FL456");
        booking2.displayBookingDetails();

        Booking booking3 = new Booking("FL789");
        booking3.displayBookingDetails();

        if(Booking.getTotalBookings() > ticketLimit) {
            System.out.println("Booking successful!");
            return;
        } else {
            System.out.println("No bookings made yet.");
        }
        Booking booking4 = new Booking("FL101");
        booking4.displayBookingDetails();

        Booking booking5 = new Booking("FL112");
        booking5.displayBookingDetails();
        
        System.out.println("Total bookings made: " + Booking.getTotalBookings());
    }
}
