package com.chris.javabasics.acmio.acm.meituan.fall2021.game10;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] seq = new int[n];
        for(int i = 0; i < n; ++i)
            seq[i] = sc.nextInt();
        Arrays.sort(seq);

        int num = 1, res = 0;
        for(int i = 0; i < n; ++i) {
            res += Math.abs(num - seq[i]);
            num++;
        }
        System.out.println(res);
    }
}
