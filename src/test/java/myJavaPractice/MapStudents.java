package myJavaPractice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapStudents {
    public static void main(String[] args){

        Map<String, Integer> map = new HashMap<>();

        //Adding Name and Marks
        map.put("Ani", 70);
        map.put("Sam", 60);
        map.put("Uma", 80);
        map.put("Alex", 70);

        //To find highest Mark
        int highest = Collections.max(map.values());

        System.out.println("Highest Mark:" +highest);

        //To find lowest Mark
        int lowest = Collections.min(map.values());

        System.out.println("Lowest Mark:" +lowest);

        //To find average Mark
        int avg = 0;
        int total = 0;

        for(int mark : map.values()){
            total = total + mark;
        }

        avg = total/map.size();

        System.out.println("Avg Mark:" +avg);

        
        

    }

}
