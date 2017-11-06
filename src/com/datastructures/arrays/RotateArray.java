package com.datastructures.arrays;

import java.util.Arrays;

public class RotateArray {

    //leetcode 189
    //Time limit exceeds
    public static void rotateArray(int[] nums, int k){
        for(int i = 0; i < k ; i++){
            int previous = nums[nums.length - 1];
            for(int j = 0; j < nums.length; j++){
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        printArray(nums);
    }


    //Extra space
    public static void rotateArray2(int [] nums, int k){
        int [] temp = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++){

            temp[(k+i)%nums.length] = nums[i];
        }
        printArray(temp);
    }
    //      ____________
    //  ____|_________  |
    //  |   |        |  |
    //  1   2   3   4   5   6   7
    //
    // int[] nums = {1,2,3,4,5,6,7} k:3
    public static void rotateArray3(int [] nums, int k){
        k = k % nums.length;
        int count = 0;
        for(int start = 0; count<nums.length; start++){
            int current = start;
            int prev = nums[start]; //keep the value of replaced element's original value
            do {
                int next = (current + k) % nums.length; //calculate the currents elements position
                int temp = nums[next]; //store the value of element at next
                nums[next] = prev;  //replace value
                prev = temp; //save temp to previous
                current = next; //now update the current
                count++;
            } while (start != current);
        }
        printArray(nums);
    }

    // numss: 1,2,3,4,5,6,7    and k:3
    //Original List                   : 1 2 3 4 5 6 7
    //After reversing all numbers     : 7 6 5 4 3 2 1
    //After reversing first k numbers : 5 6 7 4 3 2 1
    //After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result

    public static void rotateArray4(int[] nums, int k){
        k = k % nums.length;
        reverse(nums, 0 ,nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums, k, nums.length-1);
        printArray(nums);
    }

    private static void reverse(int [] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private static void printArray(int[] nums){
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void main(String[] args) {
        rotateArray(new int[]{1,2,3,4,5,6,7}, 3);
        rotateArray2(new int[]{1,2,3,4,5,6,7}, 0);
        rotateArray3(new int[]{1,2,3,4,5,6,7}, 3);
        rotateArray4(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
