package com.chris.javabasics.acmio.lc;

public class LC53 {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int[] dp = new int[n];
        System.arraycopy(nums, 0, dp, 0, n);

        for(int i = 1; i < n; ++i)
            dp[i] = Math.max(dp[i], dp[i-1] + nums[i]);

        int res = Integer.MIN_VALUE;
        for (int num : nums) res = Math.max(res, num);
        return res;
    }
}
