package com.isamorodov.submission.strings;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by xaxtix on 29.01.18.
 */
public class SuperReducedString {
    static void super_reduced_string(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }

            if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        if (stack.isEmpty()) System.out.print("Empty String");
        else
            for (char c : stack) System.out.print(c);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        super_reduced_string(s);

    }

}
