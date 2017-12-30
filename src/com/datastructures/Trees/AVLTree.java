package com.datastructures.Trees;
class AVLNode{
    int data, height;
    AVLNode left, right;

    AVLNode(int value){
        data = value;
        height = 1;
    }
}
class AVLTree {
    AVLNode root;
    int height(AVLNode node){
        if(node == null)return 0;
        else
            return node.height;
    }

    int max(int a,int b){ return (a>b)? a:b; }

    AVLNode rightRotate(AVLNode x){
        AVLNode newRoot = x.left;
        AVLNode T2 = newRoot.right;
        x.left = T2;
        newRoot.right = x;
        x.height = max(height(x.left),height(x.right)) +1;
        newRoot.height = max(height(newRoot.left),height(newRoot.right))+1;
        return newRoot;
    }

    AVLNode leftRotate(AVLNode x){
        AVLNode newRoot = x.right;
        AVLNode Temp = newRoot.left;
        x.right = Temp;
        newRoot.left = x;
        x.height = max(height(x.left),height(x.right)) +1;
        newRoot.height = max(height(newRoot.left),height(newRoot.right))+1;
        return newRoot;
    }

    AVLNode leftRightCase(AVLNode x){
        x.left = leftRotate(x.left);
        return rightRotate(x);
    }

    AVLNode rightLeftCase(AVLNode x){
        x.right = rightRotate(x.right);
        return leftRotate(x);
    }

    AVLNode insert(AVLNode node, int data){
        if(node == null)return new AVLNode(data);
        if(node.data < data) node.right = insert(node.right,data);
        else if(node.data > data) node.left = insert(node.left,data);
        else return node;
        node.height = 1 + max(height(node.left),height(node.right));
        int balance = height(node.left) - height(node.right);
        if(node.left.data > data && balance > 1){ //left left case
           return rightRotate(node);
        }
        else if(balance < -1 && data>node.right.data) return leftRotate(node);
        else if(balance > 1 && data > node.left.data) return leftRightCase(node);
        else if(balance < -1 && data< node.right.data) return rightLeftCase(node);
        return node;
    }


}
