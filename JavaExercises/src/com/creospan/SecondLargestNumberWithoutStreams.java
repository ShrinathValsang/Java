package com.creospan;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Check whether A string has balanced parantheses or valid paranetheses
 * 
 * CalSoft
 */
public class SecondLargestNumberWithoutStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("{[()]} : " + isBalanced("{[()]}"));
		System.out.println("{a[d(dcdfds)sd]adf23r}3 : " + isBalanced("{a[d(dcdfds)sd]adf23r}3"));
		System.out.println("{a[}]d(ds)r(}3) : " + isBalanced("{a[}]d(ds)r(}3)"));
		System.out.println("{[]}(}) : " + isBalanced("{[]}(})")); // [()]{}{[()()]()}
		
		System.out.println("[()]{}{[()()]()} : " + isBalanced("[()]{}{[()()]()}"));
		System.out.println("[(]) : " + isBalanced("[(])"));
		System.out.println("{[]}(}) : " + isBalanced("{[]}(})"));

	}
	
	public static boolean isBalanced(String s) {
		char[] arr = s.toCharArray();
		Deque<Character> deque = new ArrayDeque<>();
		
		for (char c : arr) {
			if (c == '{' || c == '[' || c == '(') {
				deque.push(c);
				continue;
			}
			
			// If the current char is not opening, it must be closing.
			// Hence at this point the stack cannot be empty.
			// if the deque is not empty, the string has unbalanced parantheses
			if (deque.isEmpty()) {
				return false;
			}
			
			char pop = deque.pop();
			if (!isMatching(pop, c)) {
				return false;
			}
		}
		
		return deque.isEmpty();
	}
	
	private static boolean isMatching(char pop, char c) {
		return (c == '}' && pop == '{') ||
				(c == ']' && pop == '[') || 
				(c == ')' && pop == '(');
	}

}
