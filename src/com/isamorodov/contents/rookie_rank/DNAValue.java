package com.isamorodov.contents.rookie_rank;


import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xaxtix on 16.02.18.
 */
public class DNAValue {

    static int[] DNAValue(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] arr = new int[n];
        int nHalf = n >> 1;

        char firstSymbol = chars[0];

        for (int i = 0; i < nHalf; i++) {
            if(chars[i] == firstSymbol){

            }
        }
        return arr;
    }

    private static int find(char[] chars, int i, int n) {
        int k = 0;
        int max = 0;
        while (true) {
            if (i - k < 0) return max;
            if (i + k > n - 1) return max;
            if (chars[i + k] != chars[k] ||
                    chars[i - k] != chars[k]) return max;

            k++;
            //if(isPalindrome(chars,k)) max = k;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int[] result = DNAValue(s);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
