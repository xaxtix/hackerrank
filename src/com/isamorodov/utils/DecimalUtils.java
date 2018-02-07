package com.isamorodov.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xaxtix on 16.12.2017.
 */
public class DecimalUtils {

    /**
     * Раскладывает число на простые делители включая 1
     *
     * @param d
     * @return список делителей
     */
    public static List<Integer> getAllPrimaryDividers(int d) {
        List<Integer> list = new ArrayList<>();

        loop:
        while (d > 1) {
            int half = (int) Math.sqrt(d) + 1;
            for (int i = 2; i < half; i++) {
                if (d % i == 0) {
                    list.add(i);
                    d = d / i;
                    continue loop;
                }
            }
            list.add(d);
            d = 1;
        }

        return list;
    }

    /**
     * Раскладывает число на делители включая 1
     *
     * @param d
     * @return список делителей
     */
    public static List<Integer> getAllDividers(int d) {
        List<Integer> list = new ArrayList<>();

        int half = d >> 1;
        for (int i = 1; i < half; i++) {
            if (d % i == 0) list.add(i);
        }

        return list;
    }

}
