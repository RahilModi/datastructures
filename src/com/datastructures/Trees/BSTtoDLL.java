package com.datastructures.Trees;
class Node{
    int data;
    Node left, right;
    Node(int value){
        data = value;
        left = null;
        right = null;
    }
}
class BSTtoDLL {
    Node root;
    Node head;
    static Node prev = null;
    void BSTtoDLL(Node root){
        if(root == null) return;
        BSTtoDLL(root.left);

        if(prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        BSTtoDLL(root.right);
    }

}
