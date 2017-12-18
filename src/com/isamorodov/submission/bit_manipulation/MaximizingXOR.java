package com.isamorodov.submission.bit_manipulation;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * Created by xaxtix on 18.12.17.
 */
public class MaximizingXOR {

    static int maxXor(int l, int r) {
        int max = 0;
        for(int i = l; i <= r; i++){
            for(int j = i; j <= r; j++) {
                int xor = i ^ j;
                if (xor > max) max = xor;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);

    }
}
