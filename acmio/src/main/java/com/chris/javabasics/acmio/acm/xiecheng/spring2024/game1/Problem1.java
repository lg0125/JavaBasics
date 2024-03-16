package com.chris.javabasics.acmio.acm.xiecheng.spring2024.game1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int youCnt = Math.min(
                Math.min(
                        map.getOrDefault('y', 0),
                        map.getOrDefault('o', 0)
                ),
                map.getOrDefault('u', 0)
        );
        map.put('y', map.getOrDefault('y', 0) - youCnt);
        map.put('o', map.getOrDefault('o', 0) - youCnt);
        map.put('u', map.getOrDefault('u', 0) - youCnt);

        StringBuilder ans = new StringBuilder();
        while (youCnt-- > 0)
            ans.append("you");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            while (cnt -- > 0)
                ans.append(entry.getKey());
        }
        System.out.println(ans);
    }
}
