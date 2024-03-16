package com.chris.javabasics.acmio.io;

import java.util.Scanner;

/**
 * Input
 *      输入数据有多组，每行表示一组输入数据
 *      每行不定有n个整数，空格隔开(1 <= n <= 100)
 * Output
 *      每组数据输出结果
 * */
public class Case1 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line     = scanner.nextLine();
            String[] arr    = line.split(" ");

            int sum = 0;
            for(String str : arr) {
                int num = Integer.parseInt(str);
                sum += num;
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        run();
    }
}
