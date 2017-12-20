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
            int nHalf = n >> 1;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }

            if(n % 2 == 0) {
                System.out.println(0);
                continue;
            }

            int xor = 0;
            for (int j = 0; j < nHalf; j += 2) {
                xor ^= arr[j] ^ arr[n - 1 - j];
            }
            System.out.println(xor);
        }
    }
}
