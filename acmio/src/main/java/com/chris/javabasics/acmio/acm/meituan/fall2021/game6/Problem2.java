package com.chris.javabasics.acmio.acm.meituan.fall2021.game6;

import java.util.Scanner;

public class Problem2 {
    private static final long mod = 998244353L;

    private static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt(), d = sc.nextInt();

        dp = new long[n+1][k+1];

        helper(n, k);
        helper(n, d-1);

        if(d < 1 || k < 0 || d > k)
            System.out.println(0);
        else
            System.out.println((dp[n][k] + mod - dp[n][d - 1]) % mod);
    }

    private static void helper(int n, int k) {
        dp[0][k] = 1L;

        long window = 0;
        for(int i=1; i <= n; ++i) {
            if(i>=k+1)
                window = (window + dp[i-1][k] - dp[i-k-1][k] + mod) % mod;
            else
                window = (window + dp[i-1][k]) % mod;
            dp[i][k] = window;
        }
    }
}
