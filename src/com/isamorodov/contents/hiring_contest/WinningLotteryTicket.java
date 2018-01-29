package com.isamorodov.contents.hiring_contest;

import java.util.*;

/**
 * Created by xaxtix on 26.01.18.
 */
public class WinningLotteryTicket {

    static long winningLotteryTicket(String[] tickets, int n) {
        long count = 0;
        int all = n - 1;
        HashMap<Integer, Long> map = new HashMap<>();
        int[] compressedTickets = new int[n];
        int size = 0;
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
            for (int j = 0; j < size; j++) {
                if ((compressed | compressedTickets[j]) == 1023) count+= map.get(compressedTickets[j]);
            }
            if (map.containsKey(compressed)) {
                map.put(compressed, map.get(compressed) + 1L);
            } else {
                map.put(compressed, 1L);
                compressedTickets[size] = compressed;
                size++;
            }
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
