package com.chris.javabasics.acmio.acm.meituan.fall2024.game3;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();

        int day = 0;
        while(day <= z) {
            if(x * day + y * (day / 3) == z)
                break;
            day++;
        }
        System.out.println(day);
    }
}
