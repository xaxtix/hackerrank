package com.isamorodov.contents.wok36;

import junit.framework.TestCase;
import org.junit.Test;

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


        board[1][0] = 'K';
        board[1][2] = 'P';
        board[1][3] = 'r';
        board[1][4] = 'P';
        board[1][5] = 'k';

        TestCase.assertEquals(2, WaysToGiveACheck.waysToGiveACheck(board));


    }
    
}
