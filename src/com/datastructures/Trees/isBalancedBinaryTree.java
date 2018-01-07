package com.datastructures.Trees;

public class isBalancedBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftHeight = depthHelper(root.left);
        int rightHeight = depthHelper(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depthHelper(TreeNode crt){
        if(crt == null) return 0;
        int left = depthHelper(crt.left);
        int right = depthHelper(crt.right);
        return Math.max(left,right)+1;
    }

    //O(n) solution
    public boolean isBalancedMethod2(TreeNode root){
        if(root == null) return true;
        return dfsHeight(root) != -1;
    }

    public int dfsHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = dfsHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if(rightHeight == -1) return -1;
        if(Math.abs(leftHeight-rightHeight)>1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;

    }
}
