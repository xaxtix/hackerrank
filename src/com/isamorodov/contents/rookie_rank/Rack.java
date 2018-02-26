package com.isamorodov.contents.rookie_rank;

import java.util.Scanner;

/**
 * Created by xaxtix on 16.02.18.
 */
public class Rack {

    static String checkAll(int n, int[] height, int[] position) {
        boolean left = true;

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            if(height[i] + position[i] > max) max = height[i] + position[i];
            if (max >= position[i + 1]) continue;
            left = false;
            break;
        }

        boolean right = true;
        int min = position[n - 1] - height[n - 1];
        for (int i = n - 1; i > 0; i--) {
            if(position[i] - height[i] < min) min = position[i] - height[i];
            if (min <= position[i - 1]) continue;
            right = false;
            break;

        }

        if (left && right) return "BOTH";
        if (left) return "LEFT";
        if (right) return "RIGHT";
        return "NONE";
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] position = new int[n];
        for (int position_i = 0; position_i < n; position_i++) {
            position[position_i] = in.nextInt();
        }
        int[] height = new int[n];
        for (int height_i = 0; height_i < n; height_i++) {
            height[height_i] = in.nextInt();
        }
        String ret = checkAll(n, height, position);
        System.out.println(ret);
        in.close();
    }
}
