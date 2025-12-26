package com.calsoft;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Check whether A string has balanced parentheses or valid parenetheses
 * 
 * CalSoft
 */
public class BalancedParentheses {

	public static void main(String[] args) {
		System.out.println("{[()]} : " + iBalanced("{[()]}"));
		System.out.println("{a[d(dcdfds)sd]adf23r}3 : " + iBalanced("{a[d(dcdfds)sd]adf23r}3"));
		System.out.println("{a[}]d(ds)r(}3) : " + iBalanced("{a[}]d(ds)r(}3)"));
		System.out.println("{[]}(}) : " + iBalanced("{[]}(})")); // [()]{}{[()()]()}
		System.out.println("[()]{}{[()()]()} : " + iBalanced("[()]{}{[()()]()}"));
		System.out.println("[(]) : " + iBalanced("[(])"));
		System.out.println("{[]}(}) : " + iBalanced("{[]}(})"));
	}
	
	public static boolean iBalanced(String str) {
		Deque<Character> deque = new ArrayDeque<>();
		
		for (char c : str.toCharArray()) {
			if (c == '(' || c == '{'  || c == '[') {
				deque.push(c);
				continue;
			}
			
			// This is wrong as it runs for every character that is not an opening bracket!!
			// Hence it fails when ther are characters even when parentheses are balalnced.
			//if (deque.isEmpty()) return false;
			
			if (c == ')' || c == '}'  || c == ']') {
				if (deque.isEmpty()) return false;
				
				char pop = deque.pop();
				if (c == ')' && pop != '(') return false;
				if (c == '}' && pop != '{') return false;
				if (c == ']' && pop != '[') return false;
			}
		}
		
		return deque.isEmpty();
	}
	
	// More verbose that above version
	public static boolean isBalancedUsingDeque(String s) {
		Deque<Character> deque = new LinkedList<>();
		
		for (char c : s.toCharArray()) {
			if (c == '{' || c == '[' || c == '(') {
				deque.addFirst(c);
			} else {
				if (deque.isEmpty()) return false;
				
				char tc = deque.peekFirst();
				boolean flag = (tc == '{' && c == '}') 
						|| (tc == '[' && c == ']') 
						|| (tc == '(' && c == ')');
				
				if (flag) deque.removeFirst();
				else return false;
			}
		}
		
		return deque.isEmpty();
	}
	
	public static boolean isBalancedUsingStringUtils(String s) {
		//s = "{{[]()}()}";
		
		while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
			s = s.replaceAll("\\{\\}", "")
					.replaceAll("\\[\\]", "")
					.replaceAll("\\(\\)", "");
		}
		
		return (s.length() == 0);
	}
	
	public static boolean isBalanced(String s) {
		int index = -1;
        char[] stack = new char[s.length()];
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++index] = ch;
            } else {
            	if (index < 0) return false;
            	
            	if ((stack[index] == '(' && ch == ')')
                        || (stack[index] == '{' && ch == '}')
                        || (stack[index] == '[' && ch == ']'))
            		index--;
                else
                    return false;
            }
        }
        
        return index == -1;
	}
	
}
