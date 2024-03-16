package com.chris.javabasics.acmio.acm.meituan.fall2024.game3;

import java.util.Arrays;
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        for(int i = 0; i < q; ++i) {
            int n = sc.nextInt(), m = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];
            for(int j = 0; j < n; ++j) a[j] = sc.nextInt();
            for(int j = 0; j < n; ++j) b[j] = sc.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);

            boolean isSuccess = true;
            for(int j = 0, k = n-1; j < n; j++, k--) {
                if(!(a[j] + b[k] >= 1 && a[j] + b[k] <= m)) {
                    isSuccess = false;
                    break;
                }
            }
            System.out.println(isSuccess ? "Yes" : "No");
        }

    }
}
