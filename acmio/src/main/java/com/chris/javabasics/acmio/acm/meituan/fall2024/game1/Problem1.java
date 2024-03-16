package com.chris.javabasics.acmio.acm.meituan.fall2024.game1;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum1 = 0, sum2 = 0;
        double a, b;

        int n = sc.nextInt();
        while(n-- >0) {
            a = sc.nextDouble();
            b = sc.nextDouble();

            if(b > a || a <= 0 || b <= 0) {
                System.out.println("error");
                return;
            }

            sum1 += a;
            sum2 += b;
        }

        double x = sc.nextDouble(), y = sc.nextDouble();
        if(y > x || x <= 0 || y <= 0) {
            System.out.println("error");
            return;
        }
        if(sum1 >= x) sum1 -= y;
        System.out.printf("%.2f\n", Math.min(sum1, sum2));
    }
}
