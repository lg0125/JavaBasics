package com.chris.javabasics.acmio.io;


import java.util.HashMap;
import java.util.HashSet;


public class Problem {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        var entries = map.entrySet();
        for(var entry : entries) {
            var k = entry.getKey();
            var v = entry.getValue();
            System.out.println(k + " " + v);
        }
    }
}
