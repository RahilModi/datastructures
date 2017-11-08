package com.datastructures.Trees;


public class TreeNode {

    private int data;
    private TreeNode firstChild;
    private TreeNode nextSibling;

    public TreeNode(int data) {
        this.data = data;
        this.firstChild = null;
        this.nextSibling = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }


}
