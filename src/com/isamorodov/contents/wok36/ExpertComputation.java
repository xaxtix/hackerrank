package com.isamorodov.contents.wok36;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by xaxtix on 10.02.18.
 */
public class ExpertComputation {

    static final long modulo = (long) (Math.pow(10, 9) + 7);

    private static long expertComputation(int n, long[] x, long[] y, long[] z) {

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long fMax = Long.MIN_VALUE;

            for (int j = (int) (i - z[i]); j >= 0; j--) {
                long v = (x[j] * y[i] - y[j] * x[i]) % modulo;
                if (v > fMax) fMax = v;
            }


            sum += fMax;
            sum %= modulo;


            if (i < n - 1) {
                x[i + 1] = xor(x[i + 1], sum);
                y[i + 1] = xor(y[i + 1], sum);
                z[i + 1] = Math.abs(xor(z[i + 1], sum));
            }
        }

        return sum;
    }

    private static long xor(long l, long sum) {
        boolean negative = l < 0 ^ sum < 0;
        return (Math.abs(l) ^ Math.abs(sum)) * (negative ? -1 : 1);
    }


    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long[] x = new long[n];
        long[] y = new long[n];
        long[] z = new long[n];

        for (int i = 0; i < n; i++) {
            x[i] = in.nextLong();
        }

        for (int i = 0; i < n; i++) {
            y[i] = in.nextLong();
        }

        for (int i = 0; i < n; i++) {
            z[i] = in.nextLong();
        }

        System.out.println(expertComputation(n, x, y, z) % modulo);
    }


}
