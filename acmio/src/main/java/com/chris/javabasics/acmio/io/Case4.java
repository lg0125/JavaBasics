package com.chris.javabasics.acmio.io;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 第一行是一个数字n，第二行是n个字符串
 * */
public class Case4 {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String[] arr = new String[n];
        for(int i = 0; i < n; ++i)
            arr[i] = scanner.next();

        System.out.println(Arrays.toString(arr));
    }
}
