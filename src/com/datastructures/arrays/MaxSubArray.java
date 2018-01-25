package com.datastructures.arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int max_ending_here = nums[0];
        for(int i = 1; i < nums.length; i++){
            max_ending_here = Math.max(nums[i],max_ending_here + nums[i]);
            max_so_far = Math.max(max_ending_here,max_so_far);
        }
        return max_so_far;
    }

    public int maxSubArrayUsingDP(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + (dp[i-1]>0?dp[i-1]:0);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
