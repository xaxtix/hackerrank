package com.isamorodov.dynamic_programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by xaxtix on 29.12.17.
 * help:
 * http://www.ideserve.co.in/learn/coin-change-problem-number-of-ways-to-make-change
 *
 */
public class CoinChangeProblem {


    static long getWays(int n, int[] c) {
        int len = c.length;

        Map<Integer, Long> map = new HashMap<>();

        map.put(n, 1L);
        for (int i = 0; i < len; i++) {
            int currentCoin = c[i];
            Map<Integer, Long> nextMap = new HashMap<>();
            for (int num : map.keySet()) {
                int tmp = num;
                long variants = map.getOrDefault(tmp, 0L);
                while (tmp >= 0) {
                    nextMap.put(tmp, variants + nextMap.getOrDefault(tmp, 0L));
                    tmp -= currentCoin;
                }
            }
            map = nextMap;

        }
        return map.getOrDefault(0, 0L);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];

        for (int c_i = 0; c_i < m; c_i++) {
            c[c_i] = in.nextInt();
        }

        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
