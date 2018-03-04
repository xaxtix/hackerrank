package com.isamorodov.contents.wok36;

import java.util.Scanner;


public class WaysToGiveACheck {

    public static char[][] boardTmp = new char[8][8];

    public static class Point {
        final int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int waysToGiveACheck(char[][] board) {
        Point k = findEnemyKing(board);
        if (k == null) return 0;
        int sum = 0;


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (board[i][j]) {
                    case 'P':
                        sum += forPawn(k, i, j, board);
                        break;
                }
            }
        }

        return sum;
    }

    public static boolean isCheck(Point k, char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (board[i][j]) {
                    case 'P':
                        if (checkPawn(k, i, j, board))
                            return true;
                        break;
                    case 'R':
                        if (checkRook(k, i, j, board))
                            return true;
                        break;
                    case 'B':
                        if (checkBishop(k, i, j, board))
                            return true;

                        break;
                    case 'Q':
                        if (checkQueen(k, i, j, board))
                            return true;

                        break;
                    case 'N':
                        if (checkKnight(k, i, j, board))
                            return true;

                        break;
                }
            }
        }
        return false;
    }

    private static boolean checkKing(Point k, int i, int j, char[][] board) {
        return Math.abs(k.i - i) <= 1 && Math.abs(k.j - j) <= 1;
    }

    private static boolean checkKnight(Point k, int i, int j, char[][] board) {
        for (int f = 0; f < 8; f++) {
            int i_direction = f % 2 == 0 ? 1 : 2;
            int j_direction = f % 2 == 0 ? 2 : 1;
            if ((f >> 1) % 2 == 1) j_direction = -j_direction;
            if ((f >> 2) % 2 == 1) i_direction = -i_direction;

            if (k.i == i - i_direction && k.j == j - j_direction)
                return true;
        }
        return false;
    }

    private static boolean checkQueen(Point k, int i, int j, char[][] board) {
        return checkBishop(k, i, j, board) || checkRook(k, i, j, board);
    }

    private static boolean checkBishop(Point k, int i, int j, char[][] board) {
        for (int f = 0; f < 4; f++) {
            int i_direction = f % 2 == 0 ? 1 : -1;
            int j_direction = (f >> 1) % 2 == 0 ? 1 : -1;
            int iTmp = i + i_direction;
            int jTmp = j + j_direction;
            while (iTmp >= 0 && iTmp < 8 && jTmp >= 0 && jTmp < 8) {
                if (k.i == iTmp && k.j == jTmp) {
                    return true;
                }
                if (board[iTmp][jTmp] != '#') break;
                iTmp += i_direction;
                jTmp += j_direction;
            }
        }
        return false;
    }

    private static boolean checkRook(Point k, int i, int j, char[][] board) {
        if (k.i == i) {
            int direction = k.j > j ? 1 : -1;
            j += direction;
            while (j >= 0 && j < 8) {
                if (k.j == j) return true;
                if (board[i][j] != '#') break;
                j += direction;
            }
        } else if (k.j == j) {
            int direction = k.i > i ? 1 : -1;
            i += direction;
            while (i >= 0 && i < 8) {
                if (k.i == i) return true;
                if (board[i][j] != '#') break;
                i += direction;
            }
        }
        return false;

    }

    private static boolean checkPawn(Point k, int i, int j, char[][] board) {
        return k.i == i - 1 && k.j == j - 1 || k.i == i - 1 && k.j == j + 1;
    }


    private static Point findEnemyKing(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'k') return new Point(i, j);
            }
        }
        return null;
    }

    private static int forPawn(Point k, int i, int j, char[][] board) {
        int sum = 0;
        copyBoard(board, boardTmp);
        boardTmp[i][j] = '#';
        if (i == 1) {
            if (board[i - 1][j] == '#') {
                sum += transformPawn(k, 0, j, boardTmp);
                copyBoard(board, boardTmp);
                boardTmp[i][j] = '#';
            }
            if (j - 1 >= 0 && Character.isLowerCase(board[i - 1][j - 1])) {
                sum += transformPawn(k, 0, j - 1, boardTmp);
                copyBoard(board, boardTmp);
                boardTmp[i][j] = '#';
            }

            if (j + 1 < 8 && Character.isLowerCase(board[i - 1][j + 1])) {
                sum += transformPawn(k, 0, j + 1, boardTmp);
                copyBoard(board, boardTmp);
                boardTmp[i][j] = '#';
            }
        }

        return sum;
    }

    private static int transformPawn(Point k, int i, int j, char[][] boardTmp) {
        int sum = 0;
        boardTmp[i][j] = 'Q';
        sum += isCheck(k, boardTmp) ? 1 : 0;
        boardTmp[i][j] = 'R';
        sum += isCheck(k, boardTmp) ? 1 : 0;
        boardTmp[i][j] = 'B';
        sum += isCheck(k, boardTmp) ? 1 : 0;
        boardTmp[i][j] = 'N';
        sum += isCheck(k, boardTmp) ? 1 : 0;
        return sum;
    }


    private static void copyBoard(char[][] board, char[][] boardTmp) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardTmp[i][j] = board[i][j];
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            char[][] board = new char[8][8];
            for (int board_i = 0; board_i < 8; board_i++) {
                String line = in.next();
                for (int board_j = 0; board_j < 8; board_j++) {
                    board[board_i][board_j] = line.charAt(7 - board_j);
                }
            }
            int result = waysToGiveACheck(board);
            System.out.println(result);
        }
        in.close();
    }



    public static void print(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


}
