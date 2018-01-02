package com.datastructures.arrays;

import java.util.Arrays;

public class LargestNumberAtleastTwice {
    public int dominantIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        if(temp[temp.length-1] / 2 >= temp[temp.length-2] ) return index(nums,temp[temp.length-1]);
        return -1;
    }
    public int index(int[] temp, int num){
        for(int i = 0; i < temp.length ; i++){
            System.out.println(temp[i]);
            if(temp[i] == num) return i;
        }
        return -1;
    }

}
