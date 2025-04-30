package practice.OnlineFlightBooking.Interface;
import java.lang.System; // Added for System.out.println

// --- Strategy Interface ---
// Defines the common operation for all strategies (payment methods)
interface PaymentStrategy {
    void pay(double amount);
}

// --- Concrete Strategies ---
// Implement specific payment algorithms

class CreditCardPayment implements PaymentStrategy {
    @Override // Good practice to add Override annotation
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with Credit Card");
    }
}

class PaypalPayment implements PaymentStrategy {
    @Override // Good practice to add Override annotation
    public void pay(double amount) {
        // Note: The image had a small typo ".);", corrected to ");"
        System.out.println("Paid $" + amount + " using PayPal.");
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
}


// --- Example Usage (How you might use the above) ---
public class Payment {

    public static void main(String[] args) {
        // Create strategies
        PaymentStrategy creditCard = new CreditCardPayment();
        PaymentStrategy payPal = new PaypalPayment();

        // Create context (ShoppingCart) with an initial strategy
        ShoppingCart cart = new ShoppingCart(creditCard);
        System.out.print("Checking out $100: ");
        cart.checkout(100.00); // Uses Credit Card

        // Change strategy
        cart.setPaymentStrategy(payPal);
        System.out.print("Checking out $50: ");
        cart.checkout(50.00); // Uses PayPal
    }
}
