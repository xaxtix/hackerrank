package com.isamorodov.submission.dynamic_programming;

import java.util.*;

/**
 * Created by xaxtix on 29.12.17.
 */
public class SherlokAndCost {

    static int cost(int[] arr) {
        int n = arr.length;
        int lowMax = 0;
        int topMax = 0;
        for (int i = 1; i < n; i++) {
            int topTop = topMax + Math.abs(arr[i] - arr[i - 1]);
            int topLow = topMax + Math.abs(1 - arr[i - 1]);
            int lowTop = lowMax + Math.abs(arr[i] - 1);
            int lowLow = lowMax + Math.abs(0);

            lowMax = topLow > lowLow ? topLow : lowLow;
            topMax = topTop > lowTop ? topTop : lowTop;
        }

        return lowMax > topMax ? lowMax : topMax;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            int result = cost(arr);
            System.out.println(result);
        }
        in.close();
    }
}
