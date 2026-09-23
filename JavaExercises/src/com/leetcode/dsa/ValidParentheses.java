package com.leetcode.dsa;

// 22-Sep-2026
// 20 https://leetcode.com/problems/valid-parentheses/description/

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println("Try clicking the Run button.");

        String s1 = "a{b[c]d}e";     // → true
        String s2 = "hello(world)";  // → true
        String s3 = "a{b[c}d]";      // → false

        System.out.println(s1 + " is balanced? : " + isBalanced(s1));
        System.out.println(s2 + " is balanced? : " + isBalanced(s2));
        System.out.println(s3 + " is balanced? : " + isBalanced(s3));
    }

    public static boolean isBalanced(String s) {
        if (s == null || s.isEmpty()) return false;

        // match anything except these brackets - ()[]{}
        String pattern = "[^()\\[\\]{}]";
        s = s.replaceAll(pattern, "");

        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }

        return s.isEmpty();
    }


    // string contains characters and parentheses
    public static boolean isBalancedDeque(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') dq.offerFirst(c);

            if (!dq.isEmpty()) {
                char peek = dq.peekFirst();
                if (c == ')' && peek == '(' ||
                        c == ']' && peek == '[' ||
                        c == '}' && peek == '{' ) dq.pollFirst();

            }
        }

        return dq.isEmpty();
    }

}
