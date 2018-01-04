package com.datastructures.arrays;
//O(n) solution
public class findDuplicate {
    public int findDuplicate(int[] nums) {
        int slowPtr = nums.length;
        int fastPtr = nums.length;
        do{
            slowPtr = nums[slowPtr-1];
            fastPtr = nums[nums[fastPtr-1]-1];
        }while(slowPtr != fastPtr);
        slowPtr = nums.length;
        while(slowPtr != fastPtr){
            slowPtr = nums[slowPtr-1];
            fastPtr = nums[fastPtr-1];
        }
        return slowPtr;
    }
}
