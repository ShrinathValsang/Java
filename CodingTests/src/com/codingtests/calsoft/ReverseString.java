package com.codingtests.calsoft;
import java.util.ArrayList;
import java.util.List;

/**
 * Give a string, this program reverses only the alphabetical characters without
 * displacing the special characters and numbers.
 * 
 * Mettl test - 30/06/2020
 */
public class ReverseString {

	public static void main(String[] args) {
//		String rev = new ReverseString().reverseStringWithoutSpecialChars("ABcd&*&^");
//		System.out.println("ABcd&*&^ -- " + rev);
//		
//		String rev2 = new ReverseString().reverseStringWithoutSpecialChars("ABcd&*&^$");
//		System.out.println("ABcd&*&^$ -- " + rev2 + " "+ rev2.length());
//		
		String rev1 = new ReverseString().reverseStringWithoutSpecialChars1("ABcd&*&^$as");
		System.out.println("ABcd&*&^$as -- " + rev1 + " "+ rev1.length());
		
//		String rev0 = new ReverseString().reverseStringWithoutSpecialChars("ABcd&*&^$a");
//		System.out.println("ABcd&*&^$a -- " + rev0 + " "+ rev0.length());
//		
//		String rev10 = new ReverseString().reverseStringWithoutSpecialChars("*%A$Bcd&*&^$a");
//		System.out.println("*%A$Bcd&*&^$a -- " + rev10 + " "+ rev10.length());
		
		String s1 = "a,b$c";
		System.out.println(s1 + " -- " + new ReverseString().reverseStringWithoutSpecialChars(s1));
		
		String s2 = "Ab,c,de!$";
		System.out.println(s2 + " -- " + new ReverseString().reverseStringWithoutSpecialChars(s2));
		
		String s3 = "Ab,c,de!$z";
		System.out.println(s3 + " -- " + new ReverseString().reverseStringWithoutSpecialChars(s3));
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
