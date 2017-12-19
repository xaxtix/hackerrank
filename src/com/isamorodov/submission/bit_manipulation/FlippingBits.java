package com.isamorodov.submission.bit_manipulation;

import java.util.Scanner;

/**
 * Created by xaxtix on 19.12.17.
 */
public class FlippingBits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            long x = in.nextLong();
            System.out.println(flippingBits(x));
        }
    }

    private static long flippingBits(long x) {
        long out = 0;
        for (int i = 0; i < 32; i++) {
            if (x % 2 == 0) out += Math.pow(2, i);
            x >>= 1;
        }
        return out;
    }
}
