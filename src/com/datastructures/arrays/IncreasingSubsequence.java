package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findIncreasingSequences(res,new ArrayList<>(),0,nums);
        return res;
    }

    public void findIncreasingSequences(List<List<Integer>> ans,List<Integer> sequence, int pos, int[] arr){
        if(sequence.size() >= 2){
            ans.add(new ArrayList<>(sequence));
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = pos;i<arr.length; i++){
            if(visited.contains(arr[i])) continue;
            visited.add(arr[i]);
            if(sequence.size() == 0 || arr[i] >= sequence.get(sequence.size()-1)) {
                sequence.add(arr[i]);
                findIncreasingSequences(ans, sequence, i + 1, arr);
                sequence.remove(sequence.size() - 1);
            }
        }
    }
}
