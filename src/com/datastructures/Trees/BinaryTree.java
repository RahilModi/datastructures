package com.datastructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    //Data -> left -> Right
    public void preOrderTraversal(BinaryTreeNode root){
        if(root != null){
            System.out.print(root.getData());
            System.out.print("->");
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }

    //store root in the arraylist and put right in stack first and then left so left will be popped first.
    public ArrayList<Integer> preOrder(BinaryTreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){

        }
        Stack<BinaryTreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            BinaryTreeNode temp = s.pop();
            res.add(temp.getData());
            if (temp.getRight() != null) {
                s.push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                s.push(temp.getLeft());
            }
        }
        return res;
    }

    // left -> Data -> Right
    public void inOrderTraversal(BinaryTreeNode root){
        if(root != null){
            inOrderTraversal(root.getLeft());
            System.out.print(root.getData());
            System.out.print("->");
            inOrderTraversal(root.getRight());
        }
    }

    public ArrayList<Integer> inOrder(BinaryTreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode currentNode = root;
        while(true){
            if(currentNode != null){
                s.push(currentNode);
                currentNode = currentNode.getLeft();
            }else{
                if(s.isEmpty()){
                    break;
                }else{
                    currentNode = s.pop();
                    res.add(currentNode.getData());
                    currentNode = currentNode.getRight();
                }
            }
        }
        return res;
    }

    public void inOrderUsingStack(BinaryTreeNode root){
        if(root == null){
            return;
        }
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode temp = root;
        while(temp != null){
            s.push(temp);
            temp = temp.getLeft();
        }

        while(s.size() > 0){

            temp = s.pop();
            System.out.print(temp.getData() + " -> ");

            if(temp.getRight() != null){
                temp = temp.getRight();
                while(temp != null){
                    s.push(temp);
                    temp = temp.getLeft();
                }
            }
        }
    }

    //left -> Right -> Data
    public void postOrderTraversal(BinaryTreeNode root){
        if(root != null){
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.print(root.getData());
            System.out.print("->");
        }
    }

    public ArrayList<Integer> postOrder(BinaryTreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<BinaryTreeNode> s = new Stack<>();
        s.push(root);
        BinaryTreeNode prev = null;
        while(!s.isEmpty()){
            BinaryTreeNode curr = s.peek();
            if(prev == null || prev.getLeft()==curr || prev.getRight()==curr){
                if(curr.getLeft() != null){
                    s.push(curr.getLeft());
                }else if(curr.getRight() != null){
                    s.push(curr.getRight());
                }
            }else if(curr.getLeft()==prev){
                if(curr.getRight()!=null){
                    s.push(curr.getRight());
                }
            }else{
                res.add(curr.getData());
                s.pop();
            }
            prev = curr;

        }
        return res;
    }

    public void postOrderUsingTwoStacks(BinaryTreeNode root){
        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            BinaryTreeNode temp = s1.pop();
            if(temp.getLeft() != null){
                s1.push(temp.getLeft());
            }
            if(temp.getRight() != null){
                s1.push(temp.getRight());
            }
            s2.push(temp);
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().getData() + " -> ");
        }
    }

    public int height(BinaryTreeNode node){
        if(node == null){
            return 0;
        }
        else{
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());
            if(leftHeight > rightHeight){
                return (leftHeight+1);
            }else{
                return (rightHeight+1);
            }
        }
    }

    public void nodesAtGivenLevel(BinaryTreeNode node, int height){
        if(node == null) {
            return;
        }
        if(height == 1){
            System.out.print(node.getData() + " ");
        }
        else if(height > 1){
            nodesAtGivenLevel(node.getLeft(),height-1);
            nodesAtGivenLevel(node.getRight(),height-1);
        }
    }
    public void levelOrder(BinaryTreeNode root){
        int h = height(root);
        for(int i = 1 ; i <= h ; i++ ){
            nodesAtGivenLevel(root,i);
        }
    }

    public void levelOrderUsingQueue(BinaryTreeNode root){
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode temp = q.poll();
            System.out.print(temp.getData() + " ");

            if(temp.getLeft() != null){
                q.add(temp.getLeft());
            }
            if(temp.getRight()!= null){
                q.add(temp.getRight());
            }
        }
    }


}
