package com.datastructures.DoublyLinkedList;

public class DoublyLLTest {
    public static void main(String[] args) {
        DoublyLinkedList doublyLL = new DoublyLinkedList();
        DoublyLLNode node = new DoublyLLNode(100);
        doublyLL.insertNodeAtBeginning(node);
        doublyLL.insertNodeAtBeginning(101);
        System.out.println(doublyLL);
        System.out.println(doublyLL.reverseString());
        doublyLL.insert(102);
        doublyLL.insertAtGivenPosition(111,0);
        System.out.println(doublyLL);
        doublyLL.insertAtGivenPosition(new DoublyLLNode(112),6);
        System.out.println(doublyLL);
        System.out.println("List in reverse order : " + doublyLL.reverseString());
        System.out.println("Node position of 112 is : "+ doublyLL.getNodePosition(112));
        System.out.println(doublyLL.getNode(2));
        System.out.println(doublyLL.getNodeFromTheLast(3));
        doublyLL.removeNode(101);
        System.out.println(doublyLL);
        System.out.println("List in reverse order : " + doublyLL.reverseString());
        doublyLL.removeNode(112);
        System.out.println(doublyLL);
        System.out.println("List in reverse order : " + doublyLL.reverseString());
        doublyLL.removeMatchedNode(node);
        System.out.println(doublyLL);
        System.out.println("List in reverse order : " + doublyLL.reverseString());
        doublyLL.removeNode(111);
        System.out.println(doublyLL);
        System.out.println("List in reverse order : " + doublyLL.reverseString());
        doublyLL.insertAtGivenPosition(112,0);
        System.out.println(doublyLL);
        System.out.println("List in reverse order : " + doublyLL.reverseString());
        doublyLL.insertAtGivenPosition(1223,1);

        System.out.println(doublyLL.getHead());
        System.out.println(doublyLL);
        System.out.println(doublyLL.reverseString());

        doublyLL.removeNodeAtGivenPosition(0);
        doublyLL.removeNodeAtGivenPosition(2);
        System.out.println(doublyLL);
        System.out.println(doublyLL.getHead());
        doublyLL.insert(112);
        doublyLL.insertNodeAtBeginning(new DoublyLLNode(120));
        System.out.println(doublyLL);
        doublyLL.removeFromTheBeginning();
        doublyLL.removeFromTheEnd();
        doublyLL.removeFromTheEnd();
        System.out.println(doublyLL);
    }
}
