package com.datastructures.DynamicProgramming;

public class coinChangeII {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return amount == 0 ? 1 : 0;
        int[][] T = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++){
            T[i][0] = 1;
        }
        for(int i = 0; i < coins.length ; i++){
            for(int j = 1; j <= amount ; j++){
                if(i == 0){
                    if(j % coins[i]==0) T[i][j] = 1;
                }else {
                    if (j < coins[i]) {
                        T[i][j] = T[i - 1][j];
                    } else {
                        T[i][j] = T[i][j - coins[i]] + T[i - 1][j];
                    }
                }
            }
        }
        return T[coins.length-1][amount];
    }
}
