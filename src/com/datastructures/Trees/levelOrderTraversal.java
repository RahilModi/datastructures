package com.datastructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<>();
        if(root == null) return lst;
        Queue<TreeNode> q =  new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> sublst = new ArrayList<>();
            for(int i =0 ; i < levelSize; i++){
                TreeNode temp = q.poll();
                if (temp.left !=null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
                sublst.add(temp.val);
            }
            lst.add(sublst);
        }
        return lst;

    }
}
