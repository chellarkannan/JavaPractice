package myJavaPractice;

public class EmailValidation {

    int atPos = 0;

    // Check the EmailId contains @
    public void checkAt(String email){
        if(email.contains("@")){
            atPos = email.indexOf("@");
            System.out.println("The email id contains @");
        }
        else
        System.out.println("Invalid email, it does not contain @");
    }
    
    // Check the EmailId contains dot
    public void checkDot(String email){
        if(email.contains(".")){
            System.out.println("The email id contains dot");
        }
        else
        System.out.println("Invalid email, it does not contain dot");

    }

    // Get the user name before@
    public void getUserName(String email){
        String uName = email.substring(0, atPos);
        System.out.println("User Name is:" +uName);

    }
   

    public static void main(String[] args) {
        
        // Validate Email Id format
        //email.charAt(1);
        String email = "jovin@gmail.com";

        EmailValidation eVal = new EmailValidation();
        eVal.checkAt(email);
        eVal.checkDot(email);
        eVal.getUserName(email);

        
    }
}
    

