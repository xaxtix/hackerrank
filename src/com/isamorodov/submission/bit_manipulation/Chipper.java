package com.isamorodov.submission.bit_manipulation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xaxtix on 22.12.17.
 */
public class Chipper {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String line = in.next();
        char[] chars = line.toCharArray();

        int[] out = new int[n];
        int layers = 0;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            if (layers == k) {
                xor ^= out[i - layers ];
            }
            out[i] = xor ^ (chars[i] - '0');
            xor ^=  out[i];
            if (layers < k) layers++;
        }


        for (int i : out)
            System.out.print(i);

    }
}
