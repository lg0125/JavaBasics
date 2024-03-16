package com.chris.javabasics.acmio.acm.meituan.spring2024.game1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {
    static final int N = 210;
    static char[][] mat = new char[N][N];
    static int[][] presum = new int[N][N];

    static int query(int x1, int y1, int x2, int y2) {
        return presum[x2][y2] - presum[x2][y1-1] - presum[x1-1][y2] + presum[x1-1][y1-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int n = Integer.parseInt(line);

        for (int i = 1; i <= n; i++) {
            line = br.readLine();
            for (int j = 1; j <= n; j++)
                mat[i][j] = line.charAt(j - 1);
        }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                int val = mat[i][j] == '1' ? 1 : 0;
                presum[i][j] = presum[i][j-1] + presum[i-1][j] - presum[i-1][j-1] + val;
            }

        for (int len = 1; len <= n; len++) {
            int cnt = 0;
            for (int x = 1; x <= n - len + 1; x++) {
                for (int y = 1; y <= n - len + 1; y++) {
                    int sum = query(
                            x, y,
                            x + len - 1, y + len - 1
                    );

                    if (sum*2 == len*len) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
