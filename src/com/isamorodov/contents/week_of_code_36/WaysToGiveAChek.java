package com.isamorodov.contents.week_of_code_36;

import java.util.Scanner;

/**
 * Created by xaxtix on 07.02.2018.
 */
public class WaysToGiveAChek {

    static int waysToGiveACheck(char[][] board) {
        int iK = 0;
        int jK = 0;

        int sum = 0;
        loop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 'k') {
                    iK = i;
                    jK = j;
                    break loop;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 'P') {
        //            sum += checkPawn(iK,jK,i,j,board);
                }
            }
        }

        return sum;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            char[][] board = new char[8][8];
            for (int board_i = 0; board_i < 8; board_i++) {
                for (int board_j = 0; board_j < 8; board_j++) {
                    board[board_i][board_j] = in.next().charAt(0);
                }
            }
            int result = waysToGiveACheck(board);
            System.out.println(result);
        }
        in.close();
    }

}
