package practice.Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class CollectionBasics {

  /* List
    Set
    HashMap - (key - value pair)
    TreeMap
    */

    List<String> list = new ArrayList<String>();  // List is an interface, ArrayList is a class that implements List interface
    
    List<String> list2 = Arrays.asList("Apple", "Banana", "Cherry"); 

    Set<String> set = new HashSet<String>();
   
    Map<String,String> map = new HashMap<String, String>();

    public void listBasics() {
        // Adding elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Printing the elements of the list
        System.out.println("List elements: " + list);

        // Accessing an element by index
        String firstElement = list.get(0);
        System.out.println("First element: " + firstElement);

        // Removing an element from the list
        list.remove("Banana");
        System.out.println("List after removing Banana: " + list);

        for(String fruit :list){
            System.out.println("Fruit: " + fruit);
        }
    }

    public void setBasics() {
        // Adding elements to the set
        set.add("Apple"); //true
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Duplicate element, will not be added // false

        // Printing the elements of the set
        System.out.println("Set elements: " + set);

        // Checking if an element exists in the set
        boolean containsBanana = set.contains("Banana");
        System.out.println("Set contains Banana: " + containsBanana);

        // Removing an element from the set
        set.remove("Cherry");
        System.out.println("Set after removing Cherry: " + set);
    }

    public void mapBasics() {
        // Adding key-value pairs to the map
        map.put("Apple", "Red"); 
        map.put("melon","green");
        map.put("Banana", "Yellow");
        map.put("Cherry", "Red");
        map.put("Apple", "Dark Red"); 

        // Printing the elements of the map
        System.out.println("Map elements: " + map);

        // Accessing a value by key
        String appleColor = map.get("Apple");
        System.out.println("Apple color: " + appleColor);

        // Removing a key-value pair from the map
        map.remove("Banana");
        System.out.println("Map after removing Banana: " + map);

        Set<String> keys = map.keySet();

        keys.forEach(key -> {
            System.out.println("Key: " + key);
        });

        map.values().forEach(value ->{
            System.out.println("Value: " + value);
        });

        map.entrySet().forEach(entry -> {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        });
        
    }


    // Map - Add Student Name as Key , Student mark as Value
    // Find average of all students marks
    // Find student with highest marks
    // Find student with lowest marks
    // Find students with same marks

    String a = "abracadabra";
    // Find number of times a character is repeated in a string

}
