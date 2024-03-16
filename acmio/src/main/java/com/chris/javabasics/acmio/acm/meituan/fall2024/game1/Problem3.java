package com.chris.javabasics.acmio.acm.meituan.fall2024.game1;

import java.util.HashMap;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        int pre = 0, val;
        while(n-- > 0) {
            val = sc.nextInt();
            map.put(val, pre);
            pre = val;
        }

        int x = sc.nextInt(), y = sc.nextInt();
        if(map.get(x) == y || map.get(y) == x)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
