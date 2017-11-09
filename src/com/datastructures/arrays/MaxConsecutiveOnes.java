package com.datastructures.arrays;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int maxConsecutiveOnes = 0;
        for(int num: nums){
            if(num != 1){
                if(maxConsecutiveOnes < sum) maxConsecutiveOnes = sum;
                sum = 0;
            }else {
                sum++;
            }
        }
        return maxConsecutiveOnes<sum?sum:maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
        obj.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1});
    }
}
