package com.leetcode.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteGetRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    java.util.Random rand = new java.util.Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, map.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
        	int location = map.get(val);
        	if (location < list.size() - 1) {
        		int lastone = list.get(list.size() - 1);
        		list.set(location, lastone);
        		map.put(lastone, location);
        	}
            map.remove(val);
            list.remove(val);
            return true;
        }
        
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}