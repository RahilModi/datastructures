package com.datastructures.arrays;

public class MoveZeros {
    //leet code 283
    public void moveZeroes(int[] nums) {
        for(int index = 0 , cur = 0 ; cur < nums.length ; cur++){
            if(nums[cur] != 0){
                int temp = nums[index];
                nums[index] = nums[cur];
                nums[cur] = temp;
                index++;
            }
        }
    }
}
