package com.sahilandsarra.interview_master_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
public class P2_ValidParentheses {

	public static void main(String[] args) {
		Map<Integer, String> map = new ConcurrentHashMap<>();
		P2_ValidParentheses ts = new P2_ValidParentheses();
		
//		System.out.println(ts.isValid("{}()[]"));
//		System.out.println(ts.isValid("({[]})"));
//		System.out.println(ts.isValid("{(asdfasdf)}(()[]"));
		System.out.println(ts.isValid("{()}"));

		//isValid3Simplified
		System.out.println(ts.isValid3Simplified("{()}"));
		System.out.println(ts.isValid3Simplified("{}"));

		String s = "([])";
		System.out.println("isValidWithoutUsingDeque(" + s + ") : " + ts.isValidWithoutUsingDeque(s)); // ()[]{} // ([])
		s = "nxoiurewq{(msdkte)}asd(sdafa)qplc[xctwg]asdfasd";
		System.out.println("isValidWithoutUsingDeque(" + s + ") : " + ts.isValidWithoutUsingDeque(s));
	}

	// This method tests the strings with all type of chars and parentheses
	public boolean isValidWithoutUsingDeque1(String s) {
		int top = 0;
		char[] charArr = new char[s.length()];

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				charArr[top++] = c;
			} else if (c == ')' || c == ']' || c == '}') {
				if (top <= 0) return false;

				char ch = charArr[top - 1];
				if (ch == '(' && c == ')' || ch == '[' && c == ']' || ch == '{' && c == '}') {
					top--;
				} else return false;
			}
		}

		return top == 0;
	}

	// Assuming string contains only parentheses!
	// Here we don't use Deque but a character array, making operations faster WORKS!
	public boolean isValidWithoutUsingDeque(String s) {
		int top = 0;
		char[] charArr = new char[s.length()];

		if (s.length() % 2 != 0) return false;

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				charArr[top++] = c;
			} else {
				if (top <= 0) return false;

				char ch = charArr[top - 1];
				if (ch == '(' && c == ')' || ch == '[' && c == ']' || ch == '{' && c == '}') {
					top--;
				} else return false;
			}
		}

		return top == 0;
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

	public boolean isValid3Simplified(String input) {
		Stack<Character> stack = new Stack<>();
		char[] arr = input.toCharArray();

		for (char c : arr) {
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else {
				if (stack.isEmpty()) return false;

				char peek = stack.peek();
				if (peek == '(' && c == ')' || peek == '[' && c == ']' ||peek == '{' && c == '}') {
					stack.pop();
				} else return false;
			}
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