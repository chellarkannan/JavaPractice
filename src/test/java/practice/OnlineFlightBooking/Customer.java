package practice.OnlineFlightBooking;

public class Customer extends User {
    private String customerId;

    public Customer(String name, String email, String customerId) {
        super(name, email);
        this.customerId = customerId;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Customer ID: " + customerId);
    }
}
