package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
    //leetcode 169
    //Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    //You may assume that the array is non-empty and the majority element always exist in the array.
    //extra space
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        HashMap<Integer,Integer> numCountsMap = new HashMap<>();
        double count = Math.ceil((double)nums.length/2);
        int result = 0;

        for(int num: nums){
            if(numCountsMap.containsKey(num)){
                numCountsMap.put(num,numCountsMap.get(num)+1);
            }else{
                numCountsMap.put(num,1);
            }
            if(numCountsMap.get(num)>=count){
                result = num;
                break;
            }
        }
        return result;
    }
    //O(1) space
    public int majorityElementWOSpace(int[] nums) {
        int majority = 0;
        int count = 0;
        for(int num:nums){
            if(count == 0){
                majority = num;
                count++;
            }
            else{
                if(majority != num){
                    count--;
                }else{
                    count++;
                }
            }
        }
        return majority;
    }


    //leetcode 229
    //Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
    //Boyer-Moore Majority Vote algorithm
    public List<Integer> majorityElementNBy3(int[] nums) {
        if(nums == null || nums.length == 0 ){
            return  new ArrayList<Integer>();
        }
        List<Integer> results = new ArrayList<>();
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
        for(int num : nums){
            if(num == num1){
                count1++;
            }else if(num == num2){
                count2++;
            }else if(count1 == 0){
                num1 = num;
                count1++;
            }else if(count2 == 0){
                num2 = num;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i< nums.length ; i++){
            if(nums[i] == num1){
                count1++;
            }
            else if(nums[i] == num2){
                count2++;
            }
        }

        double minNumbers = (double)nums.length/3;
        if(count1 > minNumbers){
            results.add(num1);
        }
        if(count2 > minNumbers){
            results.add(num2);
        }

        return results;
    }
    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.majorityElement(new int[]{6,5,5}));
        obj.majorityElementNBy3(new int[]{0,0,0}).stream().forEach(System.out::println);
    }


}
