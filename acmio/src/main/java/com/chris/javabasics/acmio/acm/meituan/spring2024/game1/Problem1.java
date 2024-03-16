package com.chris.javabasics.acmio.acm.meituan.spring2024.game1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]), k = Integer.parseInt(str[1]);

        String s = br.readLine();
        int cnt = 0;
        for(char c : s.toCharArray())
            if(c != 'M' && c != 'T') cnt++;

        int res = n - cnt + Math.min(k, cnt);
        System.out.println(res);
    }
}
