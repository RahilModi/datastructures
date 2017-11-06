package com.datastructures.arrays;

public class TwoSum {
    //leetcode :1
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        java.util.HashMap<Integer,Integer> pairMap = new java.util.HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(pairMap.get(nums[i]) == null){
                int diff = target-nums[i];
                pairMap.put(diff,i);
            }else{
                result[0] = pairMap.get(nums[i]);
                result[1] = i;
                return result;
            }
        }
        return result;
    }

    //leetcode : 167 : sorted input Array
    public int[] twoSumSortedArray(int[] numbers, int target) {
        int beginPtr = 0;
        int endPtr = numbers.length - 1;
        int i = 0;
        while(i < numbers.length){
            int sum = numbers[beginPtr] + numbers[endPtr];
            if(sum == target){
                return new int[]{beginPtr+1,endPtr+1};
            }
            else if(sum > target){
                endPtr--;
            }
            else{
                beginPtr++;
            }
        }
        return new int[]{-1,-1};
    }


}
