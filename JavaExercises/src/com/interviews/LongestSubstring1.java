package com.interviews;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring1 {
    public static void main(String[] args) {
//        System.out.println("longestSubstringMSCopilot: " + longestSubstringMSCopilot(s));
//        System.out.println("longestSubstringMSCopilot: " + longestSubstringMSCopilot("abcabcdefbbabab"));

        String s = "abcabcdefbbabab";
        System.out.println("longestSubstringUsingIf: " + longestSubstringUsingIf(s));
        System.out.println("longestSubstringUsingWhile: " + longestSubstringUsingWhile(s));

        System.out.println("getLongestSubstringMy(\"abba\"): " + longestSubstringUsingIf("abba"));
        System.out.println("getLongestSubstringMy(\"abba\"): " + longestSubstringUsingWhile("abba"));
        System.out.println("longestSubstringUsingMap(\"abba\"): " + longestSubstringUsingMap("abba"));
        System.out.println("getLongestSubstringUsingMap(\"abba\"): " + getLongestSubstringUsingMap("abba"));

        System.out.println("getLongestSubstringMy(\"abcade\"): " + longestSubstringUsingIf("abcade"));
        System.out.println("getLongestSubstringMy(\"abcade\"): " + longestSubstringUsingWhile("abcade"));
        System.out.println("longestSubstringUsingMap(\"abcade\"): " + longestSubstringUsingMap("abcade"));
        System.out.println("getLongestSubstringUsingMap(\"abcade\"): " + getLongestSubstringUsingMap("abcade"));

        System.out.println("------------------");
        System.out.println("lengthOfLongestSubstring(\"abcade\"): " + lengthOfLongestSubstring("abcade"));
        System.out.println("lengthOfLongestSubstring(\"abba\"): " + lengthOfLongestSubstring("abba"));
        System.out.println("lengthOfLongestSubstring(\"abcdddeabcabc\"): " + lengthOfLongestSubstring("abcdddeabcabc"));


    }

    // has some flaws - not fullproof
    public static String longestSubstringUsingIf(String s) {
        int start = 0, r = 0, l = 0, maxl = 0;
        Set<Character> seen = new HashSet<>();

        for (; r < s.length(); r++) {
            char c = s.charAt(r);

            if (seen.contains(c)) {
                // seen.remove(c);
                seen.remove(s.charAt(l));
                l++; // increment left
            }
            seen.add(c);

            if ((r - l + 1) > maxl) {
                maxl = (r - l + 1);
                start = l;
            }
        }

        return s.substring(start, start + maxl);
    }

    // working -
    public static String longestSubstringUsingWhile(String s) {
        int start = 0, right = 0, left = 0, maxl = 0;
        Set<Character> set = new HashSet<>();

        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);

            if (right - left + 1 > maxl) {
                maxl = right - left + 1;
                start = left;
            }
        }

        return s.substring(start, start + maxl);
    }

    // working - best approach
    public static String longestSubstringUsingMap(String s) {
        int right = 0, left = 0, start = 0, maxl = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);

            if (right - left + 1 > maxl) {
                maxl = right - left + 1;
                start = left;
            }
        }

        return s.substring(start, start + maxl);
    }

    public static String getLongestSubstringUsingMap(String s) {
        int right = 0,  // right pointer
                left = 0,   //left pointer
                start = 0,  // max length start index
                maxl = 0;   // max length
        Map<Character, Integer> map = new HashMap<>();

        for (; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);

            if (right - left + 1 > maxl) {
                maxl = right - left + 1;
                start = left;
            }

        }

        return s.substring(start, start + maxl);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxl = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));

            maxl = Math.max(maxl, right - left + 1);
        }

        return maxl;
    }

    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
