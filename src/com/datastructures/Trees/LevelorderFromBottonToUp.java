package com.datastructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelorderFromBottonToUp {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null) return output;
        Queue<TreeNode> level = new LinkedList<>();

        level.offer(root);

        while(!level.isEmpty()){

            int levelNum = level.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0 ; i<levelNum ; i++) {
                TreeNode temp = level.poll();
                subList.add(temp.val);
                if (temp.left != null) level.offer(temp.left);
                if (temp.right != null) level.offer(temp.right);
            }
            output.add(0,subList);

        }
        return output;

    }
}
