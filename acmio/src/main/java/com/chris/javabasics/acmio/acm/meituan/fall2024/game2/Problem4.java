package com.chris.javabasics.acmio.acm.meituan.fall2024.game2;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        while(q-- > 0) {
            int m = sc.nextInt(), x = sc.nextInt();

            if(x > m)
                System.out.println(x % m == 0 ? m : x % m);
            else
                System.out.println(x);
        }
    }
}
