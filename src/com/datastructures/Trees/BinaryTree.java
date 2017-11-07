package com.datastructures.Trees;

import com.datastructures.arrays.MajorityElement;
import com.datastructures.queueProblems.QueueUsingTwoStack;

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
            return res;
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

    //Problem 1: maxElement with recurssion

    public int maxElementInBinaryTree(BinaryTreeNode root){
        int maxValue = Integer.MIN_VALUE;
        if(root == null){
            return maxValue;
        }else{
            int leftMax = maxElementInBinaryTree(root.getLeft());
            int rightMax = maxElementInBinaryTree(root.getRight());

            if(leftMax > rightMax ){
                maxValue = leftMax;
            }else{
                maxValue = rightMax;
            }

            if(root.getData() > maxValue){
                maxValue = root.getData();
            }

        }
        return  maxValue;
    }

    //Problem 2: maxElement w/o recurssion

    public int maxElementInBinaryTreeWORecurssion(BinaryTreeNode root){
        int maxValue = Integer.MIN_VALUE;
        if(root == null){
            return maxValue;
        }else {
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                BinaryTreeNode node = q.poll();
                if(maxValue < node.getData()){
                    maxValue = node.getData();
                }
                if(node.getLeft() != null){
                    q.offer(node.getLeft());
                }
                if(node.getRight() != null){
                    q.offer(node.getRight());
                }
            }

        }
        return maxValue;
    }

    //Problem 3:  search an element in Binary Tree
    public boolean findElementInBT(BinaryTreeNode root, int data){
        boolean result = false;
        if(root!=null){
            if(root.getData() == data){
                return true;
            }
            return findElementInBT(root.getLeft(),data) || findElementInBT(root.getRight(),data);
        }
        return result;
    }

    //problem 4: search an element in Binary Tree without recurssion
    public boolean findElementInBinaryTreeWORecurssion(BinaryTreeNode root,int data){
        boolean result = false;
        if(root != null){
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                BinaryTreeNode node = q.poll();
                if(node.getData() == data){
                    result = true;
                }
                if(node.getLeft() != null){
                    q.offer(node.getLeft());
                }
                if(node.getRight() != null){
                    q.offer(node.getRight());
                }
            }
        }
        return result;
    }

    //problem 5: Insert an element in BinaryTree
    public BinaryTreeNode insertElementinBT(BinaryTreeNode root,int data){
        if(root != null){
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                BinaryTreeNode node = q.poll();
                if(node.getLeft() != null){
                    q.offer(node.getLeft());
                }else{
                    node.setLeft(new BinaryTreeNode(data));
                    return root;
                }
                if(node.getRight() != null){
                    q.offer(node.getRight());
                }else{
                    node.setRight(new BinaryTreeNode(data));
                    return root;
                }
            }
        }
        return new BinaryTreeNode(data);
    }

    //problem 6: size of the binary tree
    public int sizeOfBT(BinaryTreeNode root){
        if(root != null){
            int leftTreeSize = root.getLeft() == null ? 0 : sizeOfBT(root.getLeft());
            int rightTreeSize = root.getRight() == null ? 0 : sizeOfBT(root.getRight());
            return 1 + leftTreeSize +rightTreeSize;
        }
        return 0;
    }

    public int sizeOfBTWORecurssion(BinaryTreeNode root){
        int count = 0;
        if(root != null){
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                BinaryTreeNode node = q.poll();
                count++;
                if(node.getLeft() != null){
                    q.offer(node.getLeft());
                }
                if(node.getRight() != null){
                    q.offer(node.getRight());
                }
            }
        }
        return count;
    }

    /**problem 8: Delete an element is simple in Java because Garbage collector works for us when we set any node to null
    Algorithm use post order traversal to delete all the children of the parent nodes.
     public void deleteElementFromBT(BinaryTreeNode root){ root = null }
              1
          2       3
      4       5 6     7
     nodes will be deleted in following order 4, 5, 2, 6, 7, 3, 1*/


    //problem 9: print level order elements in reverse order
    //As shown in problem 8 => level order travesel would be => 1 2 3 4 5 6 7 =>But we need to pint in order => 7 6 5 4 3 2 1
    public void levelOrderTravesalInReverse(BinaryTreeNode root){
        if(root != null){
            Queue<BinaryTreeNode> q = new LinkedList<>();
            Stack<BinaryTreeNode> s = new Stack<>();
            q.add(root);
            while(!q.isEmpty()){
                BinaryTreeNode node = q.poll();
                if(node.getLeft() != null){
                    q.offer(node.getLeft());
                }
                if(node.getRight() != null){
                    q.offer(node.getRight());
                }
                s.push(node);
            }
            System.out.println("\n");
            while(!s.isEmpty()){
                System.out.print(s.pop().getData()+", ");
            }
        }
    }

    //problem 10 : height of the binary tree
    public int heightOfTreeWithRecurssion(BinaryTreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftSubTreeHeight = heightOfTreeWithRecurssion(root.getLeft());
            int rightSubTreeHeight = heightOfTreeWithRecurssion(root.getRight());
            if(leftSubTreeHeight > rightSubTreeHeight){
                return 1 + leftSubTreeHeight;
            }else{
                return  1+ rightSubTreeHeight;
            }
        }

    }

    //problem 11 : simulate problem 10 recurssion using stack using post order traversal
    public int heightOfTreeUsingStack(BinaryTreeNode root){
        if(root == null){
            return 0;
        }else{
            Stack<BinaryTreeNode> s = new Stack<>();
            s.push(root);
            int maxDepth = 0;
            BinaryTreeNode prev = null;
            while(!s.isEmpty()){
                BinaryTreeNode currnt = s.peek();
                if(prev == null || prev.getLeft() == currnt || prev.getRight()== currnt){
                    if(currnt.getLeft() != null){
                        s.push(currnt.getLeft());
                    }else if(currnt.getRight() != null){
                        s.push(currnt.getRight());
                    }
                }else if(currnt.getLeft() == (prev)){
                    if(currnt.getRight() != null) s.push(currnt.getRight());
                }else{
                    s.pop();
                }
                prev = currnt;
                if(s.size() > maxDepth){
                    maxDepth = s.size();
                }
            }
            return maxDepth;
        }
    }

    //problem 12: find max height of the tree using iterative method
    public int maxHeightUsingIterative(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            int height = 0;
            while (true) {
                int nodeCount = q.size();
                if (nodeCount == 0) {
                    return height;
                }
                height++;
                while (nodeCount > 0) {
                    BinaryTreeNode node = q.poll();
                    if(node.getLeft()!=null){
                        q.offer(node.getLeft());
                    }
                    if(node.getRight() != null){
                        q.offer(node.getRight());
                    }
                    nodeCount--;
                }
            }

        }
    }

    //problem 13 : find minHeight/minDepth without recurssion similar to BFS
    public int minHeightOfTreeSimilarToBFS(BinaryTreeNode root){
        if(root == null){
            return 0;
        }else{
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            q.offer(null);
            int count = 1;
            while(!q.isEmpty()){
                BinaryTreeNode node = q.poll();
                if(node != null){
                    if(node.getLeft() == null && node.getRight() == null){
                        return count;
                    }
                    if(node.getLeft()!=null){
                        q.offer(node.getLeft());
                    }
                    if(node.getRight()!=null){
                        q.offer(node.getRight());
                    }
                }else{
                    if(!q.isEmpty()){
                        count++;
                        q.offer(null);
                    }
                }
            }
            return count;
        }
    }

    //problem 14: find deepest node
    public BinaryTreeNode getDeepestNodeInBT(BinaryTreeNode root){
        BinaryTreeNode node = null;
        if(root!=null){
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                node = q.poll();
                if(node.getLeft()!=null){
                    q.offer(node.getLeft());
                }
                if(node.getRight()!=null){
                    q.offer(node.getRight());
                }
            }
        }
        return node;
    }

   //problem 15: count number of leaves
    public int numberOfleaves(BinaryTreeNode root){
        int count = 0;
        if(root != null){
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()) {
                BinaryTreeNode node = q.poll();
                if (node.getLeft() == null && node.getRight() == null) {
                    count++;
                }
                if (node.getLeft() != null) {
                    q.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    q.offer(node.getRight());
                }

            }
        }
        return count;
    }

    //problem 16: number of full nodes means having 2 child nodes
    public int numberOfFullNodes(BinaryTreeNode root){
        int count = 0;
        if(root != null){
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                BinaryTreeNode node = q.poll();
                if(node.getLeft() != null && node.getRight() != null){
                    count++;
                }
                if(node.getLeft() != null){
                    q.offer(node.getLeft());
                }
                if(node.getRight() != null){
                    q.offer(node.getRight());
                }

            }
        }
        return count;
    }

    //problem 17: number of half nodes means having 1 child nodes
    public int numberOfhalfNodes(BinaryTreeNode root){
        int count = 0;
        if(root != null){
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                BinaryTreeNode node = q.poll();
                if((node.getLeft() != null && node.getRight() == null) || (node.getLeft() == null && node.getRight() != null)){
                    count++;
                }
                if(node.getLeft() != null){
                    q.offer(node.getLeft());
                }
                if(node.getRight() != null){
                    q.offer(node.getRight());
                }

            }
        }
        return count;
    }

    //problem 18: identify both trees are structurally identical
    public boolean checkStructurallySameTree(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2  == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return (checkStructurallySameTree(root1.getLeft(),root2.getRight()) && checkStructurallySameTree(root1.getRight(),root2.getLeft()));
    }

    //problem 19: maximumSum at which level
    public int findLevelWithMaxSum(BinaryTreeNode root){
        int maxSum = 0, currentSum = 0;
        if(root != null){
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            q.offer(null);
            while(!q.isEmpty()){
                BinaryTreeNode node = q.poll();
                if(node != null){
                    currentSum += node.getData();
                    if(node.getLeft()!=null){
                        q.offer(node.getLeft());
                    }
                    if(node.getRight()!=null){
                        q.offer(node.getRight());
                    }
                }else{
                    if(currentSum > maxSum){
                        maxSum = currentSum;
                    }
                    currentSum = 0;
                    if(!q.isEmpty())q.offer(null);
                }
            }
        }
        return maxSum;
    }

    //problem 20: find sum of all elements
    public int findSum(BinaryTreeNode root){
        if(root == null) return 0;
        return (root.getData() + findSum(root.getLeft()) + findSum(root.getRight()));
    }

    //problem 21: problem 20 without recursssion
    public int findSumwoRecurssion(BinaryTreeNode root){
        int sum = 0;
        if(root != null){
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                BinaryTreeNode node = q.poll();
                sum += node.getData();
                if(node.getLeft() != null){
                    q.offer(node.getLeft());
                }
                if(node.getRight() != null){
                    q.offer(node.getRight());
                }

            }
        }
        return sum;
    }

    //problem 22: check path exists in Binary tree of this sum
    public boolean checkPathofGivenSum(BinaryTreeNode root,int sum){
        if(root == null) return false;
        if(root.getLeft() == null && root.getRight() == null && root.getData() == sum){
            return true;
        }else{
            return checkPathofGivenSum(root.getLeft(),sum-root.getData()) || checkPathofGivenSum(root.getRight(),sum-root.getData());
        }
    }

    //problem 23: print all root node to leaf paths
    public void printpaths(BinaryTreeNode root){
        int path[] = new int[1000];
        printPathsHelper(root,path,0);
    }

    private void printPathsHelper(BinaryTreeNode root, int[] array, int len){
        if(root == null){
            return;
        }
        array[len] = root.getData();
        len++;

        if(root.getLeft() == null && root.getRight() == null){
            printArray(array, len);
        }else{
            printPathsHelper(root.getLeft(),array,len);
            printPathsHelper(root.getRight(),array,len);
        }
    }

    private void printArray(int[] path, int len){
        for(int i = 0; i<len; i++){
            System.out.print(path[i]+", ");
        }
        System.out.println("");
    }

    //problem 24: create mirror image of tree
    public BinaryTreeNode mirrorOfBT(BinaryTreeNode root){
        BinaryTreeNode temp;
        if(root != null){
            mirrorOfBT(root.getLeft());
            mirrorOfBT(root.getRight());
            temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
        return root;
    }

    //problem 25: check both trees are mirrot of each other
    public boolean areMirrors(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.getData() != root2.getData()) return false;
        else return areMirrors(root1.getLeft(), root2.getRight()) && areMirrors(root1.getRight(), root2.getLeft());

    }

    //problem 26: diameter of Binary tree
    ////leetcode 543: diameter based on the number of paths (need to remove +1 from the return statement)
    public int diameterOfBinaryTree(BinaryTreeNode root){
        if(root == null) return 0;
        int leftHeight = heightBT(root.getLeft());
        int rightHeight = heightBT(root.getRight());

        int diameterOfLeftBT = diameterOfBinaryTree(root.getLeft());
        int diameterOfRightBT = diameterOfBinaryTree(root.getRight());

        return Math.max(leftHeight + rightHeight + 1, Math.max(diameterOfLeftBT,diameterOfRightBT));

    }

    private static int heightBT(BinaryTreeNode node){
        if(node == null) return 0;
        return (1 + Math.max(heightBT(node.getLeft()),heightBT(node.getRight())));
    }

    //problem 27: width of Binary Tree

    public int maxWidthOfBinaryTree(BinaryTreeNode root){
        if(root == null) return 0;
        int maxwidth = 0;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int count = q.size();
            maxwidth = Math.max(maxwidth,count);
            while(count-->0){
                BinaryTreeNode temp = q.poll();

                if(temp.getLeft() != null){
                    q.add(temp.getLeft());
                }
                if(temp.getRight() != null){
                    q.add(temp.getRight());
                }
            }
        }

        return  maxwidth;
    }

    //problem 28: generate Binary tree from inorder and preorder traversals sequence.





}
