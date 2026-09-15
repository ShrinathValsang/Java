package com.barclays;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.SequencedMap;
import java.util.Set;
import java.util.TreeMap;

public class Test10 {
    public static void main(String[] args){
        //new Test().foo(1234);

        LinkedHashMap<Integer, String> lhmap = new LinkedHashMap<>();
        lhmap.put(10, "Ten");
        lhmap.put(11, "Eleven");
        lhmap.put(12, "Twelve");
        lhmap.put(13, "Thirteen");
        lhmap.put(14, "Fourteen");
        lhmap.put(30, "Thirty");
        lhmap.put(31, "ThirtyOne");
        lhmap.put(32, "ThirtyTwo");
        lhmap.put(33, "ThirtyThree");
        lhmap.put(34, "ThirtyFour");

        SequencedMap sequencedMap = lhmap.reversed();

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        String s = "abcdddeabcabc";
        System.out.println("getLongestSubstring(\"" + s + "\"): " + getLongestSubstring(s));
        s = "abcddeabbcabc";
        System.out.println("getLongestSubstring(\"" + s + "\"): " + getLongestSubstring(s));

    }

    public static String getLongestSubstring(String s) {
        int left = 0, maxl = 0, start = 0;
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));

            if (right - left + 1 > maxl) {
                maxl = right - left + 1;
                start = left;
            }
        }

        return s.substring(start, start + maxl);
    }

    public void foo(int a) {
        System.out.print(a % 10);

        if (a % 10 != 0) {
            foo(a / 10);
        }
        System.out.print(a % 10);

        int[] A = new int[] {2, 4};
        int[] B = new int[] {4, 2};
        System.out.println(countPairs(A, B));
  }

    public static int countPairs(int[] A, int[] B) {
        int count = 0;
        for (int a : A) {
            for (int b : B) {
                if (gcd(a, b) != 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;

            x = temp;
        }
        return x;
    }

    record Point(int x, int y) {}

    public static int beforeRecordPattern(Object obj) {
        int sum = 0;
        if(obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            sum = x+y;
        }
        return sum;
    }

    public static int afterRecordPattern(Object obj) {
        if(obj instanceof Point(int x, int y)) {
            return x+y;
        }
        return 0;
    }

    enum Color {RED, GREEN, BLUE}
    record ColoredPoint(Point point, Color color) {}

    record RandomPoint(ColoredPoint cp) {}
    public static Color getRamdomPointColor(Object r) {
        if(r instanceof RandomPoint(ColoredPoint cp)) {
            return cp.color();
        }
        return null;
    }

}
