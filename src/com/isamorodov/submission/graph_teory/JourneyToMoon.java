package com.isamorodov.submission.graph_teory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xaxtix on 15.02.18.
 */
public class JourneyToMoon {



    static long journeyToMoon(int n, int[][] astronaut) {
       return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[][] astronaut = new int[p][2];
        for (int astronaut_i = 0; astronaut_i < p; astronaut_i++) {
            for (int astronaut_j = 0; astronaut_j < 2; astronaut_j++) {
                astronaut[astronaut_i][astronaut_j] = in.nextInt();
            }
        }
        long result = journeyToMoon(n, astronaut);
        System.out.println(result);
        in.close();
    }
}
