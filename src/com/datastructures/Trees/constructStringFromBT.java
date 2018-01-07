package com.datastructures.Trees;

public class constructStringFromBT {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if(left =="" && right=="") return t.val + "";
        if(left == "") return t.val +"()"+"("+right+")";
        if(right == "") return t.val +"("+left+")";
        return t.val+"("+left+")("+right+")";
    }


    public static void main(String[] args) {
        constructStringFromBT temp = new constructStringFromBT();
        TreeNode node = temp.new TreeNode(1);
        TreeNode node1 = temp.new TreeNode(2);
        TreeNode node2 = temp.new TreeNode(4);
        TreeNode node3 = temp.new TreeNode(3);
        node.left = node1;
        node1.left = node2;
        node.right = node3;
        System.out.println(temp.tree2str(node));

    }
}
