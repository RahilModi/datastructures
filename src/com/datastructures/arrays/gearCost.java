package com.datastructures.arrays;

import java.util.HashMap;

public class gearCost {


    public int[] findLowestCost (int[] radius, int[] cost, int diameter){

        HashMap<Integer,Integer> radiusMap = new HashMap<>();
        for(int i =0 ; i<radius.length; i++){
            int minRequired = diameter - radius[i];
            radiusMap.put(i, minRequired);
        }

        int[] output = new int[radius.length];

        for(int i = 0; i < radius.length ; i++){
            int minCost = Integer.MAX_VALUE;
            int resultIndex = 0;
            for(int j = 0; j < radius.length; j++){
                if(radius[j] + radius[i] >= diameter){
                    if (minCost > cost[j]){
                        minCost = cost[j];
                        resultIndex = j + 1;
                    }else if (minCost == cost[j] && radius[j] > radius[resultIndex - 1]){
                        resultIndex = j + 1;
                    }
                }
            }
            output[i] = resultIndex;
        }

        return output;
    }

    public static void main(String[] args) {
        int [] result = new gearCost().findLowestCost(new int[]{1,3,6,2,5}, new int[]{5,6,8,3,4}, 8);

        for(int i : result){
            System.out.println(i);
        }
    }
}
