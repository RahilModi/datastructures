package com.datastructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int leftCount = minDepth(root.left);
        int rightCount = minDepth(root.right);
        return ((leftCount ==0 || rightCount == 0) ? leftCount+rightCount : Math.min(leftCount,rightCount)) +1 ;
    }

    public int minDepthIterative(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int depth = 1;
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                if (!q.isEmpty()) {
                    depth++;
                    q.offer(null);
                }
            } else {
                if (temp.left == null && temp.right == null)
                    return depth;
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }
        return depth;
    }
}
