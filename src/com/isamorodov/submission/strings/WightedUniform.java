package com.isamorodov.submission.strings;

import com.isamorodov.utils.collections.MultiHashSet;
import com.isamorodov.utils.collections.Multiset;

import java.util.Scanner;

import static com.isamorodov.utils.DecimalUtils.getAllDividers;

/**
 * Created by xaxtix on 31.01.18.
 */
public class WightedUniform {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        int[] multiset = new int[26];

        for (char c : s.toCharArray()) {
            multiset[c - 'a']++;
        }

        loop:
        for (int a0 = 0; a0 < n; a0++) {
            long x = in.nextInt();
            for (int i = 1; i <= 26; i++) {
                if (multiset[i - 1] == 0 || x % i != 0) continue;
                if (multiset[i - 1] >= x / i) {
                    System.out.println("Yes");
                    continue loop;
                }
            }
            System.out.println("No");
            // your code goes here
        }
    }
}
