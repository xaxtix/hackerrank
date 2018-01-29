package com.isamorodov.contents.hiring_contest;

import com.isamorodov.utils.collections.MultiHashSet;

import java.util.Scanner;

/**
 * Created by xaxtix on 26.01.18.
 */
public class WinningLotteryTicket {

    static long winningLotteryTicket(String[] tickets, int n) {
        long count = 0;
        int all = n - 1;

        MultiHashSet<Integer> set = new MultiHashSet<>();

        for (int i = 0; i < n; i++) {
            char[] chars = tickets[i].toCharArray();
            int compressed = 0;
            for (char c : chars) {
                int k = c - '0';
                compressed |= (1 << k);
            }

            if (compressed == 1023) {
                count += all;
                all--;
                continue;
            }

            for (Integer c : set.getSet()) {
                if ((compressed | c) == 1023) count+= set.get(c);
            }

            set.add(compressed);
        }
        return count;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] tickets = new String[n];
        for (int tickets_i = 0; tickets_i < n; tickets_i++) {
            tickets[tickets_i] = in.next();
        }
        long result = winningLotteryTicket(tickets, n);
        System.out.println(result);
        in.close();
    }

}
