package com.chris.javabasics.acmio.acm.meituan.fall2024.game3;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();

        long[] a = new long[n];
        for(int i = 0; i < n; ++i)
            a[i] = sc.nextLong();

        Arrays.sort(a);

        long mod = 1000000007;
        long res = 0L, sum = 0L;
        int idx = n-1;
        for(int i = 0; i < k; ++i) {
            if(a.length >= 2) {
                long mul = (a[idx] * a[idx-1]) % mod;
                a[idx]   = 1;
                a[idx-1] = mul;

                idx--;
            } else {
                res = Math.max(res, a[0]);
                break;
            }
        }

        for(int i = 0; i < n; ++i)
            sum += a[i];
        res = Math.max(res, sum % mod);
        System.out.println(res);
    }
}
