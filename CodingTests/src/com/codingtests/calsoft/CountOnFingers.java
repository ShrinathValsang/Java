package com.codingtests.calsoft;
import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer, count the number on your fingers, and determine 
 * the finger on which the counting ends. Counting starts at 1 with the thumb,
 * and proceeds with 2 on index finger, 3 on the middle finger, 4 on the ring 
 * finger, 5 on the little finger. Then, we move backwards with 6 on the ring 
 * finger, 7 on the middle, 8 on index and 9 on thumb, followed by 10 on 
 * the index finger, and so on.
 * Once the counting is over, your function should return the number of the 
 * finger [1-5] where it ended. (1 for thumb, 2 for index finger etc.).
 * 
 * Mettl test - 30/06/2020
 */
public class CountOnFingers {

	public static void main(String[] args) {
//		String rev = new ReverseString().reverseStringWithoutSpecialChars("ABcd&*&^");
//		System.out.println("ABcd&*&^ -- " + rev);
//		
//		String rev2 = new ReverseString().reverseStringWithoutSpecialChars("ABcd&*&^$");
//		System.out.println("ABcd&*&^$ -- " + rev2 + " "+ rev2.length());
//		
		String rev1 = new CountOnFingers().reverseStringWithoutSpecialChars1("ABcd&*&^$as");
		System.out.println("ABcd&*&^$as -- " + rev1 + " "+ rev1.length());
		
//		String rev0 = new ReverseString().reverseStringWithoutSpecialChars("ABcd&*&^$a");
//		System.out.println("ABcd&*&^$a -- " + rev0 + " "+ rev0.length());
//		
//		String rev10 = new ReverseString().reverseStringWithoutSpecialChars("*%A$Bcd&*&^$a");
//		System.out.println("*%A$Bcd&*&^$a -- " + rev10 + " "+ rev10.length());
		
		String s1 = "a,b$c";
		System.out.println(s1 + " -- " + new CountOnFingers().reverseStringWithoutSpecialChars(s1));
		
		String s2 = "Ab,c,de!$";
		System.out.println(s2 + " -- " + new CountOnFingers().reverseStringWithoutSpecialChars(s2));
		
		String s3 = "Ab,c,de!$z";
		System.out.println(s3 + " -- " + new CountOnFingers().reverseStringWithoutSpecialChars(s3));
	}
	
	public String reverseStringWithoutSpecialChars1(String st) {
		char[] arr = st.toCharArray();
		int l = st.length();
		System.out.println(arr);
		
		List<String> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		System.out.println(l1.getClass() == l2.getClass()); // prints true
		
		int i = 0, j = arr.length - 1;
		while (i < j) {
			if (!Character.isAlphabetic(arr[i])) {
				i++;
			} else if (!Character.isAlphabetic(arr[j])) {
				j--;
			} else {
				char temp1 = arr[i];	
				arr[i] = arr[j];
				arr[j] = temp1;
				System.out.println(arr);
					//break;
			}
			i++;
			j--;
		}
		
		/*for (int i=0, j=l; i < l && (j-i) > 1; i++) {
			if (Character.isAlphabetic(arr[i])) {
				
 				while (j-- >= 0) {
					if (Character.isAlphabetic(arr[j])) {
						char temp1 = arr[i];	
						arr[i] = arr[j];
						arr[j] = temp1;
						System.out.println(arr);
						break;
					}
				}
				
			} //else continue;
		}*/
		
		//System.out.println(new String(arr));
		return new String(arr);
	}
	
	public String reverseStringWithoutSpecialChars(String st) {
		//st="ABcd&*&^";
		char[] arr = st.toCharArray();
		int l = st.length();
		//int j = l;
		System.out.println(arr);
		
		for (int i=0, j=l; i < l && (j-i) > 1; i++) {
			if (Character.isAlphabetic(arr[i])) {
				
 				while (j-- >= 0) {
					if (Character.isAlphabetic(arr[j])) {
						char temp1 = arr[i];	
						arr[i] = arr[j];
						arr[j] = temp1;
						System.out.println(arr);
						break;
					}
				}
				
			} //else continue;
		}
		
		//System.out.println(new String(arr));
		return new String(arr);
	}

}
