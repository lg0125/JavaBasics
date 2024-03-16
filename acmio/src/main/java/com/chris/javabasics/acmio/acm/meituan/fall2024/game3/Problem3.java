package com.chris.javabasics.acmio.acm.meituan.fall2024.game3;

import java.util.HashMap;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        HashMap<Integer, Long> map = new HashMap<>();
        for(int i = 1; i <= m; ++i) map.put(i, 0L);

        for(int i = 1; i <= n; ++i) {
            int k   = sc.nextInt();
            long c  = sc.nextLong();

            long cost = (long) Math.ceil(c / (k * 1.0));
            for(int j = 1; j < k; ++j) {
                int p = sc.nextInt();
                map.put(p, map.get(p) + cost);
            }
        }

        for(int i = 1; i <= m; ++i)
            System.out.printf(map.get(i) + " ");
        System.out.println();
    }
}
