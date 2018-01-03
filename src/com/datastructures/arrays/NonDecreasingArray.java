package com.datastructures.arrays;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 1; i<nums.length ;i++){
            if(nums[i-1]>nums[i]){
                count++;
                if(nums[i-2]<= nums[i] || i-2<0)nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
            if(count >= 2) return false;
        }
        return true;
    }
}
