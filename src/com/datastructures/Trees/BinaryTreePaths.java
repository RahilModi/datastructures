package com.datastructures.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ans;
        String str = "";
        PathHelper(root, str);
        return ans;
    }


    private void PathHelper(TreeNode crt, String path){
        if(crt == null) return;
        path += crt.val;
        if(crt.left == null && crt.right == null){
            ans.add(path);
        }else{
            path+="->";
            PathHelper(crt.left, path);
            PathHelper(crt.right, path);
        }
    }
}
