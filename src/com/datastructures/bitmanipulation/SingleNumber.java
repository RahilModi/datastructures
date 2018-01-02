package com.datastructures.bitmanipulation;

import org.omg.PortableInterceptor.INACTIVE;

//Leetcode problem number : 136
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int answer = nums[0];
        for(int i = 1; i < nums.length; i++){
            answer ^= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{1,2,3,4,5,2,3,5,1}));
    }
}
