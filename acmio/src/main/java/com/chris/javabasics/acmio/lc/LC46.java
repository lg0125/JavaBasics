package com.chris.javabasics.acmio.lc;

import java.util.LinkedList;
import java.util.List;

public class LC46 {
    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        var track = new LinkedList<Integer>();

        backtrack(nums, track);

        return res;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        if(track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int num : nums) {
            if (track.contains(num)) continue;

            track.add(num);

            backtrack(nums, track);

            track.removeLast();
        }
    }
}
