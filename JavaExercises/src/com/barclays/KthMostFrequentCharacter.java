package com.barclays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * Find all kth-most frequently occurring character group.
 *
 * String s = “fffrrrvv vvvvss22 231234 fff ggg ttt yyyy”
 * letters present 2nd max time, 2-4, y-4, r-4, f-6, v-6, 3-2, g-3
 * Ans is [2, y, r]
 *
 * Also, added kth most frequent character method.
 *
 * Created
 * @ Updated 10 Aug 2026
 */
public class KthMostFrequentCharacter {
    public static void main(String[] args) {
        //char c = kthLargestFrequencyChar("Shonenbaum", 2); // NOT CAPITAL LETTERS only lowercase letters
        String s = "shonenbaum"; int k = 2;
        System.out.println("String: " + s + ", K=" + k + " result: " + kthMostFrequentChar(s, k));

        /*s = "shonenbaum"; k = 1;
        System.out.println("String: " + s + ", K=" + k + " result: " + kthMostFrequentChar2(s, k));

        s = "bananan"; k = 2;
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentChar              result: " + kthMostFrequentChar(s, k));
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentCharUsingStreams  result: " + kthMostFrequentCharUsingStreams(s, k));
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentChar2  result: " + kthMostFrequentChar2(s, k));

        s = "bananan"; k = 1;
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentChar  result: " + kthMostFrequentChar(s, k));
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentChar2  result: " + kthMostFrequentChar2(s, k));

        s = "mississippi"  ; k = 3;
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentChar  result: " + kthMostFrequentChar(s, k));
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentChar2  result: " + kthMostFrequentChar2(s, k));*/

        s = "banana"; k = 2;
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentChar         result: " + kthMostFrequentChar(s, k));
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentCharStreams  result: " + kthMostFrequentCharStreams(s, k));
        System.out.println();
        System.out.println();

        char[] arr11 = kthMostFrequentCharacterGroup(s, k);
        List<Character> list11 = IntStream.range(0, arr11.length).mapToObj(i -> arr11[i]).toList();
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentCharacterGroup        result: " + list11);
        char[] arr12 = kthMostFrequentCharacterGroupStreams(s, k);
        List<Character> list12 = IntStream.range(0, arr12.length).mapToObj(i -> arr12[i]).toList();
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentCharacterGroupStreams  result: " + list12);
        System.out.println();

        s = "bananan"; k = 2;
        char[] arr21 = kthMostFrequentCharacterGroup(s, k);
        List<Character> list21 = IntStream.range(0, arr21.length).mapToObj(i -> arr21[i]).toList();
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentCharacterGroup        result: " + list21);
        char[] arr22 = kthMostFrequentCharacterGroupStreams(s, k);
        List<Character> list22 = IntStream.range(0, arr22.length).mapToObj(i -> arr22[i]).toList();
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentCharacterGroupStream  result: " + list22);


        System.out.println();
        String s1 = "fffrrrrvv vvvvss22 231234 fff ggg ttt yyyy"; k = 2;
        s = "fffrrrrvvvvvvss22231234fffgggtttyyyy"; k = 2;
        // letters present 2nd max time, 2-4, y-4, r-4, f-6, v-6, 3-2, g-3

        char[] arr31 = kthMostFrequentCharacterGroup(s, k);
        List<Character> list31 = IntStream.range(0, arr31.length).mapToObj(i -> arr31[i]).toList();
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentCharacterGroup         result: " + list31);
        char[] arr32 = kthMostFrequentCharacterGroupStreams(s, k);
        List<Character> list32 = IntStream.range(0, arr32.length).mapToObj(i -> arr32[i]).toList();
        System.out.println("String: " + s + ", K=" + k + " kthMostFrequentCharacterGroupStreams  result: " + list32);

    }

    public static char kthMostFrequentChar(String s, int k) {
        if (k <= 0 || s.isEmpty() || s == null) return '_';

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());

        // sort character in descending order of their occurrences
        // if occurrences collide, place the earlier char first i.e. place m before n, o, p etc.
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                //return b.getValue() - a.getValue();
                return b.getValue().compareTo(a.getValue());
            } else {
                return a.getKey() - b.getKey();
            }
        });
        System.out.println(list);

        // Find the Kth most frequent character
        int lastFreq = list.get(0).getValue(), rank = 1; // most freq char occ
        for (Map.Entry<Character, Integer> entry : list) {
            if (entry.getValue() != lastFreq) {
                lastFreq = entry.getValue();
                rank++;
            }
            if (rank == k) return entry.getKey();
        }

        return '-'; // edge case: k > number of char frequency groups
    }

    public static char kthMostFrequentCharStreams(String s, int k) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting())
                ). // returns a Map<Character, Long>, count as Long
                        entrySet().stream()
                /*.sorted((e1, e2) -> {
                    if (!e1.getValue().equals(e2.getValue())) {
                        return (e2.getValue().longValue() - e1.getValue().longValue()) > 0 ? 1 : -1; // sort by frequency descending
                    } else {
                        return e1.getKey() - e2.getKey();
                    }
                })*/ // this works but below code is more simpler, readable
                .sorted(
                        Comparator
                                //.comparing(entry -> entry.getValue(), Comparator.reverseOrder())
                                // This fails because
                                // compiler cannot infer the exact type of entry.getValue(), compiler sees object
                                .comparing(Map.Entry<Character, Long>::getValue, Comparator.reverseOrder())
                                .thenComparing(entry -> entry.getKey())
                )
                .skip(k-1)
                .map(Map.Entry<Character, Long>::getKey)
                .findFirst().orElse('-');
    }

    public static char[] kthMostFrequentCharacterGroupStreams(String s, int k) {
        char[] kthFrequentChars = s.chars()
                .mapToObj(c -> (char) c) // returns IntStream
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Map.Entry<Character, Long> -- frequency map
                .entrySet()// Set<Map.Entry<Character, Long>>
                .stream() // Map.Entry<Character, Long>
                .sorted(
                        Comparator.comparing(Map.Entry<Character, Long>::getValue, Comparator.reverseOrder())
                ) // Map.Entry<Character, Long> -- descending by number of occurrences
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue, // group chars with same count
                        LinkedHashMap::new, // preserves the insertion order after sorting !
                        Collectors.toList())
                ) // Map<Long, List<Map.Entry<Character, Long>>>
                .values() // collection of List<Map.Entry<Character, Long>>
                .stream()
                .skip(k - 1).findFirst() // kth-frequency character group - - List<Map.Entry<Character, Long>>
                .orElse(Collections.emptyList()) // handle edge case - when k is greater than actual character groups
                .stream()
                .map(Map.Entry::getKey) // get the characters
                .collect(
                        StringBuilder::new,    // supplier - create a new StringBuilder
                        StringBuilder::append, // accumulator - append each element
                        StringBuilder::append  // combiner - merge builders in parallel
                )
                .toString().toCharArray();

        return kthFrequentChars;

        /*return s.chars()
                .mapToObj(c -> (char) c) // returns IntStream
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Map.Entry<Character, Long> -- frequency map
                .entrySet()// Set<Map.Entry<Character, Long>>
                .stream() // Map.Entry<Character, Long>
                .sorted(
                        Comparator.comparing(Map.Entry<Character, Long>::getValue, Comparator.reverseOrder())
                ) // Map.Entry<Character, Long> -- descending by number of occurrences
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue, // group chars with same count
                        LinkedHashMap::new, // preserves the insertion order after sorting !
                        Collectors.toList())
                ) // Map<Long, List<Map.Entry<Character, Long>>>
                .values() // collection of List<Map.Entry<Character, Long>>
                .stream()
                .skip(k - 1).findFirst() // kth-frequency character group - - List<Map.Entry<Character, Long>>
                .orElse(Collections.emptyList()) // handle edge case - when k is greater than actual character groups
                .stream() // stream of Map.Entry<Character, Long>
                .map(entry -> entry.getKey().toString()) // extract the characters
                .collect(Collectors.joining()).toCharArray(); // form the character array
*/


    }

    public static char[] kthMostFrequentCharacterGroup(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return new char[0];

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // sort character in descending order of their occurrences
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        System.out.println(list);

        // Find the Kth most frequent character group
        int lastFreq = list.get(0).getValue(), rank = 1;
        List<Character> charGroup = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : list) {
            if (entry.getValue() != lastFreq) {
                lastFreq = entry.getValue();
                rank++;
                //charGroup.clear();
            }
            if (rank == k) {
                charGroup.add(entry.getKey());
            }
        }

        // convert List<Character> to char[]
        // char[] cg1 = charGroup.stream().map(c -> c.toString()).collect(Collectors.joining()).toCharArray(); // slightly inefficient
        char[] result = new char[charGroup.size()];
        for (int i = 0; i < charGroup.size(); i++) {
            result[i] = charGroup.get(i);
        }

        char[] result2 =
                charGroup.stream()
                        // <R> R collect(Supplier<R> supplier,
                        //              BiConsumer<R, ? super T> accumulator,
                        //              BiConsumer<R, R> combiner)
                        .collect(
                                StringBuilder::new,    // supplier - create a new StringBuilder
                                StringBuilder::append, // accumulator - append each element
                                StringBuilder::append  // combiner - merge builders in parallel
                        ).toString().toCharArray();

        return result;
    }

}
