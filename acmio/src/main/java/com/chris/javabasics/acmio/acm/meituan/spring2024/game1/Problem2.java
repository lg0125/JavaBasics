package com.chris.javabasics.acmio.acm.meituan.spring2024.game1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]), q = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        long a, sum = 0, cnt = 0;
        for(int i = 0; i < n; ++i) {
            a = Long.parseLong(str[i]);

            if(a == 0) cnt++;
            else sum += a;
        }

        for(int i = 0; i < q; ++i) {
            str = br.readLine().split(" ");
            long l = Long.parseLong(str[0]), r = Long.parseLong(str[1]);
            long max = sum + cnt * r, min = sum + cnt * l;
            System.out.println(min + " " + max);
        }
    }
}
