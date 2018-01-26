package com.isamorodov.submission.sorting;

import java.util.*;

/**
 * Created by xaxtix on 16.01.18.
 */
public class InsertionSortAdvancedAnalysis {
    static int insertionSort(int[] arr) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int e : arr) {
            if (e >= max) {
                max = e;
            }else {
                Iterator<Integer> iterator = map.keySet().iterator();

                while (iterator.hasNext()){
                    int k = iterator.next();
                    if(e > k){

                        //count +=
                    }
                }
            }

            map.put(e, map.getOrDefault(e, 0) + 1);
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
