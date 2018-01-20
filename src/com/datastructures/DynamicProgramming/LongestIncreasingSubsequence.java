package com.datastructures.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    //O(n2) complexity
    public int lengthOfLIS(int[] nums) {
        int[] temp =  new int[nums.length];
        Arrays.fill(temp,1);
        for(int i = 1; i<nums.length;i++){
            for(int j =0; j<i;j++){
                if(nums[j] < nums[i]){
                    int crt = temp[j];
                    if(crt >= temp[i]) temp[i] = crt + 1;
                }
            }
        }
        return getMax(temp);
    }

    private int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i: arr){
            if(i>max){
                max = i;
            }
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }

    public int lengthOfLISII(int[] nums) {
        int[] temp =  new int[nums.length];
        int length = 0;
        int count = 1;
        for(int num:nums){
            int i = Arrays.binarySearch(temp,0,length,num);
            if(i<0){
                i = -(i+1);
            }
            temp[i] = num;
            if(i == length){
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        new LongestIncreasingSubsequence().lengthOfLISII(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }
}
