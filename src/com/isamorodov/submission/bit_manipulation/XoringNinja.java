package com.isamorodov.submission.bit_manipulation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by xaxtix on 21.12.17.
 */
public class XoringNinja {

    static final int modulo = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for (int a_i = 0; a_i < a; a_i++) {
            int n = in.nextInt();

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum |= in.nextInt();
            }

            BigInteger sumB = BigInteger.valueOf(sum);
            BigInteger mulB = BigInteger.valueOf(2).pow((n - 1));


            System.out.println(sumB.multiply(mulB).mod(BigInteger.valueOf(modulo)));
        }
    }

}
