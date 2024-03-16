package com.chris.javabasics.acmio.acm.meituan.fall2021.game7;

import java.util.*;

// TODO
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int P = sc.nextInt(), Q = sc.nextInt();

        String[] s = new String[N];

        int j;
        Node start = null;
        for(int i = 0; i < N; ++i) {
            s[i] = sc.next();

            if(s[i].contains("S")) {
                j = s[i].indexOf("S");
                start = new Node(i, j);
            }
        }

        String str = sc.next();

        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        int len = str.length(), score = 0;
        for(int i = 0; i < len; ++i) {
            Node node = Objects.requireNonNull(q.peek());

            int row = node.row, col = node.col;

            switch (str.charAt(i)) {
                case 'W' -> {
                    if(row - 1 < 0 || s[row-1].charAt(col) == '#')
                        continue;
                    q.offer(new Node(row - 1, col));
                    score = helper(s, P, Q, score, row - 1, col);
                    q.poll();
                }
                case 'A' -> {
                    if(col - 1 < 0 || s[row].charAt(col-1) == '#')
                        continue;
                    q.offer(new Node(row, col - 1));
                    score = helper(s, P, Q, score, row, col - 1);
                    q.poll();
                }
                case 'S' -> {
                    if(row + 1 >= N || s[row+1].charAt(col) == '#')
                        continue;
                    q.offer(new Node(row + 1, col));
                    score = helper(s, P, Q, score, row + 1, col);
                    q.poll();
                }
                case 'D' -> {
                    if(col + 1 >= M || s[row].charAt(col+1) == '#')
                        continue;
                    q.offer(new Node(row, col + 1));
                    score = helper(s, P, Q, score, row, col + 1);
                    q.poll();
                }
            }
        }

        System.out.println(score);
    }

    private static int helper(String[] s, int P, int Q, int score, int row, int col) {
        char[] str = s[row].toCharArray();

        if(str[col] == 'O') {
            score += P;
            str[col] = '+';
            s[row] = Arrays.toString(str);
        } else if(str[col] == 'X') {
            score -= Q;
            str[col] = '+';
            s[row] = Arrays.toString(str);
        }

        return score;
    }
}

class Node {
    int row, col;

    Node() {}
    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
