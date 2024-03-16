package com.chris.javabasics.acmio.acm.meituan.fall2021.game7;

import java.util.*;

public class Problem4 {

    private static boolean[] vis;
    private static int[] w;

    private static int[] max;
    private static int[] min;
    private static int[] childnum;

    private static int maxdiff = -1;
    private static int node = -1;

    private static Map<Integer, List<Integer>> g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), K = sc.nextInt();

        w = new int[N+1];
        for(int i = 1; i <= N; ++i)
            w[i] = sc.nextInt();

        vis         = new boolean[N+1];
        max         = new int[N+1];
        min         = new int[N+1];
        childnum    = new int[N+1];

        g = new HashMap<>();
        List<Integer> adj;
        for(int i = 1; i <= N-1; ++i) {
            int x = sc.nextInt(), y = sc.nextInt();

            if(g.containsKey(x))
                adj = g.get(x);
            else
                adj = new ArrayList<>();
            adj.add(y);
            g.put(x, adj);


            if(g.containsKey(y))
                adj = g.get(y);
            else
                adj = new ArrayList<>();
            adj.add(x);
            g.put(y, adj);
        }

        int root = sc.nextInt();

        dfs(root, K);

        System.out.println(node);
    }

    private static void dfs(int root, int K) {
        vis[root] = true;

        max[root] = w[root];
        min[root] = w[root];
        childnum[root] = 1;

        for (int child : g.get(root)) {
            if (!vis[child]) {
                dfs(child, K);

                max[root] = Math.max(max[root], max[child]);
                min[root] = Math.min(min[root], min[child]);
                childnum[root] += childnum[child];
            }
        }

        if(childnum[root] <= K && max[root] - min[root] >= maxdiff) {
            if(max[root] - min[root] > maxdiff) {
                node = root;
                maxdiff = max[root] - min[root];
            } else {
                node = (node == -1) ? root : Math.min(node, root);
            }
        }
    }
}
