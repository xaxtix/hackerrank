package com.isamorodov.submission.strings;

import java.util.*;

/**
 * Created by xaxtix on 29.01.18.
 */
public class TwoCharacters {

    static int twoCharaters(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars)
            set.add(c);

        List<Character> list = new ArrayList<>();
        list.addAll(set);


        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            loop: for (int j = i + 1; j < list.size(); j++) {
                char c1 = list.get(i);
                char c2 = list.get(j);
                int len = 0;
                char last = '1';
                for (char c : chars) {
                    if(c == last)
                        continue loop;
                    if (c == c1 || c == c2) {
                        len++;
                        last = c;
                    }
                }
                if (len > max) max = len;
            }
        }
        return max < 2 ? 0 : max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        int result = twoCharaters(s);
        System.out.println(result);
        in.close();
    }
}
