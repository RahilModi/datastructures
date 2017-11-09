package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombinationSum {

    //leetcode 39: combination sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        for(int i = 0; i<candidates.length ; i++){
            List<Integer> res = new ArrayList<>();
            res.add(candidates[i]);
            helper(candidates,target-candidates[i],res,combinations,i);
            res.remove(res.size()-1);

        }
        return combinations;
    }

    private void helper(int[] candidates, int target, List<Integer> res, List<List<Integer>> combinations,int start){
            if(target > 0){
                for(int j = start; j<candidates.length;j++) {
                    int num = candidates[j];
                    res.add(num);
                    helper(candidates, target-num, res, combinations,j);
                    res.remove(res.size()-1);
                }
            }
            else if(target == 0){
                List<Integer> temp = new ArrayList<>(res);
                combinations.add(temp);
            }
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        obj.combinationSum(new int[]{1,2,3},7).stream().forEach(System.out::println);
    }

}
