package com.hackerrank.interviewprepkit.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
	
	public static final int ALPHABETS = 26;

	/*
	 * Complete the 'sherlockAndAnagrams' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts STRING s
	 * as parameter.
	 */
	public static int sherlockAndAnagrams(String s) {
		// Write your code here
		int count = 0;
		
		// outer for loop starts.. 
		for (int i = 1, n = s.length(); i < n; i++) {
			List<String> subList = new ArrayList<>();
			
			for (int j = 0; j < n; j++) {
				if (i + j < n) {
					subList.add(s.substring(j, i + j));
				}
			}
			
			for (int k = 0, sz = subList.size(); k < sz; k++) {
				for (int l = k + 1; l < sz; l++) {
					if (isAnagram(subList.get(k), subList.get(l))) {
						count++;
					}
				}
			}
			
		} // outer foor loop ends.
		
		return count;
	}

	private static boolean isAnagram(String s1, String s2) {
		 char[] charCount1 = new char[ALPHABETS];
		 char[] charCount2 = new char[ALPHABETS];
		 
		 for (int i = 0, n = s1.length(); i < n; i++) {
			 charCount1[s1.charAt(i) - 97] += 1;
			 charCount2[s2.charAt(i) - 97] += 1;
		 }
		 
		 for (int i = 0; i < ALPHABETS; i++) {
			 if (charCount1[i] != charCount2[i]) {
				 return false;
			 }
		 }
		 
		return true;
	}

}

public class SherlockAndAnagrams {
	
	public static void main(String[] args) throws IOException {
		/*
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				String s = bufferedReader.readLine();

				int result = Result.sherlockAndAnagrams(s);

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
		*/
		
		String s = "ifailuhkqq";
		String s1 = "kkkk";
		int result = Result.sherlockAndAnagrams(s1);
		System.out.println(result);
	}
}
