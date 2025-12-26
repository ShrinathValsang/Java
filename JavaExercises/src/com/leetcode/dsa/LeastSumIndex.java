package com.leetcode.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class LeastSumIndex {

	public static void main(String[] args) {
		//String[] list1 = new String[] {"happy","sad","good", "filter", "no"};
		//String[] list2 = new String[] {"sad","happy","good", "yes", "no"};
		
		String[] list1 = new String[] {"happy","no","1", "filter", "happy"};
		String[] list2 = new String[] {"sad","happy","", "yes", "no"};
		
		String[] result = new LeastSumIndex().findRestaurant(list1, list2);
		for(String s : result) {
			System.out.println(s);
		}

	}

    public String[] findRestaurant1(String[] list1, String[] list2) {	
        Set<String> list22 = new HashSet<>(Arrays.asList(list2));
        System.out.println(list22);
        
        Map<String, Integer> map = new HashMap<>();
        int least_sum = list1.length + list2.length;
        
        for (String s : list1) {
            if (list22.contains(s)) {
                int ind1 = IntStream.range(0, list1.length).filter(i -> list1[i] == s).findFirst().orElse(-1);
                int ind2 = IntStream.range(0, list2.length).filter(i -> list2[i] == s).findFirst().orElse(-1);
                int sum = ind1 + ind2;
                
            	if (sum < least_sum) {
                    map.clear();
                    map.put(s, sum);
                    least_sum = sum;
                } else if (sum == least_sum) {
                    map.put(s, sum);
                }
            }
        }
        
        return map.keySet().toArray(new String[map.size()]);
    }
    
    public String[] findRestaurant(String[] list1, String[] list2) {
    	List<String> result = new ArrayList<>();
    	Map<String, Integer> map1 = new HashMap<>();
    	
    	for (int i = 0; i < list1.length; ++i) {
    		map1.put(list1[i], i);
    	}
    	
    	int least_sum = Integer.MAX_VALUE;
    	for (int i = 0; i < list2.length; i++) {
    		final String s = list2[i];
    		
    		if (map1.containsKey(s)) {
			//if (map1.containsKey(s) && (map1.get(s) + i) <= least_sum) {
        		int sum = map1.get(s) + i;
        		
        		if (sum < least_sum) {
					result.clear();
					result.add(s);
					least_sum = sum;
        		} else if (sum == least_sum) {
					result.add(s);
        		}
    		}
    	}
		
		return result.toArray(new String[result.size()]);
    }
}