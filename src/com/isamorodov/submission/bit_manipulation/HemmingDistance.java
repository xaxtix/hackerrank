package com.isamorodov.submission.bit_manipulation;

import java.util.*;

/**
 * Created by xaxtix on 09.03.2018.
 */
public class HemmingDistance {

    public static int rev(int x) {
        x = (x & 0xaaaaaaaa) >>> 1 | (x & 0x55555555) << 1;
        x = (x & 0xcccccccc) >>> 2 | (x & 0x33333333) << 2;
        x = (x & 0xf0f0f0f0) >>> 4 | (x & 0x0f0f0f0f) << 4;
        x = (x & 0xff00ff00) >>> 8 | (x & 0x00ff00ff) << 8;
        return x >>> 16 | x << 16;
    }

    public static int bitCount(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    public static class BitSet {

        final int n;
        final int intSize;
        final int[] bits;

        public BitSet(int n) {
            this.n = n;
            bits = new int[intSize = ((n >> 5) + 1)];
        }

        public void flip(int x) {
            bits[x >> 5] ^= 1 << (x & 31);
        }

        public int get(int x) {
            return bits[x >> 5] >> (x & 31) & 1;
        }

        public void set(int x, int value) {
            if (get(x) != value) flip(x);
        }

        public void fill(int start, int end, int value) {
            for (int i = start; i <= end; ) {
                if ((i & 31) != 0 || i + 32 >= end) {
                    set(i, value);
                    i++;
                } else {
                    bits[i >> 5] = value == 1 ? -1 : 0;
                    i += 32;
                }
            }
        }

        private void word(int i, int w) {
            int j = i >> 5;
            bits[j] |= w << (i & 31);
            i += 31;
            j = i >> 5;
            if (j < intSize)
                bits[j] |= w >>> 31 - (i & 31);
        }

        public void reverse(int start, int end, BitSet tmp) {
            tmp.copy(this);
            fill(start, end, 0);
            for (int i = start; i <= end; )
                if ((i & 31) != 0 || i + 32 >= end) {
                    set(end - (i - start), tmp.get(i));
                    i++;
                } else {
                    word(end - 31 - (i - start), rev(tmp.bits[i >> 5]));
                    i += 32;
                }
        }


        public void print(int start, int end) {
            StringBuilder sb = new StringBuilder();
            for (int i = start; i <= end; i++) {
                sb.append((char) ('a' + get(i)));
            }
            System.out.println(sb.toString());
        }

        public void swap(int l1, int r1, int l2, int r2, BitSet tmp) {
            tmp.copy(this);

            fill(l1, r2, 0);
            //mid
            copy(tmp, r1 + 1, l2 - 1, l1 + (r2 - l2) + 1);
            copy(tmp, l1, r1, l1 + (r2 - l2) + (l2 - r1));
            copy(tmp, l2, r2, l1);
        }

        public void xor(BitSet bitSet) {
            for (int i = 0; i < intSize; i++) {
                bits[i] ^= bitSet.bits[i];
            }
        }

        public void copy(BitSet bits) {
            System.arraycopy(bits.bits, 0, this.bits, 0, intSize);
        }

        public void copy(BitSet bits, int start, int end) {
            for (int i = start; i <= end; ) {
                if ((i & 31) != 0 || i + 32 >= end) {
                    set(i, bits.get(i));
                    i++;
                } else {
                    this.bits[i >> 5] = bits.bits[i >> 5];
                    i += 32;
                }
            }
        }

        public void copy(BitSet bitSet, int l, int r, int to) {
            int shift = to - l;
            for (int i = l; i <= r; )
                if ((i & 31) != 0 || i + 32 >= r) {
                    set(i + shift, bitSet.get(i));
                    i++;
                } else {
                    word(i + shift, bitSet.bits[i >> 5]);
                    i += 32;
                }
        }


        public void offsetRight(int offset) {
            int k = offset >> 5;
            int l = offset & 31;


            if (l == 0) {
                for (int i = 0; i < intSize - k; i++)
                    bits[i] = bits[i + k];
            } else {
                for (int i = 0; i < intSize - k - 1; i++)
                    bits[i] = bits[i + k] >>> l | (bits[i + k + 1] << (32 - l));
                bits[intSize - k - 1] = bits[intSize - 1] >>> l;

            }

        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s.append((char) ('a' + get(i)));
            }
            return s.toString();
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String s = in.next();
        BitSet bits = new BitSet(n);
        BitSet tmp = new BitSet(n);
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == 'b') bits.flip(i);


        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            switch (in.next()) {
                case "C":
                    int l = in.nextInt() - 1;
                    int r = in.nextInt() - 1;
                    int value = in.next().equals("a") ? 0 : 1;

                    bits.fill(l, r, value);

                    break;
                case "S":

                    int l1 = in.nextInt() - 1;
                    int r1 = in.nextInt() - 1;
                    int l2 = in.nextInt() - 1;
                    int r2 = in.nextInt() - 1;

                    bits.swap(l1, r1, l2, r2, tmp);


                    break;
                case "R":

                    l = in.nextInt() - 1;
                    r = in.nextInt() - 1;
                    bits.reverse(l, r, tmp);


                    break;
                case "W":
                    l = in.nextInt() - 1;
                    r = in.nextInt() - 1;

                    bits.print(l, r);

                    break;
                case "H":
                    l1 = in.nextInt() - 1;
                    l2 = in.nextInt() - 1;
                    if (l1 > l2) {
                        int k = l1;
                        l1 = l2;
                        l2 = k;
                    }

                    tmp.copy(bits);
                    tmp.offsetRight(l2 - l1);
                    tmp.xor(bits);
                    int len = in.nextInt();
                    int count = 0;
                    for (int j = l1; j < l1 + len; ) {
                        if ((j & 31) != 0 || j + 32 >= l1 + len) {
                            count += tmp.get(j);
                            j++;
                        } else {
                            count += bitCount(tmp.bits[j >> 5]);
                            j += 32;
                        }
                    }

                    System.out.println(count);

                    break;
            }
        }
    }
}
