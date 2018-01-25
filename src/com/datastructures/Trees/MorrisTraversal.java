package com.datastructures.Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

    class Node{
         int data;
         Node left;
         Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void inorder(Node root){
        List<Integer> res = new ArrayList<>();
        Node crt = root;
        while(crt != null){
            if(crt.left == null){
                System.out.print(crt.data+" -> ");
                crt = crt.right;
            }else{
                Node predecessor = crt.left;
                while(predecessor.right != crt && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = crt;
                    crt = crt.left;
                }else{
                    predecessor.right = null;
                    System.out.print(crt.data+" -> ");
                    crt = crt.right;
                }
            }
        }
    }

    public void preorder(Node root){
        Node crt = root;
        while(crt != null){
            if(crt.left == null){
                System.out.print(crt.data+" -> ");
                crt = crt.right;
            }else{
                Node predecessor = crt.left;
                while(predecessor.right != crt && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = crt;
                    System.out.print(crt.data+" -> ");
                    crt = crt.left;
                }else{
                    predecessor.right = null;
                    crt = crt.right;
                }
            }
        }
    }

    public int kthSmallest(Node root, int k) {
        int KthSmallest = Integer.MIN_VALUE;
        int counter = 0;
        Node crt = root;
        while(crt != null){
            if(crt.left == null){
                counter++;
                if(counter == k){
                    KthSmallest = crt.data;
                }
                crt = crt.right;
            }else{
                Node predecessor = crt.left;
                while(predecessor.right != crt && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = crt;
                    crt = crt.left;
                }else{
                    predecessor.right = null;
                    counter++;
                    if(counter == k){
                        KthSmallest = crt.data;
                    }
                    crt = crt.right;
                }
            }
        }
        return KthSmallest;
    }

    public static void main(String[] args) {
        MorrisTraversal temp = new MorrisTraversal();
        Node root = temp.new Node(10);
        root.left = temp.new Node(5);
        root.left.right = temp.new Node(6);
        root.left.right.right = temp.new Node(8);
        root.left.left = temp.new Node(2);
        root.left.left.right = temp.new Node(3);
        root.right = temp.new Node(11);
        root.right.right = temp.new Node(18);
        System.out.println("Inorder Traversal");
        temp.inorder(root);
        System.out.println("Preorder Traversal");
        temp.preorder(root);
    }
}
