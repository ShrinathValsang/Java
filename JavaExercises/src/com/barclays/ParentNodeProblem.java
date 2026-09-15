package com.barclays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ParentNodeProblem {
    static List<List<Integer>> tree;
    static List<List<Integer>> newTree;
    static char[] values;
    static int[] subtreeSize;

    public static void main(String[] args) {
        // Read number of vertices
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            values = new char[N+1];
            for (int i = 1; i <= N; i++) {
                values[i] = sc.next().charAt(0);
            }

            tree = new ArrayList<>();
            for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());
            // Read edges
            for (int i = 0; i < N - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            newTree = new ArrayList<>();
            for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

            // Step 1 - Re-attach nodes
            dfsAttach(1, -1, new HashMap<>());

            // Step 2 - Compute subtree sizes
            subtreeSize = new int[N + 1];
            dfsCount(1);

            // Output
            for (int i = 1; i <= N; i++) {
                System.out.print(subtreeSize[i] + " ");
            }
            System.out.println();


        }
    }

    private static int dfsCount(int node) {
        int count = 1;
        for (int child : newTree.get(node)) {
            count += dfsCount(child);
        }
        subtreeSize[node] = count;
        return count;
    }

    private static void dfsAttach(int node, int parent, Map<Character, Deque<Integer>> map) {
        char c = values[node];
        int validParent = -1;

        if (map.containsKey(c) && !map.get(c).isEmpty()) {
            validParent = map.get(c).peek();
            newTree.get(validParent).add(node);
        }

        if (validParent == -1 && parent != -1) {
            newTree.get(parent).add(node);
        }

        map.putIfAbsent(c, new ArrayDeque<>());
        map.get(c).push(node);

        for (int child : tree.get(node)) {
            if (child != parent) {
                dfsAttach(child, node, map);
            }
        }

        map.get(c).pop();
    }



}
