package practice.OnlineFlightBooking.Interface;
import java.lang.System; // Added for System.out.println

// --- Strategy Interface ---
// Defines the common operation for all strategies (payment methods)
interface PaymentStrategy {
    void pay(double amount);
    void couponCode(String code); // Added for coupon code functionality
}

// --- Concrete Strategies ---
// Implement specific payment algorithms

class CreditCardPayment implements PaymentStrategy {

    String [] cardTypes = {"Visa", "MasterCard", "American Express"}; // Added for card types
    String [] couponCode={"DISCOUNT10", "SUMMER20", "WINTER30", "ABCD"}; // Added for coupon codes
    @Override // Good practice to add Override annotation
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with Credit Card");
    }

    @Override // Good practice to add Override annotation
    public void couponCode(String code) {
        // Note: The image had a small typo ".);", corrected to ");"
        System.out.println("Applied coupon code: " + code);
        // Check if the coupon code is valid (for demonstration purposes)
        for (String validCode : couponCode) {
            if (validCode.equalsIgnoreCase(code)) {
                System.out.println("Coupon code applied successfully!");
                return;
            }
        }
        System.out.println("Invalid coupon code.");
    }
}

class PaypalPayment implements PaymentStrategy {

    String [] couponCode={"DISCOUNT10", "SUMMER20", "WINTER30"}; // Added for coupon codes
    @Override // Good practice to add Override annotation
    public void pay(double amount) {
        // Note: The image had a small typo ".);", corrected to ");"
        System.out.println("Paid $" + amount + " using PayPal.");
    }

    @Override // Good practice to add Override annotation
    public void couponCode(String code) {
        // Note: The image had a small typo ".);", corrected to ");"
        System.out.println("Applied coupon code: " + code);
        // Check if the coupon code is valid (for demonstration purposes)
        for(int i=0; i<2; i++){

        }
        for (String validCode : couponCode) {
            if (validCode.equalsIgnoreCase(code)) {
                System.out.println("Coupon code applied successfully!");
                return;
            }
        }

        do{
            System.out.println("Invalid coupon code.");
            break;
        }while(true);          
        
        System.out.println("Invalid coupon code.");
    }
}

// --- Context Class ---
// Uses a strategy object without knowing its concrete type.
// It can switch strategies easily.
class ShoppingCart {
    // Holds a reference to the current strategy
    private PaymentStrategy paymentStrategy;

    // Constructor to inject the initial strategy
    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Method to change the strategy at runtime (optional, but common)
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Executes the payment using the *current* strategy
    public void checkout(double amount) {
        // Delegates the 'pay' call to the strategy object
        paymentStrategy.pay(amount);
    }

    public void applyCoupon(String code) {
        // Delegates the 'couponCode' call to the strategy object
        paymentStrategy.couponCode(code);
    }
}


// --- Example Usage (How you might use the above) ---
public class Payment {

    public static void main(String[] args) {
        // Create strategies
        PaymentStrategy creditCard = new CreditCardPayment();
        PaymentStrategy payPal = new PaypalPayment();

        // Create context (ShoppingCart) with an initial strategy
        ShoppingCart cart = new ShoppingCart(creditCard);

        // Apply coupon code
        cart.applyCoupon("ABCD"); // Applies coupon code
        cart.applyCoupon("INVALIDCODE"); // Invalid coupon code

        
        System.out.print("Checking out $100: ");
        cart.checkout(100.00); // Uses Credit Card

        // // Change strategy
        // cart.setPaymentStrategy(payPal);
        // System.out.print("Checking out $50: ");
        // cart.checkout(50.00); // Uses PayPal
    }
}
