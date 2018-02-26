package com.isamorodov.contents.week_of_code_36;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by xaxtix on 10.02.2018.
 */
public class expCom {

    static final long modulo = (long) (Math.pow(10, 9) + 7);

    private static long expertComputation(int n, long[] x, long[] y, long[] z) {

        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            BigInteger fMax = BigInteger.ZERO;

            for (int j = (int) (i - z[i]); j >= 0; j--) {
                BigInteger v = BigInteger.valueOf(x[j] * y[i] - y[j] * x[i]);
                if (v.compareTo(fMax) > 0) fMax = v;
            }


            sum = sum.add(fMax);

            if (i < n - 1) {
                x[i + 1] = sum.xor(BigInteger.valueOf(x[i + 1])).longValue();
                y[i + 1] =  sum.xor(BigInteger.valueOf(y[i + 1])).longValue();
                z[i + 1] =  sum.xor(BigInteger.valueOf(z[i + 1])).longValue();
            }
        }

        return sum.mod(BigInteger.valueOf(modulo)).longValue();
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
