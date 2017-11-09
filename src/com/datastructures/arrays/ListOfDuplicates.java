package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfDuplicates {

    //leetcode 442: find all duplicates(O(nlogn))
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == nums[i-1]) duplicates.add(nums[i]);
        }
        return duplicates;
    }

    //efficient O(n) similar another approach is set2 on geeksforgeeks
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[Math.abs(nums[i]) - 1] < 0){
                duplicates.add(Math.abs(nums[i]));
            }else{
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }
        return duplicates;
    }

}
