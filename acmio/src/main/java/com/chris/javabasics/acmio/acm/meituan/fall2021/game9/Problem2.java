package com.chris.javabasics.acmio.acm.meituan.fall2021.game9;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();

        int[] s = new int[n];
        for(int i = 0; i < n; ++i)
            s[i] = sc.nextInt();
        Arrays.sort(s);

        int t = s[n-x], cnt = 0;
        for(int i = 0; i < n; ++i)
            if(s[i] >= t && s[i] != 0) cnt++;
        System.out.println(cnt);
    }
}
