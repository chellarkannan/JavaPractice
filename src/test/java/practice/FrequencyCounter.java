package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrequencyCounter {

	/*Challenge
		Given a list of integers, count and return the number of times each value appears as an array of integers.
		.
	 * @param args
	 */
	public static void main(String args[]) {
		Integer arr[] = new Integer[100];
		Integer input[] = new Integer[]{1,1,3,2,1,13,27};
		List<Integer>listArr = new ArrayList<Integer>();		
		listArr=Arrays.asList(input);
		System.out.println("Input List -> "+listArr);
		for(int index=0;index<arr.length;index++) {
			arr[index]=0;
		}
		
		for(int index:listArr) {
			arr[index]=arr[index]+1;
		}
		listArr=Arrays.asList(arr);
		System.out.println("Frequency Counter -> "+listArr);
		
		//using frequency counter to print elements in sorted order
		List<Integer> listInt = new ArrayList<Integer>();
		int value=0;
			for(int in:listArr) {
				int counter=0; 
				while(counter<in) {
					listInt.add(value);
					counter++;
				}
				value++;
			}
		//sorter order
		System.out.println("Sorted Input -> "+listInt);
		
		
	}
}