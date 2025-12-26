package com.leetcode.dsa;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[]";
		String s1 = "{[(a+b)]}";
		//System.out.println(new BalancedBrackets().validateStringBrackets(s1));
		System.out.println(new BalancedBrackets().areBracketsBalanced(s1));
	}
	
	public boolean validateStringBrackets(String s) {
		Deque<Character> deque = new LinkedList<>();
		
		for (char ch : s.toCharArray()) {
			if (ch == '{' || ch == '[' || ch == '(') {
				deque.addFirst(ch);
			} else {
				if (!deque.isEmpty() && isBracketMatch(deque.peekFirst(), ch)) {
					deque.removeFirst();
				} else {
					return false;
				}
			}
		}
		
		return deque.isEmpty();
	}
	
	private boolean isBracketMatch(char c1, char c2) {
		return (c1 == '{' && c2 == '}' ||
				c1 == '[' && c2 == ']' ||
				c1 == '(' && c2 == ')');
	}
	
	public boolean isBalanced(String s) {
		while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
			s = s.replaceAll(s, s);
		}
		
		return false;
	}
	
	 public static boolean areBracketsBalanced(String s) {
        int i = -1;
        char[] stack = new char[s.length()];
        
        Integer v1 = Integer.valueOf(1);
        Integer v2 = Integer.valueOf(1);
        Integer v3 = 1;
        
        Integer v4 = new Integer(1); // purposely used new keyword here
        Integer v5 = Integer.valueOf(1);
        System.out.println("v1 == v2 -- " + (v1 == v2));
        System.out.println("v1 == v3 -- " + (v1 == v3));
        System.out.println("v4 == v5 -- " + (v4 == v5));
        
        for (char c : s.toCharArray()) {
        	if (!(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')) 
        		continue;
       
            if (c == '(' || c == '{' || c == '[')
                stack[++i] = c;
            else {
                if (i >= 0
                    && ((stack[i] == '(' && c == ')')
                        || (stack[i] == '[' && c == ']')
                        || (stack[i] == '{' && c == '}')))
                    i--;
                else
                    return false;
            }
        }
        
        return i == -1;
    }

}
