package com.isamorodov.utils;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by xaxtix on 17.02.18.
 */
public class StringUtilsTest {

    @Test
    public void testPrefixFunction() {
        int[] p = StringUtils.prefixFunction("aabaaab");
        int[] a = new int[]{0, 1, 0, 1, 2, 2, 3};
        for(int i = 0; i < p.length ; i++){
            assertEquals(p[i],a[i]);
        }
    }
}
