package practice.OnlineFlightBooking;

public class User {
    protected String name;
    protected String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }

    public boolean validateEmail() {
        // Simple email validation logic (for demonstration purposes)
        return email.contains("@") && email.contains(".");
    }
    public String getName() {
        return name;
    }
    
}
