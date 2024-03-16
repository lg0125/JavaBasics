package com.chris.javabasics.acmio.acm.meituan.spring2024.game1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem5 {
    static final int N = 100010;
    static int[] fa = new int[N];
    static List<String> res = new ArrayList<>();
    static int n, m, q;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        q = Integer.parseInt(str[2]);

        Set<int[]> edges = new HashSet<>();
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            edges.add(new int[]{u, v});
        }

        Set<int[]> del_edges = new HashSet<>();
        List<int[]> ops = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            str = br.readLine().split(" ");
            int op = Integer.parseInt(str[0]);
            int u = Integer.parseInt(str[1]);
            int v = Integer.parseInt(str[2]);

            if (op == 1) {
                del_edges.add(new int[]{u, v});
                del_edges.add(new int[]{v, u});
            }

            ops.add(new int[]{op, u, v});
        }

        for (int i = 0; i < N; i++)
            fa[i] = i;
        for (int[] edge : edges) { // 并查集建边
            boolean flag = false;
            for (int[] del_edge : del_edges)
                if (edge[0] == del_edge[0] && edge[1] == del_edge[1]) {
                    flag = true;
                    break;
                }
            if (flag) continue;

            merge(edge[0], edge[1]);
        }

        for (int i = q - 1; i >= 0; i--) {
            int[] op = ops.get(i);

            int u = op[1], v = op[2];

            if (op[0] == 1) {
                merge(u, v);
            } else {
                int a = find(u), b = find(v);

                if (a == b) res.add("Yes");
                else res.add("No");
            }
        }

        for (int i = res.size() - 1; i >= 0; i--)
            System.out.println(res.get(i));
    }

    public static int find(int x) {
        if (x != fa[x])
            fa[x] = find(fa[x]);
        return fa[x];
    }

    public static void merge(int a, int b) {
        int ta = find(a), tb = find(b);
        fa[ta] = tb;
    }
}
