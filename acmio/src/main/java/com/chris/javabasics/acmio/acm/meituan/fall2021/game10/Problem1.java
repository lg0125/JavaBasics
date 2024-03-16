package com.chris.javabasics.acmio.acm.meituan.fall2021.game10;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
        if(2 * x > n || 2 * y < n) {
            System.out.println(-1);
            return;
        }

        int[] a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = sc.nextInt();
        Arrays.sort(a);

        y = Math.min(y, n-x);
        System.out.println(a[n - y - 1]);
    }
}
