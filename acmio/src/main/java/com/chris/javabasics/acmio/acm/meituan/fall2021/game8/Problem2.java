package com.chris.javabasics.acmio.acm.meituan.fall2021.game8;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        int[] a = new int[n];
        char[] c = s.toCharArray();
        for(int i = 0; i < n; ++i)
            a[i] = (c[i] == 'E' ? 1 : -1);

        int sum = 0, max = 0;
        for(int i = 0; i < n; ++i) {
            sum += a[i];
            if(sum < 0) sum = 0;

            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
