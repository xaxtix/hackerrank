package com.isamorodov.submission.graph;

import org.junit.Test;

import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by xaxtix on 01.02.2018.
 */
public class EvenTree {

    static int maxSum = 0;

    static int evenTree(int n, int root, boolean[][] tree) {
        boolean[] tmp;
        int currentNode = root;


        for (int i = 0; i < n; i++) {
            if (i == root) continue;
            if (tree[currentNode][i]) {
                tmp = new boolean[n];
                tmp[currentNode] = true;
                int count = countNodes(i, tree, tmp);
                if (count % 2 == 0)
                    maxSum++;

                tree[currentNode][i] = false;
                tree[i][currentNode] = false;
                evenTree(n, i, tree);

            }
        }
        return maxSum;
    }

    private static int countNodes(int root, boolean[][] tree, boolean[] tmp) {
        int len = tree.length;
        tmp[root] = true;

        int sum = 1;
        for (int i = 0; i < len; i++) {
            if (tree[root][i] && !tmp[i]) {
                sum += countNodes(i, tree, tmp);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[][] tree = new boolean[n][n];
        for (int tree_i = 0; tree_i < m; tree_i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            tree[x][y] = true;
            tree[y][x] = true;
        }
        int result = evenTree(n, 0, tree);
        System.out.println(result);
        in.close();
    }

    @Test
    public void test() {
        int n = 6;
        boolean[][] tree = new boolean[n][n];
        tree[0][1] = true;
        tree[1][0] = true;

        tree[2][1] = true;
        tree[1][2] = true;

        tree[1][3] = true;
        tree[3][1] = true;

        tree[2][4] = true;
        tree[4][2] = true;

        tree[3][5] = true;
        tree[5][3] = true;

        assertEquals(evenTree(n, 0, tree), 2);

    }

}
