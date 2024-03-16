package com.chris.javabasics.acmio.acm.meituan.fall2021.game9;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T-- > 0) {
            int N = sc.nextInt();

            int[] A = new int[N];
            int sum = 0;
            for(int i = 0; i < N; ++i) {
                A[i] = sc.nextInt();
                sum += A[i];
            }

            int maxs = A[0], curmax = A[0];
            int mins = A[0], curmin = A[0];
            for(int i = 1; i < N; ++i) {
                curmax = Math.max(A[i], A[i] + curmax);
                maxs = Math.max(maxs, curmax);

                curmin = Math.min(A[i], A[i] + curmin);
                mins = Math.min(mins, curmin);
            }

            System.out.println(Math.max(sum - mins, maxs));
        }
    }
}
