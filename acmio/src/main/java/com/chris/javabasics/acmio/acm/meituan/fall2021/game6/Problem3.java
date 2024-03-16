package com.chris.javabasics.acmio.acm.meituan.fall2021.game6;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        int[][] mat = new int[n+1][m+1];
        for(int i = 1; i <= n; ++i)
            for(int j = 1; j <= m; ++j)
                mat[i][j] = sc.nextInt();

        if(n % 2 == 0) {
            while(n > 0) {
                if(judge(mat, n, m)) n /= 2;
                else break;
            }
        }

        System.out.println();
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                System.out.print(mat[i][j]);
                if(j != m) System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean judge(int[][] mat, int n, int m) {
        if(n % 2 == 1) return false;

        int mid = n / 2;
        for(int i = 1; i <= mid; ++i)
            for(int j = 1;j <= m; ++j)
                if(mat[i][j] != mat[2 * mid - i + 1][j])
                    return false;
        return true;
    }
}
