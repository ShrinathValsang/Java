package com.leetcode.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args1) {
		// TODO Auto-generated method stub
		//Input: strs = ["eat","tea","tan","ate","nat","bat"]
		//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
		String[] args = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(new GroupAnagrams().groupAnagrams3(args));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        
        /*for (int i = 0; i < strs.length; i++) {
            int[] indices = new int[26];
            strs[i].chars().forEach(x -> indices[x - 'a']++);
            
            System.out.println(indices);
        }*/
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
        	char[] chars = s.toCharArray();
        	Arrays.sort(chars);
        	String key = String.valueOf(chars);
        	
        	if (!map.containsKey(key)) {
        		map.put(key, new ArrayList<>());
        	}
    		map.get(key).add(s);
    		
    		map.computeIfAbsent(key, value -> new ArrayList<>()).add(s);
        }
        
        /*for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        	result.add(entry.getValue());
        }*/
        
        for (String s : map.keySet()) {
        	result.add(map.get(s));
        }
        
        return result;
    }
	
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for (String s : strs) {
            int[] occ = new int[26];
            char[] arr = s.toCharArray();
            
            for (char c : arr) {
                occ[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
            	sb.append('a' + i);
            	sb.append(occ[i]);
            }
            
            String key = sb.toString();
            map.computeIfAbsent(key, value -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public List<List<String>> groupAnagrams3(String[] strs) {
    	Map<String, List<String>> map = new HashMap<>();
    	
    	for (String s : strs) {
    		char[] chars = new char[26];
    		for (char c : s.toCharArray()) {
    			chars[c - 'a']++;
    		}
    		
    		String key = String.valueOf(chars);
    		
    		map.computeIfAbsent(key, value -> new ArrayList<>()).add(s);
		}
    	
    	return new ArrayList<>(map.values());
    }

}
