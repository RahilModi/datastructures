package com.datastructures.arrays;

import java.util.*;

public class KthLargestElement {
    //leetcode : 215
    //Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

    //For example,
    //Given [3,2,1,5,6,4] and k = 2, return 5.
    //Complexity: O(nlogn)
    public int findKthLargest(int[] nums, int k){
        if(k > nums.length || nums == null || nums.length < 1 || k<=0){
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);

        return nums[nums.length - k];
    }
    //Complexity: O(n)
    public int findKthLargestElement(int[] nums, int k){
        if(k > nums.length || nums == null || nums.length < 1 || k<=0){
            return Integer.MIN_VALUE;
        }
        Map<Integer,Integer> mapOfValues = new TreeMap<Integer,Integer>(Collections.reverseOrder());
        for(int num : nums){
            if(!mapOfValues.containsKey(num)){
                mapOfValues.put(num,1);
            }else{
                mapOfValues.put(num,mapOfValues.get(num)+1);
            }
        }

        Iterator<Integer> itr = mapOfValues.keySet().iterator();
        int i =0;
        while(itr.hasNext() && k > 0){
            k-=mapOfValues.get(i = itr.next());
        }

        return i;
    }

    public static void main(String[] args) {
        KthLargestElement obj = new KthLargestElement();
        System.out.println(obj.findKthLargest(new int[]{1,2,3,4,5,6,78,9,6,4,234,223,223},1));
        System.out.println(obj.findKthLargestElement(new int[]{1,2,3,4,5,6,78,9,6,4,234,223,223},2));
    }
}
