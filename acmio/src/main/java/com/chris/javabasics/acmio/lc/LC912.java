package com.chris.javabasics.acmio.lc;

import java.util.Arrays;

public class LC912 {
    public static void main(String
                                    [] args) {
        int[] nums = {1,9,2,8,3,7,4,6};

        System.out.println(Arrays.toString(nums));

        Quicksort.run(nums, 0, nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    public static int[] sortArray(int[] nums) {
        Quicksort.run(nums, 0, nums.length-1);
        return nums;
    }

    private static class Quicksort {
        public static void run(int[] nums, int l, int r) {
            if(l < r) {
                int pos = position(nums, l, r);

                run(nums, l, pos-1);
                run(nums, pos+1, r);
            }
        }

        private static int position(int[] nums, int l, int r) {
            int pivot = nums[r];

            int i = l-1;
            for(int j = l; j <= r-1; ++j)
                if(nums[j] <= pivot) swap(nums, ++i, j);
            swap(nums, ++i, r);
            return i;
        }

        private static void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
