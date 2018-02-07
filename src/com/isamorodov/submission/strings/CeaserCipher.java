package com.isamorodov.submission.strings;

import java.util.Scanner;

/**
 * Created by xaxtix on 31.01.18.
 */
public class CeaserCipher {
    static void caesarCipher(String s, int k) {
        char[] chars = s.toCharArray();
        k %= 'z' - 'a' + 1;
        for(char c : chars){
            char r= c;
            if(c >= 'a' && c <= 'z'){
                r +=  k;
                if(r > 'z') r = (char)('a' + r -'z' - 1);
            }

            if(c >= 'A' && c <= 'Z'){
                r +=  k;
                if(r > 'Z') r = (char)('A' + r -'Z' - 1);
            }

            System.out.print(r);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        caesarCipher(s, k);

        in.close();
    }
}
