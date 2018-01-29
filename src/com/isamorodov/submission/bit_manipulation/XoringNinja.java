package com.isamorodov.submission.bit_manipulation;

import java.util.Scanner;

/**
 * Created by xaxtix on 21.12.17.
 */
public class XoringNinja {

    public static class XorableSet {
        final int n;
        final boolean[] b;
        final int[] arr;
        long sum = 0;

        public XorableSet(int n,int[] arr) {
            this.n = n;
            this.arr = arr;
            b = new boolean[n];
        }

        public void inc(){
            int i = 0;
            while (b[i]){
                b[i] = false;
                sum ^= arr[i];
                i++;
            }
            b[i] = true;
            sum ^= arr[i];

            for(boolean f : b) System.out.print(f ? 1 : 0);

            System.out.print(" " + sum);
            System.out.println();
        }


    }

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
            XorableSet set = new XorableSet(n,arr);

            for (long i = 1; i < len; i++) {
                set.inc();
                sum += set.sum;
            }

            System.out.println(sum);
        }
    }

}
