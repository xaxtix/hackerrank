package com.isamorodov.submission.bit_manipulation;

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

            for(int i = n; i > 0; i--){
                for (int j = 0; j < i; j++) {
                    //arr

                }
            }
        }
    }

}
