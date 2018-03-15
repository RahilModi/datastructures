package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        if(nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permuteUtil(nums, res, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }

    private void permuteUtil(int[] input, List<List<Integer>> result, List<Integer> crt, boolean[] used ){
        if(crt.size() == input.length){
            result.add(new ArrayList<>(crt));
        }else{
            for(int i = 0; i < input.length ; i++){
                if(used[i] || i > 0 && input[i] == input[i-1] && !used[i-1])continue;
                crt.add(input[i]);
                used[i] = true;
                permuteUtil(input,result,crt, used);
                used[i] = false;
                crt.remove(crt.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        for(List<Integer> t: new permutationII().permuteUnique(new int[]{1,3,1})){
            System.out.println(t);
        }
    }
}
