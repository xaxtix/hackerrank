package com.isamorodov.contents.rookie_rank;

import java.util.Scanner;

/**
 * Created by xaxtix on 16.02.18.
 */
public class HeightOfBST {

    public static class Node {
        int value;
        int height = 0;
        Node parent;
        Node left;
        Node right;

        public Node(int value, Node parent) {
            this.parent = parent;
            this.value = value;
        }
    }

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Node tree = null;
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            if (tree == null) tree = new Node(value, null);
            add(tree, value);
        }

        System.out.println(tree.height);
        System.out.println(getTotalHeight(tree));

    }

    private static int getTotalHeight(Node tree) {
        if(tree == null) return 0;
        int sum = tree.height;
        sum += getTotalHeight(tree.left);
        sum += getTotalHeight(tree.right);
        return sum;
    }

    private static void add(Node tree, int value) {
        if (tree.value == value) return;
        if (value > tree.value) {
            if (tree.right == null) {
                tree.right = new Node(value, tree);
                updateHeight(tree.right);
            } else add(tree.right, value);
        } else {
            if (tree.left == null) {
                tree.left = new Node(value, tree);
                updateHeight(tree.left);
            } else add(tree.left, value);
        }
    }

    private static void updateHeight(Node left) {
        Node current = left.parent;
        int height = 1;
        while (current != null){
            if(current.height < height) current.height = height;
            height++;
            current = current.parent;
        }
    }

}
