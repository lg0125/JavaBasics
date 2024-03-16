package com.chris.javabasics.acmio.io;

import java.util.Scanner;

/**
 * 每行都有确定n个数字的情况
 * */
public class Case3 {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String line     = scanner.nextLine();
            String[] arr    = line.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            System.out.println(a+b);
        }
    }
}
