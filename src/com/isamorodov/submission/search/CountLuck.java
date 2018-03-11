package com.isamorodov.submission.search;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by xaxtix on 06.03.2018.
 */
public class CountLuck {

    private static int m;
    private static int n;

    private static int LEFT = 1;
    private static int RIGHT = 2;
    private static int TOP = 3;
    private static int BOTTOM = 4;
    private static int finishY;
    private static int finishX;

    private static boolean[][] visited;

    public static class State {
        final int x, y;
        // 1 - left
        // 2 - right
        // 3 - top
        // 4 - bottom
        final int lastDirection;
        int crossCount;

        public State(int x, int y, int lastDirection) {
            this.x = x;
            this.y = y;
            this.lastDirection = lastDirection;
            visited[x][y] = true;

            crossCount = 0;
        }

        public State(int x, int y, int direction, int crossCount, char[][] map) {
            int xInc = direction == LEFT ? -1 : direction == RIGHT ? 1 : 0;
            int yInc = direction == TOP ? -1 : direction == BOTTOM ? 1 : 0;

            while (true) {
                visited[x][y] = true;
                if (checkFinish(x, y)) break;
                if (check(x + xInc, y + yInc, map)) {
                    x += xInc;
                    y += yInc;
                    if (checkCross(x, y, map)) {
                        crossCount++;
                        break;
                    }
                } else {
                    if (checkCross(x, y, map)) {
                        crossCount++;
                        break;
                    }
                    int turn = checkTurn(x, y, map);
                    if (turn > 0) {
                        direction = turn;
                        xInc = direction == LEFT ? -1 : direction == RIGHT ? 1 : 0;
                        yInc = direction == TOP ? -1 : direction == BOTTOM ? 1 : 0;
                    } else {
                        break;
                    }
                }
            }
            visited[x][y] = true;

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (x == i && y == j)
//                        System.out.print('?');
//                    else
//                        System.out.print(map[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
            this.x = x;
            this.y = y;
            lastDirection = direction;
            this.crossCount = crossCount;
        }


        public List<State> next(char[][] map) {
            List<State> nextStates = new LinkedList<>();
            if (check(x - 1, y, map)) nextStates.add(new State(x, y, LEFT, crossCount, map));
            if (check(x + 1, y, map)) nextStates.add(new State(x, y, RIGHT, crossCount, map));
            if (check(x, y - 1, map)) nextStates.add(new State(x, y, TOP, crossCount, map));
            if (check(x, y + 1, map)) nextStates.add(new State(x, y, BOTTOM, crossCount, map));

            return nextStates;
        }

        private boolean check(int x, int y, char[][] map) {
            return x >= 0 && x < n && y >= 0 && y < m &&
                    (map[x][y] == '.' || map[x][y] == '*') && !visited[x][y];
        }

        private int checkTurn(int x, int y, char[][] map) {
            if (check(x - 1, y, map)) return LEFT;
            if (check(x + 1, y, map)) return RIGHT;
            if (check(x, y - 1, map)) return TOP;
            if (check(x, y + 1, map)) return BOTTOM;
            return -1;
        }

        private boolean checkCross(int x, int y, char[][] map) {
            int count = 0;
            if (check(x - 1, y, map)) count++;
            if (check(x + 1, y, map)) count++;
            if (check(x, y - 1, map)) count++;
            if (check(x, y + 1, map)) count++;
            return count > 1;
        }

        public boolean checkFinish(int x, int y) {
            return x == finishX && y == finishY;
        }

        public boolean finish() {
            return x == finishX && y == finishY;
        }
    }

    static String countLuck(String[] matrix, int l) {
        char[][] map = new char[matrix.length][];
        visited = new boolean[n][m];
        State initialState = null;
        for (int i = 0; i < matrix.length; i++) {
            map[i] = matrix[i].toCharArray();
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'M') {
                    initialState = new State(i, j, -1);
                }
                if (map[i][j] == '*') {
                    finishX = i;
                    finishY = j;
                }
            }
        }

        if(initialState.checkCross(initialState.x,initialState.y,map))
            initialState.crossCount = 1;

        Queue<State> queue = new ArrayDeque<>();
        queue.add(initialState);
        while (!queue.isEmpty()) {
            State currentState = queue.remove();
            List<State> nextStates = currentState.next(map);
            for (State s : nextStates) {
                if (s.finish()) {
                    if (currentState.crossCount != l) return "Oops!";
                    return "Impressed";
                }
            }
            queue.addAll(nextStates);
        }

        return "Oops!";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            n = in.nextInt();
            m = in.nextInt();
            String[] matrix = new String[n];
            for (int matrix_i = 0; matrix_i < n; matrix_i++) {
                matrix[matrix_i] = in.next();
            }
            int l = in.nextInt();
            String result = countLuck(matrix, l);
            System.out.println(result);
        }
        in.close();
    }
}
