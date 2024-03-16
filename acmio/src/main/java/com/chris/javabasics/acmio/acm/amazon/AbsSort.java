package com.chris.javabasics.acmio.acm.amazon;

import java.util.Arrays;
import java.util.Comparator;

public class AbsSort {
    public static Integer[] run(Integer[] arr) {
        Comparator<Integer> cmp = Comparator.comparingInt(Math::abs);
        Arrays.sort(arr, cmp);
        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr = { -9, -5, -3, 0, 1, 4, 7, 8, 10 };
        Integer[] sortedArr = AbsSort.run(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}
