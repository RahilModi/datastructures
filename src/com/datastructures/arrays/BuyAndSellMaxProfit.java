package com.datastructures.arrays;

public class BuyAndSellMaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length == 0) return max;
        int localMin,localMax;
        int i = 0;
        while(i<prices.length-1){
            while(i<prices.length-1 && prices[i+1]<=prices[i]){
                i++;
            }
            if(i == prices.length-1) break;
            localMin = i++;
            while(i<prices.length && prices[i]>=prices[i-1]){
                i++;
            }
            localMax = i-1;
            max += prices[localMax]-prices[localMin];
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{100,180,260,310,40,140,230};
        new BuyAndSellMaxProfit().maxProfit(nums);
    }
}
