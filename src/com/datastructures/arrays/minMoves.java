package com.datastructures.arrays;

public class minMoves {

    public int minmoves(int[] nums){

        int left = 0;
        int right = nums.length-1;
        int count = 0;
        while(left < right){

             while(nums[right] % 2 != 0 && left < right ) {
                 right--;
             }
             while (nums[left] % 2 == 0 && left < right){
                 left++;
             }
             if( left < right){
                 count++;
                 left ++;
                 right--;
             }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new minMoves().minmoves(new int[]{2,2,2,4,5}));
    }


}
