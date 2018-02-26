package com.isamorodov.submission.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xaxtix on 15.02.18.
 */
public class FraudulentActivityNotifications {

    public static class CountingArray {
        final int n;

        int midIndex;
        int mid;

        private final int[] arr;

        public CountingArray(int n) {
            this.n = n;
            arr = new int[n];
        }

        public void replace(int removedValue, int addedValue) {
            arr[removedValue]--;
            arr[addedValue]++;
            if ((removedValue > mid && addedValue > mid)
                    || (removedValue < mid && addedValue < mid)) {
                return;
            }

            if (removedValue < addedValue) {
                midIndex++;
                if (midIndex < arr[mid]) return;
                for (int i = mid + 1; i < n; i++)
                    if (arr[i] > 0) {
                        midIndex = 0;
                        mid = i;
                        return;
                    }
            } else {
                midIndex--;
                if(midIndex > 0) return;
                for (int i = mid - 1; i >= 0; i--)
                    if (arr[i] > 0) {
                        midIndex = arr[i];
                        mid = i;
                        return;
                    }
            }
        }

    }

    static int activityNotifications(int[] expenditure, int d) {
        CountingArray s = new CountingArray(200);
        int[] arr = new int[d];
        System.arraycopy(expenditure, 0, arr, 0, d);
        Arrays.sort(arr);

        for (int i = 0; i < d; i++)
            s.arr[arr[i]]++;
        s.mid = arr[d >> 1];
        s.midIndex = 0;
        for (int i = d >> 1; i >= 0; i--) {
            if (arr[i] == s.mid) s.midIndex++;
            else break;
        }


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
