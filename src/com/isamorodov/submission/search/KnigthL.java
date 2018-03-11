package com.isamorodov.submission.search;


import java.util.*;

/**
 * Created by xaxtix on 05.03.2018.
 */
public class KnigthL {

    public static class State {

        final int n;
        final int step;
        final int x, y;


        boolean[][] visited;

        State(int n) {
            this.n = n;
            step = 0;
            x = 0;
            y = 0;
            visited = new boolean[n][n];
            visited[0][0] = true;
        }

        public State(State state, int xStep, int yStep) {
            n = state.n;
            x = state.x + xStep;
            y = state.y + yStep;

            visited = state.visited;

            visited[x][y] = true;
            step = state.step + 1;
        }

        public List<State> next(int i, int j) {
            List<State> nextStates = new LinkedList<>();
            if (check(i, j)) nextStates.add(new State(this, i, j));
            if (check(i, -j)) nextStates.add(new State(this, i, -j));
            if (check(-i, j)) nextStates.add(new State(this, -i, j));
            if (check(-i, -j)) nextStates.add(new State(this, -i, -j));

            if (i != j) {
                int k = i;
                i = j;
                j = k;

                if (check(i, j)) nextStates.add(new State(this, i, j));
                if (check(i, -j)) nextStates.add(new State(this, i, -j));
                if (check(-i, j)) nextStates.add(new State(this, -i, j));
                if (check(-i, -j)) nextStates.add(new State(this, -i, -j));
            }


            return nextStates;
        }

        private boolean check(int i, int j) {
            return x + i < n && x + i >= 0 &&
                    y + j < n && y + j >= 0 && !visited[x + i][y + j];
        }


        public void reset() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }
            visited[0][0] = true;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        State state = new State(n);

        Queue<State> queue = new ArrayDeque<>(n * n);
        queue.add(state);

        int[][] matrix = new int[n][n];

        for (int i = 1; i < n; i++) {
            loop:
            for (int j = i; j < n; j++) {
                if (i == 1 && j == 1) {
                    matrix[i][j] = n - 1;
                    matrix[j][i] = n - 1;
                    continue;
                }
                queue.clear();
                queue.add(state);
                state.reset();
                while (!queue.isEmpty()) {
                    State currentState = queue.remove();
                    List<State> nextStates = currentState.next(i, j);
                    for (State s : nextStates)
                        if (s.x == n - 1 && s.y == n - 1) {
                            matrix[i][j] = s.step;
                            matrix[j][i] = s.step;
                            continue loop;
                        }
                    queue.addAll(nextStates);
                }

                matrix[i][j] = -1;
                matrix[j][i] = -1;
            }
        }

        for (int i = 1; i < n; i++) {

            for (int j = 1; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
