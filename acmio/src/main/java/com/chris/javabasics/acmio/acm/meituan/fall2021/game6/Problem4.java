package com.chris.javabasics.acmio.acm.meituan.fall2021.game6;

import java.util.Scanner;

// TODO dp推导 背包?
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long mod = 998244353L;

        while (sc.hasNext()) {
            int n = sc.nextInt();
            String s = sc.next();

            int sum = 0;
            for(int i = 0; i < n; ++i)
                sum += s.charAt(i) - 'A';

            long[][] dp = new long[n+1][sum+1];
            for(int i = 0; i <= n; ++i)
                dp[i][0] = 1L;

            for(int i = 1; i <= n; ++i)
                for(int j = 1; j <= sum; ++j)
                    for(int k = 0; k < 26; ++k)
                        if(j >= k) {
                            dp[i][j] += dp[i-1][j-k];
                            dp[i][j] %= mod;
                        }

            System.out.println(dp[n][sum] % mod);
        }
    }
}
