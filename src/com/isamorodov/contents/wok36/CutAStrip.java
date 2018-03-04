package com.isamorodov.contents.wok36;

import java.util.Scanner;

/**
 * Created by xaxtix on 09.02.18.
 */
public class CutAStrip {

    static int n;
    static int m;
    static int k;
    static int[][] Atmp;
    static int[][] A;

    static boolean[] set = new boolean[144400];

    static int cutAStrip() {
        Atmp = new int[n][m];

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = A[i][j];
                sum += value;
                if (value < min) min = value;
                Atmp[i][j] = value;
            }
        }
        if (min >= 0) return sum - min;


        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] < 0) {
                    int max = findMaxAfterCut(i, j);
                    if (max > MAX) MAX = max;
                }
            }
        }


        return MAX;
    }

    private static int findMaxAfterCut(int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int i_k = 0; i_k < k; i_k++) {
            if (i + i_k < n) {
                int value = Atmp[i + i_k][j];
                Atmp[i + i_k][j] = 0;
                if (value < 0 && !set[j + i + i_k]) {
                    int maxSum = findMaxSubMatrix(Atmp);
                    if (maxSum > max) max = maxSum;
                    set[j + i + i_k] = true;
                }
            }
        }

        for (int i_k = 0; i_k < k; i_k++) if (i + i_k < n) Atmp[i + i_k][j] = A[i + i_k][j];


        for (int i_k = 0; i_k < k; i_k++) {
            if (j + i_k < m) {
                int value = Atmp[i][j + i_k];
                Atmp[i][j + i_k] = 0;
                if (value < 0 && !set[j + j + i_k]) {
                    int maxSum = findMaxSubMatrix(Atmp);
                    if (maxSum > max) max = maxSum;

                    set[j + j + i_k] = true;
                }
            }
        }

        for (int i_k = 0; i_k < k; i_k++) if (j + i_k < m) Atmp[i][j + i_k] = A[i][j + i_k];
        return max;
    }



    public static int[] kadane(int[] a) {
        int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
        int currentSum = 0;
        int localStart = 0;

        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (currentSum < 0) {
                currentSum = 0;
                localStart = i + 1;
            } else if (currentSum > result[0]) {
                result[0] = currentSum;
                result[1] = localStart;
                result[2] = i;
            }
        }

        if (result[2] == -1) {
            result[0] = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > result[0]) {
                    result[0] = a[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }

        return result;
    }


    public static int findMaxSubMatrix(int[][] a) {
        int cols = a[0].length;
        int rows = a.length;
        int[] currentResult;
        int maxSum = Integer.MIN_VALUE;

        for (int leftCol = 0; leftCol < cols; leftCol++) {
            int[] tmp = new int[rows];

            for (int rightCol = leftCol; rightCol < cols; rightCol++) {

                for (int i = 0; i < rows; i++) {
                    tmp[i] += a[i][rightCol];
                }
                currentResult = kadane(tmp);
                if (currentResult[0] > maxSum) {
                    maxSum = currentResult[0];
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        A = new int[n][m];
        for (int A_i = 0; A_i < n; A_i++) {
            for (int A_j = 0; A_j < m; A_j++) {
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = cutAStrip();
        System.out.println(result);
        in.close();
    }

}
