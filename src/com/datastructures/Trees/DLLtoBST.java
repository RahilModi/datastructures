package com.datastructures.Trees;
class DLLNode
{
    int data;
    DLLNode next, prev;

    DLLNode(int d)
    {
        data = d;
        next = prev = null;
    }
}
class DLLtoBST {
    DLLNode head;
    int length = 0;
    DLLtoBST(DLLNode root){
        head = root;
    }
    DLLNode temp = null;
    public DLLNode DLL2BST(){
        while(head != null){
            head = head.next;
            length++;
        }
        return DLL2BSTRecursive(length);
    }

    public DLLNode DLL2BSTRecursive(int size){
        if(size <= 0) return null;
        DLLNode left = DLL2BSTRecursive(size/2);
        DLLNode root =  head;
        root.prev = left;
        head = head.next;
        root.next = DLL2BSTRecursive(size - size/2 -1);
        return root;
    }
}
