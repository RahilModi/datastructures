package com.datastructures.DynamicProgramming;

public class coinchange {

    public int coinChange(int[] coins, int amount) {
        int T[] = new int[amount+1];
        int R[] = new int[amount+1];

        for(int i =1; i<=amount ;i++){
            T[i] = Integer.MAX_VALUE -1;
            R[i] = -1;
        }
        for(int j = 0; j < coins.length ; j++){
            for(int i = coins[j]; i <=amount ; i++){
                if(T[i - coins[j]] + 1 < T[i]){
                    T[i] = T[i-coins[j]] + 1;
                    R[i] = j;
                }
            }
        }
        return T[amount] == Integer.MAX_VALUE -1 ? -1 : T[amount];
    }

    public static void main(String[] args) {
        System.out.println(new coinchange().coinChange(new int[]{1,2,5} , 11));
    }
}
