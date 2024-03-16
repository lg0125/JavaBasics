package com.chris.javabasics.acmio.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        var ans = new ArrayList<List<Integer>>();

        int n = nums.length;
        if(nums == null || n < 3) return ans;

        Arrays.sort(nums);

        for(int i = 0; i < n; ++i) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int l = i + 1, r = n-1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                } else if(sum < 0) {
                    l++;
                } else if(sum > 0) {
                    r--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = LC15.threeSum(nums);
        System.out.println(lists);
    }
}
