package com.isamorodov.submission.dynamic_programming;

import org.junit.Test;

import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by xaxtix on 05.02.2018.
 */
public class StockMax {

    static long stockmax(int[] prices) {
        int index = 0;
        long sum = 0;
        while (index < prices.length - 1) {
            int maxIndex = findMaxIndex(prices, index);
            if (maxIndex == index) {
                index = findNextLowValueIndex(prices,maxIndex);
                if(maxIndex == index) return sum;
            } else {
                sum += profit(prices, index, maxIndex);
                index = maxIndex + 1;
            }
        }
        return sum;
    }

    private static int findNextLowValueIndex(int[] prices, int maxIndex) {
        int value = prices[maxIndex];
        for (int i = maxIndex + 1; i < prices.length; i++) {
            if(prices[i] < value) return i;
        }
        return maxIndex;
    }

    private static long profit(int[] prices, int start, int end) {
        long sum = 0;

        for (int i = start; i < end; i++)
            sum += prices[i];
        sum = (((long) prices[end]) * (end - start)) - sum;

        return sum;
    }

    private static int findMaxIndex(int[] prices, int index) {
        int maxIndex = index;
        for (int i = index; i < prices.length; i++) {
            if (prices[i] >= prices[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] prices = new int[n];
            for (int prices_i = 0; prices_i < n; prices_i++) {
                prices[prices_i] = in.nextInt();
            }
            long result = stockmax(prices);
            System.out.println(result);
        }
        in.close();
    }

    @Test
    public void test() {
        assertEquals(0, stockmax(new int[]{5, 2, 1}));
        assertEquals(3, stockmax(new int[]{1, 3, 1, 2}));
        assertEquals(197 * 3, stockmax(new int[]{1, 2, 100, 1, 2, 100, 1, 2, 100}));
        assertEquals(197, stockmax(new int[]{101, 1, 2, 100, 100}));
    }
}
