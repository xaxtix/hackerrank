package com.isamorodov.submission.dynamic_programming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by xaxtix on 14.02.18.
 */
public class SamAndSubstrings {

    private static final long modulo = (int) (Math.pow(10, 9) + 7);

    private static long substrings(String balls) {
        char[] chars = balls.toCharArray();
        int n = chars.length;
        long sum = 0;

        long[] counts = new long[n];

        int k = 1;

        for (int i = 0; i < n; i++) {
            int value = chars[i] - '0';
            counts[n - i - 1] += value * k;
            k++;
        }

        for (int i = n - 2; i >= 0; i--) {
            counts[i] += counts[i + 1];
        }

        long v = 1;
        for (int i = 0; i < n; i++) {
            sum += (counts[i] % modulo * v) % modulo;
            sum %= modulo;
            v = (v * 10L) % modulo;
        }


        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String balls = in.next();
        long result = substrings(balls);
        System.out.println(result);
        in.close();
    }
}
