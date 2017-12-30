package com.datastructures.Trees;

public class BST {

    private BSTNode root = null;

    public BST(){

    }

    public BSTNode findNodeInBST(BSTNode node, int data){
        if(node.getData() == data) return node;
        if(node == null) return null;
        if(data < node.getData())
            return findNodeInBST(node.getLeft(),data);
        else if(data > node.getData())
            return findNodeInBST(node.getRight(), data);
        return node;
    }

    public BSTNode find(int data){
        BSTNode temp = this.root;
        if(temp == null) return null;
        while(temp != null){
            if(temp.getData() == data) return temp;
            else if(data < temp.getData()) temp = temp.getLeft();
            else temp = temp.getRight();
        }
        return null;
    }

    public BSTNode findMinimum(BSTNode node){
        if(node == null) return null;
        else
            if(node.getLeft() == null) return node;
            else return findMinimum(node.getLeft());
    }

    public BSTNode findMin(){
        BSTNode temp = this.root;
        if(temp == null) return null;
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp;
    }

    public BSTNode findMaximum(BSTNode node){
        if(node == null) return null;
        else
        if(node.getRight() == null) return node;
        else return findMinimum(node.getRight());
    }

    public BSTNode findMax(){
        BSTNode temp = this.root;
        if(temp == null) return null;
        while(temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp;
    }

    public BSTNode insertInBST(BSTNode root, int data){
        if (root == null) root = new BSTNode(data);
        else{
            if(data < root.getData()){
                root.setLeft(insertInBST(root.getLeft(),data));
            }else{
                root.setRight(insertInBST(root.getRight(),data));
            }
        }
        return root;
    }

    public BSTNode deleteNode(BSTNode root, int data){
        BSTNode temp = null;
        if(root == null) return null;
        else if (data < root.getData()) root.setLeft(deleteNode(root.getLeft(), data));
        else if (data > root.getData()) root.setRight(deleteNode(root.getRight(),data));
        else{

            if(root.getLeft() == null)  return root.getLeft();
            else if(root.getRight() == null) return root.getRight();
            //delete temp node
            //find maximum from the left subtree
            //assign it to temp
            root.setData(temp.getData());
            root.setLeft(deleteNode(root.getLeft(),root.getData()));
        }
        return root;
    }

    public boolean checkBST(BinaryTreeNode node){
        if(node == null) return true;
        if(node.getLeft() != null && node.getLeft().getData() > node.getData()) return false;
        if(node.getRight() != null && node.getRight().getData() < node.getData()) return false;
        if(!isBST(node.getLeft()) || !isBST(node.getRight())) return false;
        return true;
    }

    //solved incorrect parrt of the above code
    public boolean isBST(BinaryTreeNode node){
        if(node == null) return true;
        //              6
        //      2               8
        //  1       9
        //above tree will give correct answer in above solution.

        //compare with the max element of the left subtree
        if(node.getLeft() != null && node.getData() < findMaximum(node.getLeft()).getData()) return false;
        //compare with the min element of the right subtree
        if(node.getRight() != null &&  findMinimum(node.getRight()).getData() < node.getData()) return false;
        if(!isBST(node.getLeft()) || !isBST(node.getRight())) return false;
        return true;
    }

    public int distanceFromRoot(BSTNode root, int key){
        if(root.getData() == key) return 0;
        else if(root.getData() > key) return 1 + distanceFromRoot(root.getLeft(), key);
        else
            return 1+distanceFromRoot(root.getRight(), key);
    }

    public int shortestPathBetweenTwoNodes(BSTNode root, int key1, int key2){
        if(root == null) return 0;
        if(root.getData() > key1 && root.getData() > key2) return shortestPathBetweenTwoNodes(root.getLeft(),key1,key2);
        else if(root.getData() < key1 && root.getData() < key2) return shortestPathBetweenTwoNodes(root.getRight(), key1, key2);
        else
            return distanceFromRoot(root,key1) + distanceFromRoot(root,key2);
    }

    public BSTNode lca(BSTNode root, BSTNode n1, BSTNode n2){
        if(root.getData() > Math.max(n1.getData(),n2.getData())) return lca(root.getLeft(),n1,n2);
        else if(root.getData() < Math.min(n1.getData(),n2.getData())) return lca(root.getRight(),n1,n2);
        else
            return root;
    }

    //another method to solve the isBST problem is to do inorder traversal and keep glbal variable
    //which points to previous node and current node value should be greater than prev
    public BSTNode findkthSmallest(BSTNode root, int k, int counter){
        if(root == null) return null;
        BSTNode node = findkthSmallest(root.getLeft(),k, counter);
        if(counter != k){
            counter++;
            node = root;
        }
        if(counter == k) return node;
        else return findkthSmallest(node.getRight(),k,counter);
    }

    public int ceilNode(BSTNode node, int data){
        if(node == null)return -1;
        if(node.getData() == data) return node.getData();
        if(node.getData() < data) return ceilNode(node.getRight(),data);
        int ceil = ceilNode(node.getLeft(),data);
        return ceil>=data ? ceil : node.getData();
    }

    public int floorNode(BSTNode node, int data){
        if(node == null) return  -1;
        if(node.getData() == data) return node.getData();
        if(node.getData() > data) return floorNode(node.getLeft(),data);
        int floor = floorNode(node.getRight(),data);
        return floor < node.getData() ? node.getData():floor;
    }
}
