package com.chris.javabasics.acmio.io;

import java.util.Scanner;

/**
 * 每行第一个数字为确定的数字n，后面跟着n个数字
 * */
public class Case2 {
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();

            int sum = 0;
            for(int i = 0; i < n; ++i) {
                int num = scanner.nextInt();
                sum += num;
            }
            System.out.println(sum);
        }
    }
}
