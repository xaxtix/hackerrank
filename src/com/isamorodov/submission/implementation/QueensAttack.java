package com.isamorodov.submission.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xaxtix on 25.01.18.
 */
public class QueensAttack {
    static int queensAttack(int n, int k, int r_q, int c_q, List<int[]> obstacles) {

        int rez = 0;

        //top
        int rTmp = r_q - 1;
        int cTmp = c_q;
        while (rTmp > 0) {
            if (check(rTmp, cTmp, obstacles)) break;
            rez++;
            rTmp--;
        }

        //bottom
        rTmp = r_q + 1;

        while (rTmp <= n) {
            if (check(rTmp, cTmp, obstacles)) break;
            rez++;
            rTmp++;
        }

        rTmp = r_q;
        cTmp = c_q - 1;
        while (cTmp > 0) {
            if (check(rTmp, cTmp, obstacles)) break;
            rez++;
            cTmp--;
        }

        cTmp = c_q + 1;
        while (cTmp <= n) {
            if (check(rTmp, cTmp, obstacles)) break;
            rez++;
            cTmp++;
        }

        rTmp = r_q - 1;
        cTmp = c_q - 1;
        while (cTmp > 0 && rTmp > 0) {
            if (check(rTmp, cTmp, obstacles)) break;
            rez++;
            cTmp--;
            rTmp--;
        }

        rTmp = r_q + 1;
        cTmp = c_q - 1;
        while (cTmp > 0 && rTmp <= n) {
            if (check(rTmp, cTmp, obstacles)) break;
            rez++;
            cTmp--;
            rTmp++;
        }


        rTmp = r_q - 1;
        cTmp = c_q + 1;
        while (cTmp <= n && rTmp > 0) {
            if (check(rTmp, cTmp, obstacles)) break;
            rez++;
            cTmp++;
            rTmp--;
        }

        rTmp = r_q + 1;
        cTmp = c_q + 1;
        while (cTmp <= n && rTmp <= n) {
            if (check(rTmp, cTmp, obstacles)) break;
            rez++;
            cTmp++;
            rTmp++;
        }

        return rez;
    }

    private static boolean check(int rTmp, int cTmp, List<int[]> obstacles) {
        for (int[] o : obstacles) {
            if (rTmp == o[0] && cTmp == o[1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        List<int[]> obstacles = new ArrayList<>();
        ;
        for (int obstacles_i = 0; obstacles_i < k; obstacles_i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (checkAttack(r_q, c_q, x, y)) obstacles.add(new int[]{x, y});
        }
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }

    private static boolean checkAttack(int r_q, int c_q, int x, int y) {
       if(x == r_q) return  true;
       if(y == c_q) return true;
       if(x - y == r_q - c_q) return true;
       if(x + y == r_q + c_q) return true;
       return false;
    }
}
