package com.datastructures.DynamicProgramming;

public class combinationSum {
    public int combinationSum4(int[] nums, int target) {
        int [] temp = new int[target+1];
        temp[0] = 1;

        for(int i = 1; i <= target ; i++){
            for(int j = 0; j < nums.length ;j++){
                if(i-nums[j]>=0){
                    temp[i] += temp[i-nums[j]];
                }
            }
        }
        return temp[target];
    }
}
