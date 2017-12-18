package com.isamorodov.submission.bit_manipulation;

import java.util.Scanner;

/**
 * Created by xaxtix on 18.12.17.
 */
public class SequenceXOR {

    private static long sequenceXor(long l, long r) {
        long tmp = 0;
        long xor = 0;
        long startIndex = r;
        while ((startIndex - 7) % 4 != 0 && startIndex > 7) startIndex--;
        if (startIndex < 7) startIndex = 0;
        else tmp = ((startIndex - 7) / 4) % 2 == 0 ? 0 : 2;
        for (long i = startIndex + 1; i <= r; i++) {
            tmp ^= i;
            if (i >= l) xor ^= tmp;
        }

        return xor;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for (int a0 = 0; a0 < Q; a0++) {
            long l = in.nextLong();
            long r = in.nextLong();
            System.out.println(sequenceXor(l, r));
        }
    }


}
