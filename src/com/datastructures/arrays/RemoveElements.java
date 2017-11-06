package com.datastructures.arrays;

public class RemoveElements {
    //leetcode 26
    public int removeDuplicates(int[] nums) {
        int id = nums.length > 0 ? 1 : 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                nums[id++] = nums[i];
            }
        }
        return id;
    }

    //leetcode 27
    /*Given an array and a value, remove all instances of that value in-place and return the new length.

    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.*/
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length ;j++){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElements obj = new RemoveElements();
        System.out.println(obj.removeDuplicates(new int[]{1,2,3,4,4,5}));

        System.out.println(obj.removeElement(new int[]{1,2,3,4,4,5},5));
    }
}
