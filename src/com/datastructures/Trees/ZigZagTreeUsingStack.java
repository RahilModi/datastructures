package com.datastructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigZagTreeUsingStack {


//Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(result == null) return result;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        List<Integer> level = null;
        while(!s1.empty() || !s2.empty()){
            level = new ArrayList<>();
            while(!s1.empty()){
                TreeNode temp = s1.pop();
                level.add(temp.val);
                if(temp.left != null) s2.push(temp.left);
                if(temp.right != null) s2.push(temp.right);
            }
            if(level.size() != 0) {
                result.add(level);
            }
            level = new ArrayList<>();
            while(!s2.empty()){
                TreeNode temp = s2.pop();
                level.add(temp.val);
                if(temp.right != null) s1.push(temp.right);
                if(temp.left != null) s1.push(temp.left);
            }
            if(level.size() != 0) {
                result.add(level);
            }
        }
        return result;
    }
}
