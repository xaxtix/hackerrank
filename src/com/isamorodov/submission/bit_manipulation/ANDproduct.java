package com.isamorodov.submission.bit_manipulation;

import java.util.Scanner;

/**
 * Created by xaxtix on 21.12.17.
 */
public class ANDproduct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long and = 0;
            long currentBit = 0;
            long tmp = b;
            while (tmp > 0) {
                int bit = (int) (tmp % 2);
                if (bit == 1 && (a >> currentBit) % 2 == 1 && (b - (1L << currentBit)) <= a)
                    and += 1L << currentBit;

                tmp >>= 1;
                currentBit++;
            }
            System.out.println(and);
        }
    }
}
