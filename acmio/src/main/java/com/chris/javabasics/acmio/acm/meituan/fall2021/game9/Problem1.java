package com.chris.javabasics.acmio.acm.meituan.fall2021.game9;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt(), m = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
            if(a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            int rest = n - m;
            boolean isSuccess = false;
            int maxw = 0, minw = 0;
            int[] w = new int[m];
            for(int i = 0; i < m; ++i) {
                w[i] = sc.nextInt();

                if(i == 0) {
                    maxw = w[i];
                    minw = w[i];
                }

                maxw = Math.max(maxw, w[i]);
                minw = Math.min(minw, w[i]);
            }

            if(rest == 0 && (minw == a && maxw == b))
                isSuccess = true;
            if(rest == 1 && (minw == a || maxw == b))
                isSuccess = true;
            if(rest == 2 && (minw >= a && maxw <= b))
                isSuccess = true;

            if(isSuccess)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}
