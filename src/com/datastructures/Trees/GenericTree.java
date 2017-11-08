package com.datastructures.Trees;

public class GenericTree {

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    private TreeNode root;

    public GenericTree(TreeNode root) {
        this.root = root;
    }

    public int FindSum(TreeNode root){
        if(root == null) return 0;
        return root.getData()+FindSum(root.getFirstChild())+FindSum(root.getNextSibling());
    }

    //Time complexity = O(n^2) can be reduced using hashmap and storing the height of the prevoiusly computed node but leads to extra space.
    public int findDepthOfTheGenericTreeFromArray(int[] p){
        int maxDepth = -1, currentDepth = -1, j;

        for(int i = 0; i<p.length ; i++){
            currentDepth = 0;
            j = i;
            while(p[j] != -1){
                currentDepth++;
                j = p[j];
            }
            if(maxDepth < currentDepth) maxDepth = currentDepth;

        }
        return maxDepth;
    }

    public int SiblingsCount(TreeNode node){
        int count = 0;
        while(node != null){
            count++;
            node = node.getNextSibling();
        }
        return count;
     }

     public boolean isIsomorphicTrees(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if((root1 == null && root2!= null )||(root1 != null && root2 ==null)){
            return false;
        }

        return isIsomorphicTrees(root1.getFirstChild(), root2.getFirstChild()) && isIsomorphicTrees(root1.getNextSibling(),root2.getNextSibling());
     }

     public int numberOfChildrens(TreeNode node){
         int count = 0;
         TreeNode temp = node.getFirstChild();
         while(temp != null){
             count++;
             temp = temp.getNextSibling();
         }
         return count;
     }
}
