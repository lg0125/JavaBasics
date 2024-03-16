package com.chris.javabasics.acmio.acm.meituan.fall2021.game7;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt(), N = sc.nextInt();

        int cnt = 0, num, A, B, C, D, E, F, AB, CD, EF;
        if(M < N && M / 100000 >= 1 && N / 100000 >= 1) {
            for(int i = M; i <= N; ++i) {
                num = i;

                F = num % 10;

                num /= 10;
                E = num % 10;
                if(E == F) continue;

                num /= 10;
                D = num % 10;
                if(D == E || D == F) continue;

                num /= 10;
                C = num % 10;
                if(C == D || C == E || C == F) continue;

                num /= 10;
                B = num % 10;
                if(B == C || B == D || B == E || B == F) continue;

                num /= 10;
                A = num % 10;
                if(A == B || A == C || A == D || A == E || A == F) continue;

                AB = A * 10 + B;
                CD = C * 10 + D;
                EF = E * 10 + F;
                if(AB + CD == EF) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
