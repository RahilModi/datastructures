package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DegreeOfAnArray {

    //Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
    //Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
    //leetcode: 697
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer,List<Integer>> degreeMap = new HashMap<>();
        int result = nums.length;
        int degree = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length ; i++){
            int val = nums[i];
            if(!degreeMap.containsKey(val)) {
                degreeMap.put(val,new ArrayList<>());
            }
            degreeMap.get(val).add(i);
            int size = degreeMap.get(val).size();
            if(size > degree){
                degree = size;
                result = i - degreeMap.get(val).get(0) + 1;
            }
            if(size == degree){
                result = Math.min(result, i - degreeMap.get(val).get(0) + 1);
            }

        }

        return result;

    }

}
