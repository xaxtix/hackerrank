package com.isamorodov.submission.bit_manipulation;

import java.util.Scanner;

/**
 * Created by xaxtix on 18.12.17.
 */
public class CounterGame {

    private static void printWinner(long i) {
        boolean b = true;

        while (i > 1) {
            long tmp = i;
            long xor = 1;
            int bitCount = 0;
            while (tmp != 0) {
                if (tmp % 2 == 1) bitCount++;
                tmp >>= 1;
                xor <<= 1;
            }
            xor >>= 1;
            if(bitCount == 1){
                xor >>= 1;
                i -= xor;
            }else {
                i ^= xor;
            }
            b = !b;

        }
        System.out.println(b ? "Richard" : "Louise");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testSize = in.nextInt();
        for (int i = 0; i < testSize; i++) {
            printWinner(in.nextLong());
        }
    }


}
