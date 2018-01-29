package com.isamorodov.contents.hiring_contest;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by xaxtix on 26.01.2018.
 */
public class ArrayAndQueries{

    private static final long mod = 1000000007;
    static final BigInteger bM = new BigInteger("1000000007");


    static class BeautifulSet {
        int startValue;
        int endValue;
        int size;

        BeautifulSet(int a) {
            startValue = endValue = a;
            size = 1;
        }

        BeautifulSet(int startValue, int i) {
            this.startValue = startValue;
            this.endValue = i;
            size = endValue - startValue + 1;
        }

        boolean add(int value) {
            if (value == startValue - 1) {
                startValue--;
                size++;
                return true;
            }

            if (value == endValue + 1) {
                endValue++;
                size++;
                return true;
            }

            return false;
        }

        boolean removeFromBorder(int value) {
            if (endValue == value) {
                endValue--;
                size--;
                return true;
            }

            if (startValue == value) {
                startValue++;
                size--;
                return true;
            }
            return false;
        }

        boolean contains(int value) {
            return value >= startValue && value <= endValue;
        }

        BeautifulSet[] split(int removedValue) {
            BeautifulSet[] rez = new BeautifulSet[2];
            rez[0] = new BeautifulSet(startValue,removedValue- 1);
            rez[1] = new BeautifulSet(removedValue + 1,endValue);
            return rez;
        }

        public boolean canAddToStart(int value){
            return value == startValue - 1;
        }

        public boolean canAddToEnd(int value){
            return value == endValue + 1;
        }
    }

    static BigInteger arrayAndQueries(int[] A, int[][] queries) {
        List<BeautifulSet> sets = createSets(A);
        BigInteger sum = BigInteger.ZERO;
        long m = 1;

        for (int[] q : queries) {
            int index = q[0] - 1;
            int removedValue = A[index];
            int addedValue = q[1];
            if(removedValue == addedValue) {
                sum = sum.add(BigInteger.valueOf(m  * sets.size()));
                m++;
                continue;
            }

            A[index] = addedValue;

            Iterator<BeautifulSet> iterator = sets.iterator();
            BeautifulSet containsSet = null;
            boolean removed = false;
            BeautifulSet addToEnd = null;
            BeautifulSet addToStart = null;
            while (iterator.hasNext()) {
                BeautifulSet set = iterator.next();
                if (set.removeFromBorder(removedValue)) {
                    removed = true;
                    if(set.size == 0)
                        iterator.remove();
                    break;
                }
                if (set.contains(removedValue)) containsSet = set;
            }

            if(!removed){
                sets.remove(containsSet);
                BeautifulSet[] rez = containsSet.split(removedValue);
                sets.add(rez[0]);
                sets.add(rez[1]);
            }

            for(BeautifulSet set : sets){
                if(set.canAddToEnd(addedValue)) addToEnd = set;
                if(set.canAddToStart(addedValue)) addToStart = set;
            }

            if(addToEnd == null && addToStart == null){
                sets.add(new BeautifulSet(addedValue));
            }
            if(addToEnd == null && addToStart != null){
                addToStart.add(addedValue);
            }
            if (addToEnd != null && addToStart == null){
                addToEnd.add(addedValue);
            }

            if (addToEnd != null && addToStart != null){
                sets.remove(addToEnd);
                sets.remove(addToStart);
                sets.add(new BeautifulSet(addToEnd.startValue,addToStart.endValue));
            }
            sum = sum.add(BigInteger.valueOf(m  * sets.size()));
            m++;



        }

        return sum;
    }

    private static List<BeautifulSet> createSets(int[] A) {
        int arr[] = Arrays.copyOf(A,A.length);
        Arrays.sort(arr);
        List<BeautifulSet> sets = new LinkedList<>();

        for (int a : arr) {
            boolean added = false;
            for (BeautifulSet set : sets) {
                if (set.add(a)) {
                    added = true;
                    break;
                }
            }
            if (!added) {
                sets.add(new BeautifulSet(a));
            }
        }
        return sets;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for (int A_i = 0; A_i < n; A_i++) {
            A[A_i] = in.nextInt();
        }
        int q = in.nextInt();
        int[][] queries = new int[q][2];
        for (int queries_i = 0; queries_i < q; queries_i++) {
            for (int queries_j = 0; queries_j < 2; queries_j++) {
                queries[queries_i][queries_j] = in.nextInt();
            }
        }
        BigInteger result = arrayAndQueries(A, queries);
        System.out.print(result.mod(bM));
        in.close();
    }



}
