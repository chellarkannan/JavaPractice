package practice.OnlineFlightBooking;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Book Flight");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Search Flights");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Booking a flight...");
                    // Logic to book a flight
                    break;
                case 2:
                    System.out.println("Cancelling a booking...");
                    // Logic to cancel a booking
                    break;
                case 3:
                    System.out.println("Searching flights...");
                    // Logic to search flights
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}