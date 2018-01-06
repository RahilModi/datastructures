package com.datastructures.Trees;

import java.util.*;

public class TwoSUMBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        Set<Integer> set = new HashSet<>();
        return isTwoSum(set, root, k);
    }

    private boolean isTwoSum(Set<Integer> temp, TreeNode crt, int k){
        if(crt == null) return false;
        if(temp.contains(crt.val)) return true;
        else{
            temp.add(k-crt.val);
        }
        return isTwoSum(temp, crt.left, k) || isTwoSum(temp, crt.right, k);
    }

}
