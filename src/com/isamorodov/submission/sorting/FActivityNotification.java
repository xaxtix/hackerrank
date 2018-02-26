package com.isamorodov.submission.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by xaxtix on 14.02.2018.
 */
public class FActivityNotification {

    public static class SortedArray {
        final int n;
        final int midIndex;
        int mid;

        final int[] arr;
        

        public SortedArray(int n) {
            this.n = n;
            midIndex = n >> 1;
            arr = new int[n];
        }

        public void replace(int removedValue, int addedValue) {
            int removedIndex = binarySearch(arr, removedValue);
            if (addedValue > removedIndex) {
                for (int i = removedIndex; i < n - 1; i++) {
                    if (arr[i + 1] > addedValue) {
                        arr[i] = addedValue;
                        break;
                    } else arr[i] = arr[i + 1];
                }
            } else {
                for (int i = removedIndex; i >= 0; i--) {
                    if (arr[i - 1] < addedValue) {
                        arr[i] = addedValue;
                        break;
                    } else arr[i] = arr[i - 1];
                }
            }

            mid = arr[midIndex];
        }

    }

    public static int binarySearch(int[] arr, int value) {
        int n = arr.length;
        int mid;

        int left = 0;
        int right = n - 1;
        while (true) {
            mid = (left + right) >> 1;
            if (arr[mid] == value) return mid;
            if (arr[mid] > value) right = mid - 1;
            else left = mid + 1;
        }
    }

    static int activityNotifications(int[] expenditure, int d) {
        SortedArray s = new SortedArray(d);
        System.arraycopy(expenditure, 0, s.arr, 0, d);
        Arrays.sort(s.arr);

        s.mid = s.arr[d >> 1];

        int notifications = 0;
        int n = expenditure.length;
        for (int i = d; i < n - 1; i++) {
            if (expenditure[i] >= s.mid * 2) notifications++;

            int removedValue = expenditure[i - d];
            int addedValue = expenditure[i];

            s.replace(removedValue, addedValue);
        }

        return notifications;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for (int expenditure_i = 0; expenditure_i < n; expenditure_i++) {
            expenditure[expenditure_i] = in.nextInt();
        }
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        in.close();
    }
}
