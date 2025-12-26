package com.leetcode.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

	public static void main(String[] args) {
		// Input
		String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z"};
		// Output:
		// [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
		
		System.out.println(new GroupShiftedStrings().groupShiftedStrings(strings));
	}
	
	public List<List<String>> groupShiftedStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		
		for (String s : strings) {
			StringBuilder sb = new StringBuilder(); 
			
			for (int i = 1; i < s.length(); i++) {
				int d = (s.charAt(i) - s.charAt(i-1) + 26) % 26;
				sb.append(Integer.toString(d)).append("-");
			}
			
			String key = sb.toString();
			map.computeIfAbsent(key, value -> new ArrayList<>()).add(s);
		}
		
		return new ArrayList<>(map.values());
	}
}
