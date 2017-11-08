package com.datastructures.Trees;

public class GenericTreeTest {
    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(1);
        GenericTree tree = new GenericTree(rootNode);
        rootNode.setFirstChild(new TreeNode(2));
//      Generic Tree structure for test
//                     1
//                    /
//                  2 -> 3 -> 4 -> 5
//                           /
//                          6 -> 7 -> 8
//                              /
//                             9
        rootNode.getFirstChild().setNextSibling(new TreeNode(3));
        rootNode.getFirstChild().getNextSibling().setNextSibling(new TreeNode(4));
        rootNode.getFirstChild().getNextSibling().getNextSibling().setFirstChild(new TreeNode(6));
        rootNode.getFirstChild().getNextSibling().getNextSibling().setNextSibling(new TreeNode(5));
        rootNode.getFirstChild().getNextSibling().getNextSibling().getFirstChild().setNextSibling(new TreeNode(7));
        rootNode.getFirstChild().getNextSibling().getNextSibling().getFirstChild().getNextSibling().setFirstChild(new TreeNode(9));
        rootNode.getFirstChild().getNextSibling().getNextSibling().getFirstChild().getNextSibling().setNextSibling(new TreeNode(8));

        System.out.println("Sum of all generic tree elements : " +tree.FindSum(rootNode));

        /*find depth of the below tree
        p[] = -1  0   1   6   6   0   0   2   7
               0  1   2   3   4   5   6   7   8*/
        int[] p = new int[]{-1,0,1,6,6,0,0,2,7};
        System.out.println("Depth of the given tree is : "+tree.findDepthOfTheGenericTreeFromArray(p));

        System.out.println("Number of siblings of the node: " + tree.SiblingsCount(rootNode.getFirstChild().getNextSibling().getNextSibling().getFirstChild()));

        TreeNode rootNode1 = new TreeNode(2);

        rootNode1.setFirstChild(new TreeNode(3));
        rootNode1.getFirstChild().setNextSibling(new TreeNode(4));
        rootNode1.getFirstChild().getNextSibling().setNextSibling(new TreeNode(6));
        rootNode1.getFirstChild().getNextSibling().getNextSibling().setFirstChild(new TreeNode(10));
        rootNode1.getFirstChild().getNextSibling().getNextSibling().setNextSibling(new TreeNode(111));
        rootNode1.getFirstChild().getNextSibling().getNextSibling().getFirstChild().setNextSibling(new TreeNode(112));
        rootNode1.getFirstChild().getNextSibling().getNextSibling().getFirstChild().getNextSibling().setFirstChild(new TreeNode(102));
        rootNode1.getFirstChild().getNextSibling().getNextSibling().getFirstChild().getNextSibling().setNextSibling(new TreeNode(114));

        TreeNode rootNode2 = new TreeNode(1);
        rootNode2.setFirstChild(new TreeNode(2));
        rootNode2.getFirstChild().setNextSibling(new TreeNode(3));
        rootNode2.getFirstChild().getNextSibling().setNextSibling(new TreeNode(4));
        rootNode2.getFirstChild().getNextSibling().getNextSibling().setFirstChild(new TreeNode(6));
        rootNode2.getFirstChild().getNextSibling().getNextSibling().setNextSibling(new TreeNode(5));
        rootNode2.getFirstChild().getNextSibling().getNextSibling().getFirstChild().setNextSibling(new TreeNode(7));
        rootNode2.getFirstChild().getNextSibling().getNextSibling().getFirstChild().getNextSibling().setNextSibling(new TreeNode(8));

        System.out.println("Does both trees have the same structure : " +tree.isIsomorphicTrees(rootNode, rootNode1));
        System.out.println("Does both trees have the same structure : " +tree.isIsomorphicTrees(rootNode, rootNode2));
        System.out.println("Does both trees have the same structure : " +tree.isIsomorphicTrees(rootNode2, rootNode1));

        System.out.println("Number of childrens of the node: " + tree.numberOfChildrens(rootNode));
        System.out.println("Number of childrens of the node: " + tree.numberOfChildrens(rootNode.getFirstChild().getNextSibling().getNextSibling()));
        System.out.println("Number of childrens of the node: " + tree.numberOfChildrens(rootNode.getFirstChild().getNextSibling().getNextSibling().getFirstChild()));
    }

}
