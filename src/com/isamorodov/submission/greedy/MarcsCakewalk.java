package com.isamorodov.submission.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xaxtix on 22.01.18.
 */
public class MarcsCakewalk {
    static long marcsCakewalk(int[] calorie) {
        Arrays.sort(calorie);
        int n = calorie.length;
        long c = 0;
        for (int i = n - 1; i >= 0; i--)
            c += calorie[i] * (1L << (n - 1 - i));

        return c;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calorie = new int[n];
        for (int calorie_i = 0; calorie_i < n; calorie_i++) {
            calorie[calorie_i] = in.nextInt();
        }
        long result = marcsCakewalk(calorie);
        System.out.println(result);
        in.close();

    }
}
