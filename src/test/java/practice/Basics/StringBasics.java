package practice.Basics;

public class StringBasics {
    
    // This is a simple Java program to demonstrate string manipulation

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        
        // Concatenation
        String str3 = str1 + " " + str2;
        System.out.println("Concatenated String: " + str3);
        
        // Length
        System.out.println("Length of str3: " + str3.length());
        
        // Character at index
        System.out.println("Character at index 1: " + str3.charAt(1));
        
        // Substring
        System.out.println("Substring from index 1 to 4: " + str3.substring(1, 4));
        
        // Convert to uppercase
        System.out.println("Uppercase: " + str3.toUpperCase());
        
        // Convert to lowercase
        System.out.println("Lowercase: " + str3.toLowerCase());
        
        // Replace character
        System.out.println("Replace 'o' with 'a': " + str3.replace('o', 'a'));

        // check if string is empty
        System.out.println("Is str3 empty? " + str3.isEmpty());

        // check if string contains a substring
        System.out.println("Does str3 contain 'lo'? " + str3.contains("lo"));

        // check if string starts with a prefix
        System.out.println("Does str3 start with 'He'? " + str3.startsWith("He"));

        // check if string ends with a suffix
        System.out.println("Does str3 end with 'ld'? " + str3.endsWith("ld"));
        
    }
}
