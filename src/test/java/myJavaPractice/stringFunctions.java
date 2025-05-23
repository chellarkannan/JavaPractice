package myJavaPractice;

public class stringFunctions {
    public static void main(String[] args){

        String text = "Welcome to Java";

        //Checking the text is blank or not
        if(text.isEmpty()){
            System.out.println("It is blank");
        }
        else{
            System.out.println("It is not blank");
        }

        // Converting Uppercase or Lowercase
        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
    
        //Checking if string contains a specific text
        if(text.contains("Java")){
            System.out.println("Jave is found");
        }

        // Replacing a part of string
        System.out.println(text.replace("Java", "Selenium"));

        // Split a string
        String[] splitText=text.split(" ");
        for(String word : splitText){
            System.out.println(word);
        }

        //Trim leading/trail space
        String text2 = " Hai ";
        System.out.println(text2.trim());

        //Compare strings
        String str1 = "Java";
        String str2 = "java";

        if(str1.equalsIgnoreCase(str2)){
            System.out.println("We are same");
        }

        //Extract a substring
        System.out.println(text.substring(8));

        //Length of the string
        System.out.println("My length is:" +str1.length());

        //Find the Index of char
        System.out.println("Index of T is:" +text.indexOf("T"));
        System.out.println("Index of To is:" +text.indexOf("To"));



    }

}
