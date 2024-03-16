package com.chris.javabasics.acmio.acm.meituan.fall2024.game3;

import java.util.HashMap;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);

        int ans = -1;
        long pre = 0, cur;

        for(int i = 1; i <= n; ++i) {
            cur = pre + sc.nextInt() - k;

            if(map.containsKey(cur))
                ans = Math.max(ans, i - map.get(cur));
            else
                map.put(cur, i);

            pre = cur;
        }
        System.out.println(ans);
    }
}
