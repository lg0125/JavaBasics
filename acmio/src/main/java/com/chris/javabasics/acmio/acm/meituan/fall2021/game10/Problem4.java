package com.chris.javabasics.acmio.acm.meituan.fall2021.game10;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
            a[i] = sc.nextInt();

        // 在a[i,j]中，以k为根的最优二叉树
        int[][][] dp = new int[N][N][N];
        for(int i = 0; i < N-1; ++i)
            dp[i][i+1][i] = dp[i][i+1][i+1] = a[i] * a[i+1];

        // 跳步长度
        for(int k = 2; k < N; ++k) {
            // 左端位置
            for(int i = 0; i < N-k; ++i) {
                // 中间位置
                for(int m = i; m <= i+k; ++m) {
                    // 左边最小
                    int left = (m == i) ? 0 : dp[i][m-1][i] + a[i] * a[m];
                    for(int l = i+1; l < m; ++l)
                        left = Math.min(left, dp[i][m-1][l] + a[l] * a[m]);
                    // 右边最小
                    int right = (m == i+k) ? 0 : dp[m+1][i+k][i+k] + a[i+k] * a[m];
                    for(int r = m+1; r < i+k; ++r)
                        right = Math.min(right, dp[m+1][i+k][r] + a[r] * a[m]);
                    // 统计
                    dp[i][i+k][m] = left + right;
                }
            }
        }

        int res = dp[0][N-1][0];
        for(int i = 1; i < N; ++i)
            res = Math.min(res, dp[0][N-1][i]);
        System.out.println(res);
    }
}
