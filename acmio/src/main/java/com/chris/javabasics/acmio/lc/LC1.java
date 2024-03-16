package com.chris.javabasics.acmio.lc;

import java.util.HashMap;

public class LC1 {
    public static int[] twoSum(int[] nums, int target) {
        var index = new HashMap<Integer, Integer>();

        int n = nums.length;
        for(int i = 0; i < n; ++i) index.put(nums[i], i);

        for(int i = 0; i < n; ++i) {
            int other = target - nums[i];

            if(index.containsKey(other) && i != index.get(other))
                return new int[]{i, index.get(other)};
        }

        return new int[]{-1, -1};
    }
}
