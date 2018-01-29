package com.isamorodov.contents.hiring_contest;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by xaxtix on 27.01.2018.
 */
public class SimplestSum {

    static final int modulo = 1000000007;

    static BigInteger simplestSum(long k, long a, long b) {
        //long sum = 0;
        long i = 1;
        int step = 1;

        BigInteger sum = BigInteger.ZERO;
        boolean writing = false;
        long writingCount = 0;
        while (i <= b) {
            long repeatCount = (long) Math.pow(k, step);
            step++;
            //если рейнж больше
            if (i + repeatCount > b) {
                if (!writing) {
                    writingCount = b - a + 1;
                } else {
                    writingCount = b - i + 1;
                }
                sum = sum.add(f(k, i).multiply(BigInteger.valueOf(writingCount)));
        //               System.out.println("f=" + f(k, i) + " repeat=" + (writingCount));
                break;
            }
            //если не в ренже
            if (i + repeatCount <= a) {
                i += repeatCount;
                continue;
            }
            if (!writing) {
                writingCount = repeatCount - (a - i);
            } else {
                writingCount = repeatCount;
            }
            writing = true;
            sum = sum.add(f(k, i).multiply(BigInteger.valueOf(writingCount)));
         //      System.out.println("f=" + f(k, i) + " repeat=" + writingCount);
            i += repeatCount;
        }
        return sum;
    }

    private static long f(long k, long n, int m) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum = (sum + i) % m;
            i = i * k;
        }
        return sum;
    }

    private static BigInteger f(long k, long n) {
        BigInteger sum = BigInteger.ZERO;
        for (long i = 1; i <= n; i++) {
            sum = sum.add(BigInteger.valueOf(i));
            i = i * k;
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            long k = in.nextLong();
            long a = in.nextLong();
            long b = in.nextLong();
            BigInteger result = simplestSum(k, a, b);
            System.out.println(result.mod(BigInteger.valueOf(modulo)));
        }
        in.close();

    }

    @Test
    public void test() {
        assertEquals(simplestSum(4, 1, 5), BigInteger.valueOf(10));
         assertEquals(simplestSum(2, 1, 6), BigInteger.valueOf(18));
          assertEquals(simplestSum(2, 2, 5), BigInteger.valueOf(13));
         assertEquals(simplestSum(2, 3, 5), BigInteger.valueOf(12));
         assertEquals(simplestSum(2, 4, 5), BigInteger.valueOf(8));
    }

}