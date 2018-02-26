package com.isamorodov.contents.week_of_code_36;

import java.util.Scanner;

/**
 * Created by xaxtix on 13.02.2018.
 */
public class AraceAgainsTime {

    public static class State {
        long sum;
        int height;

        public State(long sum, int height) {
            this.sum = sum;
            this.height = height;
        }
    }

    static long raceAgainstTime(int n, int mason_height, int[] heights, int[] prices) {

        State state = new State(0, mason_height);

        State[] states = new State[10];
        states[0] = state;

        int curHeight = mason_height;
        int studentHeight;
        int price;
        long sumWithStudentHeight;

        int n_s = 1;

        for (int i = 0; i < n - 1; i++) {
            studentHeight = heights[i];
            price = prices[i];
            sumWithStudentHeight = Long.MAX_VALUE;

            for (int j = 0; j < n_s; j++) {
                State s = states[j];

                long profit = Math.abs(studentHeight - s.height) + price;
                long sumTmp = profit + s.sum;

                if (s.height < studentHeight) {
                    states[j] = states[n_s - 1];
                    j--;
                    n_s--;

                    if (sumTmp < sumWithStudentHeight) sumWithStudentHeight = sumTmp;
                    continue;
                }

                if (price < 2 && sumTmp < sumWithStudentHeight)
                    sumWithStudentHeight = sumTmp;

            }

            if (sumWithStudentHeight != Long.MAX_VALUE) {
                if(n_s == 9){
                    int minIndex = 0;
                    State minState = states[0];
                    for (int j = 1; j < n_s; j++) {
                        State s = states[j];
                        if (s.sum < minState.sum) {
                            minState = s;
                            minIndex = j;
                        }
                    }

                    states[minIndex] = new State(sumWithStudentHeight, studentHeight);
                }else{
                    states[n_s] = new State(sumWithStudentHeight, studentHeight);
                    n_s++;
                }
            }



            if (studentHeight > curHeight) {
                curHeight = studentHeight;
                State minState = getMinState(states, n_s);

                states[0] = minState;
                n_s = 1;
            }
        }

        State minState = getMinState(states, n_s);
        return minState.sum + n;
    }

    private static State getMinState(State[] states, int n_s) {
        State minState = states[0];
        for (int j = 1; j < n_s; j++) {
            State s = states[j];
            if (s.sum < minState.sum) minState = s;
        }
        return minState;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int mason_height = in.nextInt();
        int[] heights = new int[n - 1];
        for (int heights_i = 0; heights_i < n - 1; heights_i++) {
            heights[heights_i] = in.nextInt();
        }
        int[] prices = new int[n - 1];
        for (int prices_i = 0; prices_i < n - 1; prices_i++) {
            prices[prices_i] = in.nextInt();
        }
        long result = raceAgainstTime(n, mason_height, heights, prices);
        System.out.println(result);
    }
}
