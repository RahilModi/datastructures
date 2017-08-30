package com.dsandalgos.LLProblems;

class LinkedListChild extends LinkedList {

    //Find the node at which two singly linked list are merging.
    //LinkedList1: Node1 -> Node2 -> Node3 -> Node4 -> NULL
    //LinkedList2: Node0 -> Node1 -> Node2 -> Node3 -> Node4 -> NULL
    // As shown above intersecting node is Node3.
    public static Node findIntersectingNode(Node head1, Node head2) {
        int lengthList1 = 0;
        int lengthList2 = 0;
        Node temp1 = head1;
        Node temp2 = head2;
        //calculating length of list1
        while (temp1 != null) {
            lengthList1++;
            temp1 = temp1.getNext();
        }
        //calculating length of list2
        while (temp2 != null) {
            lengthList2++;
            temp2 = temp2.getNext();
        }
        int diff = 0;
        //calculating difference in length
        if (lengthList1 > lengthList2) {
            temp1 = head1;
            temp2 = head2;
            diff = lengthList1 - lengthList2;
        } else {
            temp1 = head2;
            temp2 = head1;
            diff = lengthList2 - lengthList1;
        }
        //incrementing the head to difference times of larger list
        for (int i = 0; i < diff; i++) {
            temp1 = temp1.getNext();
        }
        //comparing one node from each list once match returning the node..
        while (temp1 != null && temp2 != null) {

            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
        return null;
    }
}
public class FindIntersectingNode {

    public static void main(String[] args) {
        LinkedListChild list1 = new LinkedListChild();
        list1.insert(new Node(100));
        Node node1 = new Node(123);
        Node node2 = new Node(120);
        list1.insert(node1);
        list1.insert(node2);
        System.out.println(list1);
        LinkedListChild list2 = new LinkedListChild();
        list2.insert(new Node(100));
        list2.insert(new Node(107));
        list2.insert(node1);
        System.out.println(list2);

        System.out.println(LinkedListChild.findIntersectingNode(list1.getHead(), list2.getHead()));
    }
}

