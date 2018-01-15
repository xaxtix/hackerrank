package com.isamorodov.contents.wcs12;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xaxtix on 26.12.17.
 */
public class FactorialArray {


    private static final long[] factorial = new long[]{
            1L,
            1L,
            2L,
            6L,
            24L,
            120L,
            720L,
            5040L,
            40320L,
            362880L,
            3628800L,
            39916800L,
            479001600L,
            227020800L,
            178291200L,
            674368000L,
            789888000L,
            428096000L,
            705728000L,
            408832000L,
            176640000L,
            709440000L,
            607680000L,
            976640000L,
            439360000L,
            984000000L,
            584000000L,
            768000000L,
            504000000L,
            616000000L,
            480000000L,
            880000000L,
            160000000L,
            280000000L,
            520000000L,
            200000000L,
            200000000L,
            400000000L,
            200000000L,
            800000000L
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[n];
        Set<Integer> availableIndexes = new TreeSet<>();


        for (int A_i = 0; A_i < n; A_i++) {
            arr[A_i] = in.nextInt();
            if (arr[A_i] < 40) availableIndexes.add(A_i);
        }


        for (int a0 = 0; a0 < m; a0++) {
            int o = in.nextInt();
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;

            switch (o) {
                case 1:
                    Iterator<Integer> iterator = availableIndexes.iterator();
                    while (iterator.hasNext()) {
                        int i = iterator.next();
                        if (i > r) break;
                        if (i >= l) {
                            arr[i]++;
                            if (arr[i] >= 40) iterator.remove();
                        }
                    }
                    break;
                case 2:
                    iterator = availableIndexes.iterator();
                    long sum = 0;
                    while (iterator.hasNext()) {
                        int i = iterator.next();
                        if (i > r) break;
                        if (i >= l) {
                            sum += factorial[arr[i]];
                        }
                    }
                    System.out.println(sum % 1000000000);
                    break;
                case 3:
                    arr[l] = r + 1;
                    if(arr[l] >= 40){
                        availableIndexes.remove(l);
                    }else {
                        availableIndexes.add(l);
                    }
                    break;
            }
        }
    }
}
