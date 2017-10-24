package com.datastructures.Trees;

public class BTProblemsTest {

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(20);
        BinaryTree binaryTree = new BinaryTree(root);
        binaryTree.getRoot().setLeft(new BinaryTreeNode(10));
        binaryTree.getRoot().getLeft().setLeft(new BinaryTreeNode(40));
        binaryTree.getRoot().getLeft().setRight(new BinaryTreeNode(13));
        binaryTree.getRoot().setRight(new BinaryTreeNode(29));
        binaryTree.getRoot().getRight().setLeft(new BinaryTreeNode(21));
        binaryTree.getRoot().getRight().setRight(new BinaryTreeNode(28));

        System.out.println("-------------------------------------\n");

        System.out.println("            20          ");
        System.out.println("    10              29      ");
        System.out.println("40      13      21      28");

        System.out.println("\n-------------------------------------\n");
        System.out.println("Maximum element in binary tree : " + binaryTree.maxElementInBinaryTree(root));

        System.out.println("Maximum element in binary tree : " + binaryTree.maxElementInBinaryTreeWORecurssion(root));

        System.out.println("Finding element in binary tree : " + binaryTree.findElementInBT(null,13));

        System.out.println("Finding element in binary tree : " + binaryTree.findElementInBT(root,28));

        System.out.println("Finding element in right subtree binary tree w/o recurssion : " + binaryTree.findElementInBinaryTreeWORecurssion(root.getRight(),100));

        System.out.println("Finding element in binary tree w/o recurssion : " + binaryTree.findElementInBinaryTreeWORecurssion(root,21));

        binaryTree.levelOrderUsingQueue(root);
        System.out.println("\nInserting element in binary tree w/o recurssion : ");
        binaryTree.levelOrder(binaryTree.insertElementinBT(root,100));
        binaryTree.levelOrder(binaryTree.insertElementinBT(root,230));

        System.out.println("\nInserting element in binary tree w/o recurssion : ");
        binaryTree.levelOrder(binaryTree.insertElementinBT(root.getRight(),130));

        System.out.println("\n");
        binaryTree.levelOrderUsingQueue(root);

        System.out.println("\nInserting element in binary tree w/o recurssion : ");
        binaryTree.levelOrder(binaryTree.insertElementinBT(null,1220));

        System.out.println("\nSize of Binary Tree : " + binaryTree.sizeOfBT(root));
        System.out.println("\nSize of left subtree Binary Tree : " + binaryTree.sizeOfBT(root.getLeft()));
        System.out.println("\nSize of right subtree Binary Tree : " + binaryTree.sizeOfBT(root.getRight()));
        System.out.println("\nSize of Binary Tree : " + binaryTree.sizeOfBT(null));
        System.out.println("\nSize of Binary Tree w/o recurssion : " + binaryTree.sizeOfBTWORecurssion(null));

        System.out.println("\nSize of Binary Tree w/o recurssion : " + binaryTree.sizeOfBTWORecurssion(root));
        System.out.println("\nSize of left subtree Binary Tree w/o recurssion : " + binaryTree.sizeOfBTWORecurssion(root.getLeft()));
        System.out.println("\nSize of right subtree Binary Tree w/o recurssion : " + binaryTree.sizeOfBTWORecurssion(root.getRight()));

        binaryTree.levelOrder(root);
        binaryTree.levelOrderTravesalInReverse(root);
        binaryTree.insertElementinBT(root.getLeft(),233);
        binaryTree.insertElementinBT(root.getLeft(),3002);
        binaryTree.insertElementinBT(root.getLeft(),223);

        System.out.println("\nheight of right subtree Binary Tree: "+ binaryTree.heightOfTreeWithRecurssion(root.getRight()));
        System.out.println("\nheight of left subtree Binary Tree: "+ binaryTree.heightOfTreeWithRecurssion(root.getLeft()));
        System.out.println("\nheight of Binary Tree: "+ binaryTree.heightOfTreeWithRecurssion(root));


        System.out.println("\nheight of right subtree Binary Tree w/o recurssion: "+ binaryTree.heightOfTreeUsingStack(root.getRight()));
        System.out.println("\nheight of left subtree Binary Tree w/o recurssion: "+ binaryTree.heightOfTreeUsingStack(root.getLeft()));
        System.out.println("\nheight of Binary Tree w/o recurssion: "+ binaryTree.heightOfTreeUsingStack(root));

        System.out.println("\nheight of right subtree of Binary Tree using iterative method: "+ binaryTree.maxHeightUsingIterative(root.getRight()));
        System.out.println("\nheight of left subtree of Binary Tree using iterative method: "+ binaryTree.maxHeightUsingIterative(root.getLeft()));
        System.out.println("\nheight of Binary Tree using iterative method: "+ binaryTree.maxHeightUsingIterative(root));

        System.out.println("\nMinimum height of right subtree of  Binary Tree using BFS type algorithm: "+ binaryTree.minHeightOfTreeSimilarToBFS(root.getRight()));
        System.out.println("\nMinimum height of left subtree of Binary Tree using BFS type algorithm: "+ binaryTree.minHeightOfTreeSimilarToBFS(root.getLeft()));
        System.out.println("\nMinimum height of Binary Tree using BFS type algorithm: "+ binaryTree.minHeightOfTreeSimilarToBFS(root));

        System.out.println("\nDeepest node of right subtree of Binary Tree: "+ binaryTree.getDeepestNodeInBT(root.getRight()).getData());
        System.out.println("\nDeepest node of Binary Tree: "+ binaryTree.getDeepestNodeInBT(root).getData());
        System.out.println("\nDeepest node of left subtree of Binary Tree: "+ binaryTree.getDeepestNodeInBT(root.getLeft()).getData());

        System.out.println("Number of leaves : " + binaryTree.numberOfleaves(root) );
        System.out.println("Number of full nodes : " + binaryTree.numberOfFullNodes(root) );
        System.out.println("Number of half nodes : " + binaryTree.numberOfhalfNodes(root) );
        binaryTree.levelOrder(root);
        System.out.println("\nmax sum of level : " + binaryTree.findLevelWithMaxSum(root));
        System.out.println("\nsum of all elements : " + binaryTree.findSum(root));
        System.out.println("\nsum of all elements w/o recurssion : " + binaryTree.findSumwoRecurssion(root));
        System.out.println("check that path with given sum(300) exists : " + binaryTree.checkPathofGivenSum(root, 300));
        System.out.println("check that path with given sum(100) exists : " + binaryTree.checkPathofGivenSum(root, 100));

        System.out.println("all paths from root to leaf nodes :");
        binaryTree.printpaths(root);
    }
}
