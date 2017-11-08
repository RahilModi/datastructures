package com.datastructures.Trees;

import java.util.ArrayList;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(20);
        BinaryTree binaryTree = new BinaryTree(root);
        binaryTree.getRoot().setLeft(new BinaryTreeNode(10));
        binaryTree.getRoot().getLeft().setLeft(new BinaryTreeNode(5));
        binaryTree.getRoot().getLeft().setRight(new BinaryTreeNode(13));
        binaryTree.getRoot().setRight(new BinaryTreeNode(23));
        binaryTree.getRoot().getRight().setLeft(new BinaryTreeNode(21));
        binaryTree.getRoot().getRight().setRight(new BinaryTreeNode(28));

        System.out.println("Inorder Traversal in tree: ");
        binaryTree.inOrderTraversal(binaryTree.getRoot());
        System.out.println("\n\nPreorder Traversal in tree: ");
        binaryTree.preOrderTraversal(binaryTree.getRoot());

        System.out.println("\n\nPostorder Traversal in tree: ");
        binaryTree.postOrderTraversal(binaryTree.getRoot());

        System.out.println("\n\nPreOrder without recurssion: ");
        ArrayList<Integer> preOrdered = binaryTree.preOrder(binaryTree.getRoot());
        for(Integer i : preOrdered){
            System.out.print(i.intValue());
            System.out.print(" -> ");
        }

        System.out.println("\n\nInOrder without recurssion: ");
        ArrayList<Integer> inOrdered = binaryTree.inOrder(binaryTree.getRoot());
        for(Integer i : inOrdered){
            System.out.print(i.intValue());
            System.out.print(" -> ");
        }

        System.out.println("\n\nInOrder without recurssion using stack: ");
        binaryTree.inOrderUsingStack(binaryTree.getRoot());

        System.out.println("\n\npostOrder without recurssion: ");
        ArrayList<Integer> postOrder = binaryTree.postOrder(binaryTree.getRoot());
        for(Integer i : postOrder){
            System.out.print(i.intValue());
            System.out.print(" -> ");
        }

        System.out.println("\n\npostOrder without recurssion Using two stacks: ");
        binaryTree.postOrderUsingTwoStacks(binaryTree.getRoot());

        System.out.println("\n\nlevel Order with recurssion : ");
        binaryTree.levelOrder(binaryTree.getRoot());

        System.out.println("\n\nlevel Order without recurssion : ");
        binaryTree.levelOrderUsingQueue(binaryTree.getRoot());

        System.out.println("\n\n diameter of the binary tree: "+binaryTree.diameterOfBinaryTree(root));

        System.out.println("\n\n width of the binary tree: "+binaryTree.maxWidthOfBinaryTree(root));

        int[] inOrder = new int[]{4,2,5,1,6,3};
        int[] preOrder = new int[]{1,2,4,5,3,6};

        //System.out.println("\n\n root of the constructed BT: "+binaryTree.constructBT(inOrder,preOrder,0,inOrder.length-1));
        binaryTree.levelOrder(binaryTree.constructBT(inOrder,preOrder,0,inOrder.length-1));
        System.out.println("\n\n");
        int[] in = new int[]{4,2,5,1,6,3};
        int[] post = new int[]{4,5,2,6,3,1};

        //System.out.println("\n\n root of the constructed BT: "+binaryTree.constructBT(inOrder,preOrder,0,inOrder.length-1));
        binaryTree.levelOrder(binaryTree.constructBinaryTree(in,post,0, post.length-1,0, in.length-1));

        System.out.println("\n");
        binaryTree.printAllAncestors(root,new BinaryTreeNode(13));

        System.out.println("\n");
        System.out.println("\n print in zig zag or spiral order: " );
        binaryTree.printInZigZag(root);

        BinaryTreeNode root1 = new BinaryTreeNode(1);
        root1.setRight(new BinaryTreeNode(3));
        root1.setLeft(new BinaryTreeNode(2));
        root1.getLeft().setLeft(new BinaryTreeNode(4));
        root1.getLeft().setRight(new BinaryTreeNode(5));
        root1.getRight().setLeft(new BinaryTreeNode(6));
        root1.getRight().setRight(new BinaryTreeNode(7));

        System.out.println("\n");

        binaryTree.printInZigZag(root1);

        binaryTree.verticalSum(root1);

        binaryTree.numberOfBSTs(10);

        binaryTree.generateTree(4).stream().forEach(binaryTreeNode -> {binaryTree.levelOrder(binaryTreeNode);System.out.println("");});
        char[] preOrderSeq = new char[]{'I','L','I','L','L'};
        BinaryTreeNode newRoot = binaryTree.buildBTFromPreOrder(preOrderSeq, 0);
        binaryTree.levelOrder(newRoot);


    }




}
