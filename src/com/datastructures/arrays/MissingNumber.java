package com.datastructures.arrays;

public class MissingNumber {
    //leetcode 268
    /*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

            For example,
    Given nums = [0, 1, 3] return 2.*/
    //usingXOR method
    public int missingNumber(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        for(int i = 0; i < nums.length ; i++){
            xor1 ^= nums[i];
            xor2 ^= i;
        }
        xor2 ^= nums.length;
        return xor1^xor2;
    }

    /*1. Get the sum of numbers
            total = n*(n+1)/2
    2  Subtract all the numbers from sum and
        you will get the missing number.*/
    public int missingNumberUsingSum(int[] nums){
        int sum = nums.length * (nums.length+1)/2;
        for(int num:nums){
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        System.out.println(obj.missingNumber(new int[]{0,1,3}));
    }
}
