package com.chris.javabasics.acmio.acm.meituan.fall2021.game7;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        String S = sc.next(), T = sc.next();

        int j = 0, sum = 0;
        for(int i = 0; i < n; ++i)
            if(j < m && T.charAt(j) == S.charAt(i)) {
                j++;
                sum += (i+1);
            }

        if(j == m) {
            System.out.println("Yes");
            System.out.println(sum);
        } else {
            System.out.println("No");
        }
    }
}
