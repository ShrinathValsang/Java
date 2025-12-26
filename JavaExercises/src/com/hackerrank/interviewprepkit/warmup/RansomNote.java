package com.hackerrank.interviewprepkit.warmup;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 12th October 2024
public class RansomNote {
	
	public static void main(String...args) {
		String s1 = "two times three is not four";
		String s2 = "two times two is four";
		//String s2 = "two times three is four";
		
		List<String> magazine = getListFromLine(s1);
		List<String> note = getListFromLine(s2);
		
		checkMagazine(magazine, note);
	}

	public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        /*if (magazine.containsAll(note)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        };*/
        
		if (note.isEmpty() || (note.size() > magazine.size())) {
			System.out.println("No"); 
			return;
		}
		
		
		Map<String, Integer> mmap = magazine.stream()
				.collect(Collectors.toMap(
					Function.identity(), // keymapper
					e -> Collections.frequency(magazine, e) // valuemapper
				));
		
		/*final String result;
        note.stream().forEach(e -> {
        	if (mmap.containsKey(e)) {
        		if (mmap.get(e) < 1) {
        			result = "No";
        		}
        		mmap.computeIfPresent(e, (k,v) -> v-1);
        	} else {
    			System.out.println("No"); 
    			return;
        	}
        });
		System.out.println("Yes");*/
		
		note.forEach(e -> {
        	if (mmap.containsKey(e)) {
        		if (mmap.get(e) < 1) {
        			System.out.println("No");
        			System.exit(0);
        		}
        		mmap.computeIfPresent(e, (k,v) -> v-1);
        	} else {
    			System.out.println("No");
    			System.exit(0);
        	}
        });
		System.out.println("Yes");

    }
	
	private static List<String> getListFromLine(String s) {
		return Stream.of(s.split(" ")).collect(Collectors.toList());
	}

}
