package com.chris.javabasics.acmio.acm.meituan.fall2021.game10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(in.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String tables = in.readLine();
            int M = Integer.parseInt(in.readLine());
            String enters = in.readLine();

            int[] res = solve(
                    tables.toCharArray(),
                    enters.toCharArray(),
                    N,
                    M
            );

            for(int num : res) {
                out.write(Integer.toString(num));
                out.newLine();
            }
        }
        out.flush();
    }

    private static int[] solve(char[] tables, char[] enters, int N, int M) {
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        list.add(new PriorityQueue<>());
        list.add(new PriorityQueue<>());
        list.add(new PriorityQueue<>());
        for(int i = 0; i < N; ++i)
            list.get(tables[i]-'0').add(i);

        int[] res = new int[M];
        for(int i = 0; i < M; ++i) {
            int table;
            if(enters[i] == 'M') {
                if(list.get(1).isEmpty()) {
                    table = list.get(0).poll();
                    list.get(1).add(table);
                } else {
                    table = list.get(1).poll();
                    list.get(2).add(table);
                }
            } else {
                if(list.get(0).isEmpty()) {
                    table = list.get(1).poll();
                    list.get(2).add(table);
                } else {
                    table = list.get(0).poll();
                    list.get(1).add(table);
                }
            }
            res[i] = table + 1;
        }

        return res;
    }
}
