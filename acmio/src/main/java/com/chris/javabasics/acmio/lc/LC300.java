package com.chris.javabasics.acmio.lc;

import java.util.Arrays;

public class LC300 {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; ++i)
            for(int j = 0; j < i; ++j)
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i)
            res = Math.max(res, dp[i]);
        return res;
    }
}
