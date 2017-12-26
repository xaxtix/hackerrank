package com.isamorodov.submission.bit_manipulation;

import java.util.LinkedList;
import java.util.List;
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

   /* public final static List<Integer>[] bitSortedList = (List<Integer>[]) new List[33];

    static long maxXor = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for (int a_i = 0; a_i < a; a_i++) {
            int n = in.nextInt();

            int maxBit = 0;
            for (int i = 0; i < 33; i++) {
                bitSortedList[i] = null;
            }
            for (int i = 0; i < n; i++) {
                int value = in.nextInt();
                int tmp = value;
                int bit = 0;
                while (tmp > 0) {
                    bit++;
                    tmp >>= 1;
                }
                if (bitSortedList[bit] == null) bitSortedList[bit] = new LinkedList<>();
                bitSortedList[bit].add(value);
                if (bit > maxBit) maxBit = bit;
            }

            maxXor = 0;
            findMaxXor(maxBit, 0);
            System.out.println(maxXor * (1L << n - 1));

        }
    }

    private static void findMaxXor(int currentBit, int xor) {
        if (currentBit < 0) return;
        if ((xor >> (currentBit - 1)) % 2 == 1) findMaxXor(currentBit - 1, xor);
        List<Integer> currentBitValues = bitSortedList[currentBit];
        if (currentBitValues == null) findMaxXor(currentBit - 1, xor);
        else {
            for (int i : currentBitValues) {
                int next = i ^ xor;
                if (next > maxXor) maxXor = next;
                findMaxXor(currentBit - 1, next);
            }
        }
    }*/
}
