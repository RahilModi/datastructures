package com.datastructures.arrays;

import java.util.HashMap;
import java.util.List;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer,Integer> numAndPosition = new HashMap<>();
        for(int j = 0; j < nums2.length; j++){
            numAndPosition.put(nums2[j],j);
        }
        for(int i = 0; i < nums1.length; i++){
            int pos = numAndPosition.get(nums1[i]);
            boolean bFound = false;
            for(int k = pos+1; k < nums2.length; k++){
                if(nums2[k]>nums1[i]){
                    bFound = true;
                    result[i] = nums2[k];
                }
            }
            if(!bFound) result[i] = -1;
        }
        return result;
    }
}
