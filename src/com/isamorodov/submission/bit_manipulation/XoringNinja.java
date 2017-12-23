package com.isamorodov.submission.bit_manipulation;

import java.util.Scanner;

/**
 * Created by xaxtix on 21.12.17.
 */
public class XoringNinja {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for (int a_i = 0; a_i < a; a_i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            long len = 1L << n;
            long sum = 0;
            for (long i = 0; i < len; i++) {
                long tmp = i;
                int index = 0;
                long xor = 0;
                while (tmp > 0) {
                    if (tmp % 2 == 1) xor ^= arr[index];
                    tmp >>= 1;
                    index++;
                }

                sum += xor;
            }

            System.out.println(sum);
        }
    }

}
