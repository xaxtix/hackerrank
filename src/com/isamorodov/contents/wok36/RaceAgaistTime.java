package com.isamorodov.contents.wok36;

import java.util.*;

/**
 * Created by xaxtix on 08.02.18.
 */
public class RaceAgaistTime {

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

        List<State> states = new ArrayList<>(n);
        states.add(state);

        int curHeight = mason_height;
        int studentHeight;
        int price;
        long sumWithStudentHeight;

        int n_s = states.size();

        for (int i = 0; i < n - 1; i++) {
            studentHeight = heights[i];
            price = prices[i];
            sumWithStudentHeight = Long.MAX_VALUE;

            for (int j = 0; j < n_s; j++) {
                State s = states.get(j);

                long profit = Math.abs(studentHeight - s.height) + price;
                long sumTmp = profit + s.sum;

                if (s.height < studentHeight) {
                    states.remove(j);
                    j--;
                    n_s--;

                    if (sumTmp < sumWithStudentHeight) sumWithStudentHeight = sumTmp;
                    continue;
                }

                if (price < 2 && sumTmp < sumWithStudentHeight)
                    sumWithStudentHeight = sumTmp;

            }

            if (sumWithStudentHeight != Long.MAX_VALUE) {
                states.add(new State(sumWithStudentHeight, studentHeight));
                n_s++;
            }

            if(n_s >= 40){
                states.sort(Comparator.comparingLong(o -> o.sum));
                states = states.subList(0,20);
                n_s = 20;
            }

            if (studentHeight > curHeight) {
                curHeight = studentHeight;
                State minState = getMinState(states, n_s);
                states.clear();
                states.add(minState);
                n_s = 1;
            }
        }

        State minState = getMinState(states, n_s);
        return minState.sum + n;
    }

    private static State getMinState(List<State> states, int n_s) {
        State minState = states.get(0);
        for (int j = 1; j < n_s; j++) {
            State s = states.get(j);
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
