package com.isamorodov.submission.sorting;

import java.util.*;

/**
 * Created by xaxtix on 16.01.18.
 */
public class InsertionSortAdvancedAnalysis {


    static int insertionSort(int[] arr) {
        int count = 0;
        int[] counts = new int[10000001];

        TreeSet<Integer> set = new TreeSet<>();

        for (int i : arr) {
            Set<Integer> subset = set.tailSet(i, false);
            for (int k : subset) {
                count += counts[k];
            }

            if (counts[i] == 0) {
                set.add(i);
            }
            counts[i]++;
        }

        return count;
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
            int result = insertionSort(arr);
            System.out.println(result);
        }
        in.close();
    }
}
