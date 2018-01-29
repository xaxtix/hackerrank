package com.isamorodov.submission.sorting;

import java.util.*;

/**
 * Created by xaxtix on 15.01.2018.
 */
public class InsertionSortAdvanced {

    private static void insertionSort(List<Integer> ar) {
        List<Integer> sortedList = new LinkedList<>();
        int count = 0;
        Integer before = null;
        for(Integer i : ar){
            if(before == null || before < i){
                sortedList.add(i);
                before = i;
            }else {
                ListIterator<Integer> iterator = sortedList.listIterator();
                int l = 0;
                boolean added = false;
                while (iterator.hasNext()){
                    l++;
                    Integer k = iterator.next();
                    if(i < k) {
                        added = true;
                        iterator.previous();
                        iterator.add(i);
                        count += sortedList.size() - l;
                        break;
                    }
                }
                if(!added){
                    iterator.add(i);
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i_t = 0; i_t < t; i_t++) {
            int s = in.nextInt();
            List<Integer> ar = new LinkedList<>();
            for (int i = 0; i < s; i++) {
                ar.add(in.nextInt());
            }
            insertionSort(ar);
        }

    }
}
