package com.chris.javabasics.acmio.acm.meituan.fall2024.game3;

import java.util.HashSet;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        // 没有小球的盒子的集合
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; ++i) set.add(i);

        int i;
        for(i = 1; i <= m; i++) {
            int op  = sc.nextInt();
            int x   = sc.nextInt();

            if(op == 1) {
                set.remove(x);
                if(set.isEmpty()) break;
            } else {
                if(!set.contains(x)) break;
                set = new HashSet<>();
                set.add(x);
            }
        }

        System.out.println(i > m ? -1 : i);
    }
}
