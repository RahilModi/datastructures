package com.datastructures.arrays;

import java.util.Arrays;

public class ArrayPartition {

    //leetcode 561
    public int arrayPairSum(int[] nums) {
        int numOfPairs = nums.length / 2;
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i< nums.length ; i+=2){
            sum += nums[i];
        }
        return sum;
    }
}
