package practice.Inheritance;

public class ChildClass extends ParentClass {
    
    private String accountType;
    private double balance;

    public ChildClass(String accountHolderName, String accountNumber, String accountType, double balance) {
        super(accountHolderName, accountNumber);
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        }

        @Override
        public void displayAccountDetails() {
       // super.displayAccountDetails(); // Call the parent class method
        System.out.println("Account Holder Name: " + getAccountHolderName());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Balance: " + getBalance());
        }

        public static void main(String[] args) {
        ChildClass childAccount = new ChildClass("John Doe", "123456789", "Savings", 1000.0);
        childAccount.displayAccountDetails();
    }    

}
