package com.datastructures.Trees;

//leetcode problem:100

 class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1(int x) { val = x; }
 }
public class SameTree {
    public boolean isSameTree(TreeNode1 p, TreeNode1 q) {

        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}
