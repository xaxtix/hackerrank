package com.isamorodov.contents.rookie_rank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by xaxtix on 16.02.18.
 */
public class WinninghandOfCard {

    static int winningHands(int m, int x, int n, int[] a) {

        int k = 0;
        for(int i = 0; i < n; i++){
            a[i] %= m;
            if(a[i] != 0) {
                a[k] = a[i];
                k++;
            }
        }
        long varaitions = 1L << k;
        int sum = 0;
        for (long i = 1; i < varaitions; i++) {
            long tmp = i;
            int v = 1;
            for (int j = 0; j < n; j++) {
                if (tmp % 2 == 1) v = (v * a[j]) % m;
                tmp >>= 1;
            }
            if(v == x) sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int result = winningHands(m, x, n, a);
        System.out.println(result);
        in.close();
    }
}
