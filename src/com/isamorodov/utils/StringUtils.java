package com.isamorodov.utils;

import java.awt.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * Created by xaxtix on 17.02.18.
 */
public class StringUtils {

    public static int[] prefixFunction(String s) {
        int n = s.length();
        int[] pi = new int[n];

        for (int i = 0; i < n; i++)
            for (int k = 0; k <= i; k++)
                if(Objects.equals(s.substring(0, k), s.substring(k,i - k + 1))) pi[i] = k;

        return pi;
    }
}
