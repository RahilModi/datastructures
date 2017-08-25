package com.dsandalgos.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedListNode node = new LinkedListNode(100);
        list.insert(node);
        list.insertAtBeginning(new LinkedListNode(110));
        list.insertAtPosition(112,2);
        list.insertAtPosition(113,2);
        list.insertAtPosition(114,4);

        System.out.println("LinkedList : " + list);
        list.removeByPosition(2);

        System.out.println("LinkedList : " + list);
        list.removeFromTheBeginning();

        System.out.println("LinkedList : " + list);
        list.removeFromTheEnd();

        System.out.println("LinkedList : " + list);
        list.removeMatched(node);

        System.out.println("LinkedList : " + list);
        list.removeByPosition(2);
        list.removeByPosition(0);

        System.out.println("LinkedList : " + list);
        list.insertAtPosition(101,0);

        list.removeMatched(new LinkedListNode(100));

        if(Integer.MIN_VALUE == list.getNodePosition(node)){
            System.out.println("Node of value : " + node.getData() + "is not in the list.");
            System.out.println("LinkedList : " + list);
        }

        System.out.println("Node position " + list.getNodePosition(101));

        System.out.println("List size is : " + list.getSize());
    }
}
