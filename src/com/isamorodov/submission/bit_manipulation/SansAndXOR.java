package com.isamorodov.submission.bit_manipulation;

import java.util.Scanner;

/**
 * Created by xaxtix on 20.12.17.
 */
public class SansAndXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for (int i = 0; i < a; i++) {
            int n = in.nextInt();
            int nHalf = n / 2;
            long[] arr = new long[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }

            if (n % 2 == 0) {
                System.out.println(0);
                continue;
            }

            long xor = 0;
            for (int j = 0; j <= nHalf; j += 2) {
                if (j == n - 1 - j) xor ^= arr[j];
                else xor ^= arr[j] ^ arr[n - 1 - j];
            }
            System.out.println(xor);
        }
    }
}
