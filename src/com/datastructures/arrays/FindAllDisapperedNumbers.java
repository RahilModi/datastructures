package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDisapperedNumbers {

    //leetcode 448. Find All Numbers Disappeared in an Array
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> listOfDisappeared = new ArrayList<>();
        for(int i = 0; i<nums.length ; i++ ) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] = -nums[index];
        }
        for(int i = 0; i<nums.length ; i++ ){
            if(nums[i]>0) listOfDisappeared.add(i+1);
        }

        return listOfDisappeared;
    }

    public static void main(String[] args) {
        FindAllDisapperedNumbers obj = new FindAllDisapperedNumbers();
        obj.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}).forEach(System.out::println);
    }
}

