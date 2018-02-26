package com.isamorodov.utils;

/**
 * Created by xaxtix on 15.02.2018.
 */
public class ArrayUtils {

    public static int binarySearch(int[] arr,int value){
        int n = arr.length;
        int mid;

        int left = 0;
        int right = n - 1;
        while (true){
            mid = (left + right) >> 1;
            if(arr[mid] == value) return mid;
            if(arr[mid] > value) right = mid - 1;
            else left = mid + 1;
        }
    }
}
