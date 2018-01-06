package com.datastructures.Trees;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLavelsInBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> average = new ArrayList<>();
        if(root == null) return average;
        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        while(!level.isEmpty()){
            int levelNum = level.size();
            double sum = 0;
            for(int i = 0; i<levelNum; i++){
                TreeNode temp = level.poll();
                sum += temp.val;
                if(temp.left != null) level.offer(temp.left);
                if(temp.right != null) level.offer(temp.right);
            }
            average.add(sum/levelNum);
        }
        return average;
    }

}
