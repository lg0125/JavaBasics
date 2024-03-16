package com.chris.javabasics.acmio.acm.meituan.fall2021.game8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        int e = sc.nextInt(), f = sc.nextInt(), g = sc.nextInt();

        int[] prices = new int[]{e, f, g};
        Arrays.sort(prices);
        int min = prices[0], mid = prices[1], max = prices[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(e, a);
        map.put(f, b);
        map.put(g, c);

        int profit = 0;
        while(d > 0 && map.get(max) > 0) {
            profit += max;
            map.put(max, map.get(max)-1);
            d--;
        }
        while(d > 0 && map.get(mid) > 0) {
            profit += mid;
            map.put(mid, map.get(mid)-1);
            d--;
        }
        while(d > 0 && map.get(min) > 0) {
            profit += min;
            map.put(min, map.get(min)-1);
            d--;
        }
        System.out.println(profit);
    }
}
