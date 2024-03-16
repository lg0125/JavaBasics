package com.chris.javabasics.acmio.acm.meituan.fall2021.game8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// TODO
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int sx = sc.nextInt(), sy = sc.nextInt();
        int tx = sc.nextInt(), ty = sc.nextInt();

        int[][] a = new int[n+1][m+1];
        for(int i = 1; i <= n; ++i)
            for(int j = 1; j <= m; ++j)
                a[i][j] = sc.nextInt();

        int[][] b = new int[n+1][m+1];
        for(int i = 1; i <= n; ++i)
            for(int j = 1; j <= m; ++j)
                b[i][j] = sc.nextInt();

        boolean[][] visited = new boolean[n+1][m+1];
        for(int i = 1; i <= n; ++i)
            for(int j = 1; j <= m; ++j)
                visited[i][j] = false;

        int[] dir = new int[]{0, -1, 1};

        int cost = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy));
        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i = 0; i < sz; ++i) {
                Node node = q.peek();
                assert node != null;
                if(node.x == tx && node.y == ty) {
                    System.out.println(cost);
                    return;
                }
                q.poll();
                visited[node.x][node.y] = true;

                for(int j = 0; j < dir.length; ++j) {
                    int x = node.x, y = node.y;

                    if(x < 1 || x > n || y < 1 || y > m)
                        continue;

                    int remainder = cost % (a[x][y] + b[x][y]);
                    if(remainder < a[x][y])
                        x += dir[j];
                    else
                        y += dir[j];

                    if(j == 0 || !visited[x][y]) {
                        q.offer(new Node(x, y));
                        visited[x][y] = true;
                    }
                }
            }
            cost++;
        }
        System.out.println(cost);
    }
}

class Node {
    int x;
    int y;
    Node() {}
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
