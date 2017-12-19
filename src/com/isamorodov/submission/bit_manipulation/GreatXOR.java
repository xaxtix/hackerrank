package com.isamorodov.submission.bit_manipulation;

import java.util.Scanner;

/**
 * Created by xaxtix on 19.12.17.
 */
public class GreatXOR {

    static long theGreatXor(long x) {
        long sum = 0;
        int position = 0;
        while (x != 0) {
            if (x % 2 == 0) sum += Math.pow(2, position);
            x >>= 1;
            position++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
    }
}
