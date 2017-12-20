package com.isamorodov.submission.bit_manipulation;

import java.util.*;

/**
 * Created by xaxtix on 19.12.17.
 */
public class AnotherMinimaxProblem {

    public final static List<Integer>[] bitSortedList = (List<Integer>[]) new List[33];


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        int maxBit = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int min = Integer.MAX_VALUE;
        while (min == Integer.MAX_VALUE) {
            for (int i = 0; i < n; i++) {
                int tmp = arr[i];
                int bit = 0;
                while (tmp > 0) {
                    bit++;
                    tmp >>= 1;
                }
                if (bitSortedList[bit] == null) bitSortedList[bit] = new LinkedList<>();
                bitSortedList[bit].add(arr[i]);
                if (bit > maxBit) maxBit = bit;
            }


            for (int currentBit = maxBit - 1; currentBit >= 0; currentBit--) {
                if (bitSortedList[currentBit] == null) continue;
                for (int i : bitSortedList[maxBit]) {
                    for (int k : bitSortedList[currentBit]) {
                        int tmp = k ^ i;
                        if (tmp < min) {
                            min = tmp;
                        }
                    }
                }
            }

            if (min != Integer.MAX_VALUE) {
                System.out.println(min);
                return;
            }

            if(maxBit == 0){
                System.out.println(0);
                return;
            }

            int reduceValue = (int) Math.pow(2, maxBit - 1);
            for (int i = 0; i < n; i++) {
                arr[i] -= reduceValue;
            }
            maxBit = 0;
        }
    }

}
