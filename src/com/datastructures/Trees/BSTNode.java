package com.datastructures.Trees;

public class BSTNode {
    private int data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BSTNode(){
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BSTNode){
            if(obj != null && this.getData() == ((BSTNode) obj).getData()){
                return true;
            }
        }
        return false;
    }
}
