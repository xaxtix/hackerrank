package com.isamorodov.submission.search;

import java.util.Scanner;

/**
 * Created by xaxtix on 04.03.2018.
 */
public class SherlockAndArray {

    static String solve(int n, int[] a) {
        long sumR = 0;
        long sumL = 0;
        for (int i = 1; i < n; i++) sumR += a[i];

        if(sumR == 0) return "YES";
        for (int i = 0; i < n - 1; i++) {
            sumR -= a[i + 1];
            sumL += a[i];
            if(sumL == sumR) return  "YES";
        }

        return "NO";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int a0 = 0; a0 < T; a0++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            String result = solve(n, a);
            System.out.println(result);
        }
    }
}
