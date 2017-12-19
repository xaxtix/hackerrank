package com.isamorodov.submission.bit_manipulation;

import java.util.Scanner;

/**
 * Created by xaxtix on 18.12.17.
 */
public class SequenceXOR {

    private static long sequenceXor(long l, long r) {
        long tmp = 0;
        long xor = 0;
        long lastIndex = r;
        while ((lastIndex - 7) % 4 != 0 && lastIndex > 7) lastIndex--;

        long firstIndex = l;
        while ((firstIndex - 7) % 4 != 0 && firstIndex > 7) firstIndex--;

        if (lastIndex < 7) lastIndex = 0;
        if (firstIndex < 7) firstIndex = 0;
        if (lastIndex == 0 || firstIndex == 0) {
            for (long i = 0; i <= r; i++) {
                tmp ^= i;
                if (i >= l) xor ^= tmp;
            }
        } else {

            firstIndex++;
            for (long i = 1; i < 4; i++) {
                tmp ^= firstIndex;
                if (firstIndex >= l && firstIndex <= r) xor ^= tmp;
                firstIndex++;
            }


            tmp = 0;
            lastIndex++;
            for (long i = 1; i < 4; i++) {
                tmp ^= lastIndex;
                if (lastIndex > firstIndex && lastIndex <= r) xor ^= tmp;
                lastIndex++;
            }
            if(lastIndex - firstIndex - 4 <= 0) return xor;
            if (((lastIndex - firstIndex - 4) / 4)% 2 != 0) xor ^= 2;
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
