package com.chris.javabasics.acmio.acm.meituan.fall2021.game6;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = sc.nextInt();

        int cnt = 0;
        for(int i = 0; i < n-m+1; ++i)
            for(int j = i; j < i+m; ++j)
                if(a[j] < k) {
                    cnt++;
                    break;
                }

        System.out.println(n-m+1-cnt);
    }
}
