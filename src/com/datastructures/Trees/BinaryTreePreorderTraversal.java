package com.datastructures.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Method 1: Recursion
    List<Integer> preOrderList = new ArrayList<>();
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        if(root != null){
            preOrderHelper(root);
        }
        return preOrderList;
    }

    private void preOrderHelper(TreeNode root){
        if(root != null){
            preOrderList.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    //Method 2: Iterative Solution
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        if(root == null){
            return preOrderList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            preOrderList.add(temp.val);
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
        return preOrderList;
    }
}
