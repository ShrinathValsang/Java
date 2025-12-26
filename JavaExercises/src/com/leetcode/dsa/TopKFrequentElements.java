package com.leetcode.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;


class Employee {
	
}
public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,3,1,1,1,2,2,3};
		int[] nums2 = {1,1,3,2,2,3,4,2,8,7,8,8,8,8,3,4,5,2};
		int k = 2;
		
		int[] result = new TopKFrequentElements().topKFrequent3(nums2, 3);
		System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
		
	}
	
	// doesn't return values in order of their occurrences
    public int[] topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
        	map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> x.getValue() - y.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	pq.add(entry);
        	if (pq.size() > k) pq.poll();
        }
        
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
        	Map.Entry<Integer, Integer> entry = pq.poll();
        	list.add(entry.getKey());
        }
        
        // convert Integer list to int array
        // convert List<Integer> to int[] in Java
        //return list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(list);
        return list.stream().mapToInt(i -> i.intValue()).toArray();
    }
    
    public int[] topKFrequent3(int[] nums, int k) {
//    	Map<Integer, Integer> map = new HashMap<>();
//    	
//    	for (int i : nums) {
//    		map.put(i, map.getOrDefault(i, 0) + 1);
//    	}
        
//    	Map<Integer, Integer> map1 = map.entrySet().stream()
//    		.sorted((e1, e2) -> e2.getValue() - e1.getValue())
//    		.limit(k)
//    		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    	
//    	return map.entrySet().stream()
//    		.sorted((e1, e2) -> e2.getValue() - e1.getValue())
//    		.limit(k)
//    		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
//    		.keySet().stream().mapToInt(Integer::intValue).toArray();
    	
//    	System.out.println("map.entrySet().stream()\r\n"
//    			+ "		.sorted((e1, e2) -> e2.getValue() - e1.getValue())\r\n"
//    			+ "		.limit(k)\r\n"
//    			+ "		.collect(Collectors.toList())\n" + map.entrySet().stream()
//		.sorted((e1, e2) -> e2.getValue() - e1.getValue())
//		.limit(k)
//		.collect(Collectors.toList()));
    	
//    	int[] result = new ArrayList<Integer>(map1.keySet()).stream().mapToInt(Integer::intValue).toArray();
//		//List<Integer> list2 = new ArrayList<Integer>(map1.keySet());
//    	int[] result2 = map1.keySet().stream().mapToInt(Integer::intValue).toArray();
//    	System.out.println(map1.keySet());
//    	return result2;

   
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        
        List<Integer> list = map.values().stream().sorted(Comparator.reverseOrder()).limit(k).collect(Collectors.toList());
        System.out.println(list);
        
        Map<Integer, Integer> map3 = map.entrySet().stream()
        	.filter(entry -> list.contains(entry.getValue()))
        	.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        	//.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        	//.collect(Collectors.toCollection(entry -> entry.getKey);
        int[] res1 = map3.keySet().stream().mapToInt(Integer::intValue).toArray();
        return res1;
        
        
//        Map<Integer, Integer> map2 =
//            map.entrySet()
//            .stream()
//            .sorted((x, y) -> y.getValue() - x.getValue())
//            .limit(k)
//            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        
//        System.out.println(map2);
//        System.out.println(map2.keySet());
//        int[] result = map2.keySet().stream().mapToInt(Integer::intValue).toArray();
//        
//        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        int min = nums[0], max = nums[0], n = nums.length;
        //int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = nums.length;
    	
        for (int i = 1; i < n; i++){
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }

        int[] freq = new int[max-min+1];

        for(int num: nums)
            freq[num-min]++;

        List<Integer>[] bucket = new ArrayList[n+1];

        int l =0;
        for (int i = 0; i < freq.length; i++) {
            if (bucket[freq[i]] == null) bucket[freq[i]] = new ArrayList<>();
            bucket[freq[i]].add(i+min);
            if(freq[i] > l) l = freq[i];
        }
        
        int[] ans = new int[k];
        int j = 0;
        for (int i = l; i > 0; i--) {
            if (bucket[i] != null) {
                for (Integer d : bucket[i]) {
                    ans[j++] = d;
                    if (j == k) break;
                }
            }
            
            if(j==k) break;
        }
        
        for (int x : ans) System.out.print(x + ","); 

        return ans;
    }


}
