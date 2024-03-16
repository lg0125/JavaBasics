package com.chris.javabasics.acmio.acm.meituan.fall2024.game2;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long sum = 0;
        long[] a = new long[n];
        for(int i = 0; i < n; ++i) {
            a[i] = sc.nextLong();
            sum += a[i];
        }

        long r, max = 1;
        long s = 0, b = 0;
        for(int i = 0; i < n-1; ++i) {
            r = a[i] * a[i+1];
            if(max <= r) {
                max = r;
                s   = a[i];
                b   = a[i+1];
            }
        }

        System.out.println(sum + max - s - b);
    }
}
