package com.datastructures.arrays;

import java.util.*;

public class ContainsDuplicate {

    // Leetcode 217
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return false;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length ; i++){
            if(i != (nums.length-1) && nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    // Leetcode 219
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> setOfNearByValues = new HashSet<>();
        for(int i = 0; i < nums.length ; i++){
            if(i>k) setOfNearByValues.remove(nums[i-k-1]);
            if(!setOfNearByValues.add(nums[i])) return true;
        }
        return false;
    }

    //Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
    //Leetcode 220
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length <= 1 ||  k < 1 || t < 0 ){
            return false;
        }
        TreeSet<Integer> setOfNearByValues = new TreeSet<>();
        for(int i = 0; i < nums.length ; i++){

            Integer s = setOfNearByValues.ceiling(nums[i]);
            if(s != null && s <= nums[i]+t) return true;

            Integer f = setOfNearByValues.floor(nums[i]);
            if(f != null && f+t >= nums[i]) return true;

            setOfNearByValues.add(nums[i]);

            if(setOfNearByValues.size() > k) setOfNearByValues.remove(nums[i-k]);

        }
        return false;
    }

    //leetcode 220 very efficient

    public boolean containsNearbyAlmostDuplicateUsingMap(int[] nums, int k, int t) {
        if (nums.length <=1 || k <= 0 || t < 0) return false;
        HashMap<Long, Integer> map = new HashMap<>();
        long bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long bucketId = (nums[i] < 0) ? nums[i]+1/bucketSize-1: nums[i]/bucketSize;

            if(map.containsKey(bucketId)) return true;

            if(map.containsKey(bucketId - 1) && Math.abs(nums[i]- map.get(bucketId-1)) < bucketSize) return true;
            if(map.containsKey(bucketId + 1) && Math.abs(nums[i]- map.get(bucketId+1)) < bucketSize) return true;

            map.put(bucketId,nums[i]);
            if(i >= k) map.remove((nums[i-k]<0)?nums[i-k]+1/bucketSize-1: nums[i-k]/bucketSize);
        }
        return false;
    }



    public static void main(String[] args) {
        ContainsDuplicate obj = new ContainsDuplicate();
        System.out.println(obj.containsDuplicate(new int[]{1,2,333,44344,53233,53233,4}));
        System.out.println(obj.containsDuplicate(new int[]{1,2,3,4,5,33990}));
        System.out.println(obj.containsDuplicate(new int[]{1,2,3,4,5,32,4}));

        System.out.println(obj.containsNearbyDuplicate(new int[]{1,2,4,3,4,13,433,12,3},2));
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{-2147483648,-2147483647},3,3));
    }


}
