package com.codingtests.calsoft;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParanthesesString {

	public static void main(String[] args) {
//		System.out.println("{[()]} : " + areParenthesesBalanced("{[()]}"));
//		System.out.println("{a[d(dcdfds)sd]adf23r}3 : " + areParenthesesBalanced("{a[d(dcdfds)sd]adf23r}3"));
		System.out.println("{a[}]d(ds)r(}3) : " + areParenthesesBalanced("{a[}]d(ds)r(}3)"));
//		System.out.println("{[]}(}) : " + areParenthesesBalanced("{[]}(})")); // [()]{}{[()()]()}
		
		System.out.println("[()]{}{[()()]()} : " + areParenthesesBalanced("[()]{}{[()()]()}"));
		System.out.println("[(]) : " + areParenthesesBalanced("[(])"));
//		System.out.println("{[]}(}) : " + areParenthesesBalanced("{[]}(})"));
	}
	
	public static boolean areParenthesesBalanced(String str) {
		char[] arr = str.toCharArray();
		Deque<Character> deque = new ArrayDeque<>();
		
		for (char c : arr) {
			if (c == '{' || c == '[' || c == '(') {
				deque.push(c);
				continue;
			}
			
			// If current char is not 'opening', then it must be 'closing'
			// and hence the stack cannot be empty. Otherwise string is not balanced.
			if (deque.isEmpty()) {
				return false;
			}
			
			if (c == '}' || c == ']' || c == ')') {
				return isMatching(deque.pop(), c);
			}
		}
		
		return deque.isEmpty();
	}

	private static boolean isMatching(Character pop, char c) {
		/*if (c == '}' && pop == '{')
			return true;
		else if (c == ']' && pop == '[')
			return true;
		else if (c == ')' && pop == '(')
			return true;
		else 
			return false;*/
		
		switch (c) {
			case '}' :
				if (pop == '{') return true;
				else return false;
			case ']' :
				if (pop == '[') return true;
				else return false;
			case ')' :
				if (pop == '(') return true;
				else return false;
			default:
				return false;
		}
	}

}
