package com.isamorodov.contents;

import org.junit.Test;

import static com.isamorodov.contents.WaysToGiveACheck.waysToGiveACheck;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by xaxtix on 07.02.18.
 */
public class WaysToGiveACheckTest {

    @Test
    public void testPawn() {

        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '#';
            }
        }


        board[1][3] = 'k';
        board[1][4] = 'p';
        board[1][6] = 'Q';


        assertEquals(4, waysToGiveACheck(board));


    }

    @Test
    public void testKing() {

        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '#';
            }
        }


        board[2][2] = 'K';
        board[0][0] = 'k';


        assertEquals(1, waysToGiveACheck(board));


    }

    @Test
    public void testQueen() {

        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '#';
            }
        }

        board[2][1] = 'Q';
        board[2][0] = 'P';
        board[0][0] = 'k';


        assertEquals(5, waysToGiveACheck(board));

    }

    @Test
    public void testRook() {
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '#';
            }
        }

        board[2][2] = 'R';
        board[4][4] = 'B';
        board[0][1] = 'p';
        board[0][0] = 'k';


        assertEquals(14, waysToGiveACheck(board));

    }

    @Test
    public void test() {
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '#';
            }
        }

        board[0][6] = 'R';
        board[0][1] = 'B';
        board[0][0] = 'k';


        assertEquals(7, waysToGiveACheck(board));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '#';
            }
        }

        board[0][2] = 'B';
        board[0][0] = 'k';


        assertEquals(1, waysToGiveACheck(board));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '#';
            }
        }

        board[0][6] = 'R';
        board[0][2] = 'B';
        board[1][3] = 'p';
        board[1][1] = 'p';
        board[0][0] = 'k';


        assertEquals(2, waysToGiveACheck(board));

    }
}
