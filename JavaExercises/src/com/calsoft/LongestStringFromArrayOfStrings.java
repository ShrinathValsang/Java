package com.calsoft;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Problem 1: 
// input: ["cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"]
// output: "dogwalker"
// 
// Problem 2: 
// input: ["cat", "banana", "dog", "nana", "walk", "nanawalkdog", "walker", "dogwalker"]
// output: "nanawalkdog"
// 
// Problem 3: 
// input: ["cat", "banana", "dog", "walk", "catangdog"]
// output: ""

/**
 * Given a array of Strings, find the longest String which can be created by 
 * other String in the list.
 * 
 * Mettl test - 30/06/2020
 */
public class LongestStringFromArrayOfStrings {

	public static void main(String[] args) {
		String[] arr1 = {"dog", "cat", "banana", "nana", "walk", "walker", "dogwalker"};
		String[] arr2 = {"dog", "cat", "banana", "dog", "nana", "walk", "nanawalkdog", "walker", "dogwalkerbananana"};
		String[] arr3 = {"dog", "cat", "banana", "dog", "walk", "catanddog"};

		//String longestString = getLongestString(arr1);
		//System.out.println(getLongestString(arr1));
		//System.out.println(getLongestStringFromArrayStrings(arr2));
		System.out.println(getLongestStringCreatedFromOtherArrayStrings(arr3));
		//System.out.println(getLongestString(arr3));
		
	}
	
	private static String getLongestStringCreatedFromOtherArrayStrings(String[] arr) {
		int size = arr.length;
		String longestString = "";
		
		if (size < 2) return longestString;
		
		Arrays.sort(arr, (s1, s2) -> (s1.length() > s2.length()) ? 1 : (s1.length() < s2.length() ? -1 : 0));
		
		OUTER : for (int i = size-1; i > 1; i--) {
			StringBuilder s = new StringBuilder(arr[i]);
			int ind = 0;
			
			for (int j = i-1; j >= 0; j--) {
				String sub = arr[j];
				int subl = sub.length(); // substring length
				
				if (arr[i] != sub && (ind = s.indexOf(sub)) != -1) {
					s.delete(ind, ind+subl);
					
					if (s.length() == 0) {
						longestString = arr[i];
						break OUTER;
					}
				}
			}
		}
		
		return longestString;
	}
	
	// latest from copilor 25th Sept 2025 -- above code optimized
	private static String getLongestStringCreatedFromOtherArrayStringsNew(String[] arr) {
		if (arr.length < 2) return "";
		
		//Arrays.sort(arr, (s1, s2) -> (s1.length() > s2.length()) ? 1 : (s1.length() < s2.length() ? -1 : 0));
		Arrays.sort(arr, Comparator.comparingInt(String::length)); // sort by length ascending
		
		for (int i = arr.length - 1; i >= 0; i--) {
			String candidate = arr[i];
			StringBuilder remaining = new StringBuilder(candidate);
			
			for (int j = 0; j < arr.length; j++) {
				if (i == j) continue; // skip the same string
				
				String part = arr[j];
				int index = remaining.indexOf(part); // substring length
				
				if (index != -1) {
					remaining.delete(index, index + part.length());
					
					if (remaining.length() == 0) {
						return candidate; // found the longest string
					}
				}
			}
		}
		
		return "";
	}
	
	// latest from copilor 25th Sept 2025 -- copilot solution -- more cleaner approach
	public static String findLongestComposedString(String[] words) {
		if (words.length < 2) return "";
		
		Set<String> set = new HashSet<>(Arrays.asList(words));
		Arrays.sort(words, Comparator.comparingInt(String::length).reversed()); // longest first
		
		for (String word : words) {
			set.remove(word);
			if (canBuild(word, set)) {
				return word;
			}
			set.add(word);
		}
		
		return "";
	}
	private static boolean canBuild(String word, Set<String> set) {
		if (set.contains(word)) return true;
		for (int i = 1; i < word.length(); i++) {
			String prefix = word.substring(0, i);
			String suffix = word.substring(i);
			
			if (set.contains(prefix) && canBuild(suffix, set)) {
				return true;
			}
		}
		return false;
	}

	private static String getLongestString(String[] arr1) {
		if (arr1.length < 2) {
			return "";
		}
		
		Arrays.sort(arr1, (s1, s2) -> (s1.length() > s2.length()) ? 1 
				: (s1.length() < s2.length()) ? -1 : 0);
		
		String longStr = "";
		int size = arr1.length;
		//List<String> longWords = new ArrayList<>(arr1.length-2);
		
		OUTER: for (int i = size-1; i > 1; i--) {
			// String s = arr1[i];
			StringBuilder s = new StringBuilder(arr1[i]);
			Set<String> checked = new HashSet<>();
			
			//for (int j = size-1; j >= 0; j--) {
			for (int j = i-1; j >= 0; j--) {
				//if (i==j || checked.contains(arr1[j])) continue;
				if (checked.contains(arr1[j])) continue;
				else checked.add(arr1[j]);
				
				int ind = 0, el = arr1[j].length();
				if ( (ind = s.indexOf(arr1[j])) != -1) {
					//s = s.substring(0, ind) + s.substring(ind+el-1, s.length());
					s.delete(ind, ind+el);
					
					if (s.length() == 0) {
						longStr =  arr1[i];
						//longWords.add(arr1[j].toString());
						//continue OUTER;
						//break;
						break OUTER;
					}
				}
			}
			
		}
		
		return longStr;
	}
	
	// Not relevant to the purpose of the class.
	/*private static String getStringWithMaxWords(String[] arr1) {
		String longStr = "";
		
		Arrays.sort(arr1);
		int size = arr1.length;
		for (int i=size-1; i<=0; i--) {
			String s = arr1[i];
			int count = 0;
			Set<String> checked = new HashSet<>();
			
			for (int j=size-1; j<=0; j--) {
				if (i==j || checked.contains(arr1[j])) continue;
				if (s.contains(arr1[j])) count++;
			}
		}
		
		return longStr;
	}*/

}
