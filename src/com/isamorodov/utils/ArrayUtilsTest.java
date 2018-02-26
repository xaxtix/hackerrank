package com.isamorodov.utils;

import org.junit.Test;

import static com.isamorodov.utils.ArrayUtils.binarySearch;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by xaxtix on 15.02.2018.
 */
public class ArrayUtilsTest {

    @Test
    public void binarySearchTest() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};

        for (int i = 0; i < 7; i++)
            assertEquals(i, binarySearch(arr, i));
    }
}
