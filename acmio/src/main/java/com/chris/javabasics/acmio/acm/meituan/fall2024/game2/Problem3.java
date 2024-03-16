package com.chris.javabasics.acmio.acm.meituan.fall2024.game2;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s = sc.next().toCharArray();
        int n = s.length;

        int[][][] dp = new int[n][n][2];
        dp[0][0][s[0]-'0']      = 0;
        dp[0][0][1-s[0]+'0']    = 1;

        int res = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                if(i ==0 && j == 0) continue;

                int bit = s[j]-'0';
                dp[i][j][bit]   = dp[i][j-1][1-bit];
                dp[i][j][1-bit] = dp[i][j-1][bit] + 1;

                res += Math.min(
                        dp[i][j][bit],
                        dp[i][j][1-bit]
                );
            }
        }
        System.out.println(res);
    }
}
