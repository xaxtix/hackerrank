package com.isamorodov;

public class Main {

    public static void main(String[] args) {




        int index = 100;

        while (index > 0)
        {
            System.out.println(printAsBinary(index) + " " + index);
            index = index - (index & (-index));
        }



    }

    public static String printAsBinary(int i) {
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < 32; j++) {
            s.append(Math.abs(i % 2));
            i = i >> 1;
        }
        s.reverse();
        return s.toString();
    }
}
