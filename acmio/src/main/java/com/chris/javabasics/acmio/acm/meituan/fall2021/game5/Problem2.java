package com.chris.javabasics.acmio.acm.meituan.fall2021.game5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), p = sc.nextInt(), q = sc.nextInt();

        int[] a = new int[p];
        for(int i = 0; i < p; ++i)
            a[i] = sc.nextInt();

        int[] b = new int[q];
        for(int i = 0; i < q; ++i)
            b[i] = sc.nextInt();

        HashSet<Integer> sa = Arrays.stream(a)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        HashSet<Integer> sb = Arrays.stream(b)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        HashSet<Integer> c = new HashSet<>(sa);
        c.retainAll(sb);

        HashSet<Integer> sca = new HashSet<>(sa);
        sca.removeAll(c);

        HashSet<Integer> scb = new HashSet<>(sb);
        scb.removeAll(c);

        System.out.println(sca.size() + " " + scb.size() + " " + c.size());
    }
}
