package com.isamorodov.submission.bit_manipulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xaxtix on 29.01.18.
 */
public class XorMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        long n = in.nextLong();

        long arr[] = new long[m];
        for (int i = 0; i < m; i++) {
            arr[i] = in.nextInt();
        }

        long line[] = Arrays.copyOf(arr, m);
        for (int i = 0; i < n - 1; i++) {
            long nextLine[] = new long[m];
            for (int j = 0; j < m; j++) {
                nextLine[j] = line[j] ^ line[(j + 1) % m];
                System.out.print(nextLine[j] + " ");
            }
            System.out.println();
            line = Arrays.copyOf(nextLine,m);
        }

        System.out.println();

        if (n == 2) {
            for (int i = 0; i < m; i++) {
                System.out.print((arr[i] ^ arr[(i + 1) % m]) + " ");
            }
            return;
        }

        long secondLine[] = new long[m];

        for (int i = 0; i < m; i++) {
            secondLine[i] = arr[i] ^ arr[(i + 2) % m];
        }

        if (n % 3 == 0) {
            int offset = (int) ((n - 3) % m);
            for (int i = 0; i < m; i++) {
                System.out.print((secondLine[(m - i + offset + 1) % m]) + " ");
            }
        } else {
            long offset = n - 4;
            for (int i = 0; i < m; i++) {
                System.out.print((secondLine[(int) (Math.abs(i - offset) % m)] ^ secondLine[(int) (Math.abs(i - offset + 1) % m)]) + " ");
            }
        }


    }
}
