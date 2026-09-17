package com.linkedin.posts;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Implement a function to sort a stack using another stack.
class StackSorting {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");

        int[] arr1 = {1,0,1,1,0,0,1,1,0};
        int[] arr2 = {1,1,1, 1,1};
        int[] arr3 = {0,0,0,0,0};
        int[] arr4 = {1,1,1,1,0};

        int[] arr = {5, 0, 2, 0, 4, 0, 1, 0, 3, 0};


        Stack<Integer> input = new Stack<>();
        input.addAll(List.of(65, 31, 7, 84, 27, 34, 92, 57, 98, 71));
        System.out.println("Before sorting: " + input);

        input = new StackSorting().sortStack(input);
        System.out.println("After sorting: " + input);
    }

    // ALGORITHM / APPROACH
    // 1. Create a temporary stack (tmpStack).
    // 2. While the input stack is not empty, pop an element (curr).
    // 3. While tmpStack is not empty and its top element is greater than curr, pop from tmpStack and push back into the input stack.
    // 4. Push curr into tmpStack. Repeat until input stack is sorted
    public Stack<Integer> sortStack(Stack<Integer> input) {
        // 1. Create a temporary stack (tmpStack).
        Stack<Integer> temp = new Stack<>();

        // 2. While the input stack is not empty, pop an element (curr).
        while (!input.isEmpty()) {
            int current = input.pop();

            // 3. While tmpStack is not empty and its top element is greater than curr, pop from tmpStack and push back into the input stack.
            while (!temp.isEmpty() && temp.peek() < current) {
                input.push(temp.pop());
            }

            // 4. Push curr into tmpStack. Repeat until input stack is sorted
            temp.push(current);
        }

        while (!temp.isEmpty()) {
            input.push(temp.pop());
        }

        return input;
    }

}

