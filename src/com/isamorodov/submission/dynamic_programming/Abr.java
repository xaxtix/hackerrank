package com.isamorodov.submission.dynamic_programming;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xaxtix on 03.01.18.
 */
public class Abr {

    static class State {
        int index;

        public State(int index) {
            this.index = index;
        }
    }

    static String abbreviation(String a, String b) {
        char[] str = a.toCharArray();
        char[] abr = b.toCharArray();
        int lastIndex = abr.length;

        List<State> pointers = new LinkedList<>();
        pointers.add(new State(0));
        for (char c : str) {
            List<State> newStates = new LinkedList<>();
            for (State i : pointers) {
                if(Character.isUpperCase(c) && i.index == lastIndex){
                    pointers.remove(i);
                }
                if (Character.toUpperCase(c) == abr[i.index]) {
                    if (!Character.isUpperCase(c)) newStates.add(new State(i.index));
                    i.index++;
                }
            }
            pointers.addAll(newStates);
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String a = in.next();
            String b = in.next();
            String result = abbreviation(a, b);
            System.out.println(result);
        }
        in.close();
    }

}
