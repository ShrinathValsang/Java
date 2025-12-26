package com.sahilandsarra.interview_master_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P2_ValidParentheses {

	public static void main(String[] args) {
		P2_ValidParentheses ts = new P2_ValidParentheses();
		
//		System.out.println(ts.isValid("{}()[]"));
//		System.out.println(ts.isValid("({[]})"));
//		System.out.println(ts.isValid("{(asdfasdf)}(()[]"));
		System.out.println(ts.isValid("{()}"));
	}
	
    public boolean isValid3(String input) {
    	Stack<Character> stack = new Stack<>();
    	
    	for (char c : input.toCharArray()) {
    		if (c == '(') 
    			stack.push(')');
    		else if (c == '{') 
    			stack.push('}');
    		else if (c == '[') 
    			stack.push(']');
    		//else if (c != stack.pop() || stack.isEmpty()) return false; -- order-of-evaluation trap! incorrect
    		else if (stack.isEmpty() || stack.pop() != c) 
    			return false;
    	}
    	
        return stack.isEmpty();
    }
	
    public boolean isValid2(String input) {
    	Stack<Character> stack = new Stack<>();
    	
    	Map<Character, Character> map = new HashMap<>();
    	map.put('(', ')');
    	map.put('{', '}');
    	map.put('[', ']');
    	
    	for (char ch : input.toCharArray()) {
    		if (map.containsKey(ch)) {
    			stack.push(map.get(ch));
    		} else if (stack.isEmpty() || stack.pop() != ch) {
				return false;
			}
    	}
    	
        return stack.isEmpty();
    }
    
    // most efficient -- in the similar fashion as stack
    public boolean isValid(String s) {
    	char[] chars = new char[s.length()];
    	int top = 0;
    	
    	for (char ch : s.toCharArray()) {
    		if (ch == '(') chars[top++] = ')';
    		else if (ch == '{') chars[top++] = '}';
    		else if (ch == '[') chars[top++] = ']';
    		else if (top == 0 || ch != chars[--top]) return false; 
    	}
    	
    	return top == 0;
    }
    
    
}