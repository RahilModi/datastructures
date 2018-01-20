package com.datastructures.arrays;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = null;
        for(int i = 0; i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            int sum;
            while(l<r){
                sum = nums[i]+nums[l]+nums[r];
                if(sum == 0){
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    lst.add(temp);
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }else if(sum > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return lst;
    }

    public static void print(List<Integer> ans){
        for(int i: ans){
            System.out.print(i+" >> ");
        }
    }

    public static void main(String[] args) {
        for(List<Integer> sub : threeSum(new int[]{-1,0,1,2,-1,-4})){
            print(sub);
            System.out.println();
        }
    }
}
