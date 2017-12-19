package com.isamorodov.submission.bit_manipulation;

import java.util.Scanner;

/**
 * Created by xaxtix on 19.12.17.
 */
public class SumVSxor {

    static long solve(long n) {
        long count = 0;
        while (n != 0) {
            if(n % 2 == 0) count++;
            n >>= 1;
        }
        return (long) Math.pow(2,count);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);
        System.out.println(result);
    }
}
