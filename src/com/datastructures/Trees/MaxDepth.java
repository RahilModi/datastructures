package com.datastructures.Trees;

public class MaxDepth {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int leftSubTreeHeight = maxDepth(root.left);
        int rightSubTreeHeight = maxDepth(root.right);
        return ((leftSubTreeHeight > rightSubTreeHeight) ? leftSubTreeHeight : rightSubTreeHeight ) + 1 ;
    }

    //Method 2 : iterative solution using Stack and BFS;
}
