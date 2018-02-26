package com.isamorodov.contents;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xaxtix on 17.02.2018.
 */
public class DNAValue {

    //-1 - no 1 - yes;
    static int[] palindromes;

    static int[] DNAValue(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] arr = new int[n];

        palindromes = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = find(chars, i, n);
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
            if(isPalindrome(chars,k)) max = k;
        }
    }

    private static boolean isPalindrome(char[] chars,int k) {
        if(palindromes[k] == 1) return true;
        if(palindromes[k] == -1) return false;
        int kHalf = k >> 1;
        for(int i = 0; i < kHalf; i++){
            if(chars[i] != chars[k - 1 - i]) {
                palindromes[k] = -1;
                return false;
            }
        }
        palindromes[k] = 1;
        return true;
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
