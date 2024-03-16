package com.chris.javabasics.acmio.lc;

public class LC88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;

        int[] sorted = new int[m+n];
        while(p1 < m || p2 < n) {
            int cur;
            if(p1 == m)
                cur = nums2[p2++];
            else if(p2 == n)
                cur = nums1[p1++];
            else if(nums1[p1] < nums2[p2])
                cur = nums1[p1++];
            else
                cur = nums2[p2++];
            sorted[p1+p2-1] = cur;
        }

        System.arraycopy(sorted, 0, nums1, 0, m + n);
    }
}
