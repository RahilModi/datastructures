package com.datastructures.arrays;

public class LongestIncreasingSequence {

    //leetcode 674. Longest Continuous Increasing Subsequence
    //1,2,4,3,4,5,6,9,0 => 5
    public int findLengthOfLCIS(int[] nums) {

        if(nums.length == 0) return 0;
        int maxCount = 1;
        int count = 1;
        for(int i = 1; i< nums.length;i++){
            if(nums[i] > nums[i-1]){
                count++;
            }else{
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }

        return maxCount<count ? count:maxCount;

    }
}
