package com.dsandalgos.CircularLinkedList;

public class CircularLLTest {
    public static void main(String[] args) {
        CircularListNode node = new CircularListNode(100);
        CircularLL CircularList = new CircularLL();
        CircularList.insert(node);
        CircularList.insert(new CircularListNode(1122));
        System.out.println(CircularList);
        CircularListNode node1 = new CircularListNode(12);
        CircularList.insert(node1);

        CircularList.insert(new CircularListNode(2000)); //working bcz of not checking at compile time..But generics works at compile time
        CircularList.insertAtBeginning(new CircularListNode(1500)); //this steps will be performed at compile time
        System.out.println(CircularList);

        CircularList.insertAtGivenPosition(new CircularListNode(999), 0);
        CircularList.insertAtGivenPosition(new CircularListNode(900), 7);
        CircularList.insertAtGivenPosition(new CircularListNode(9939), 6);

        System.out.println(CircularList);
        System.out.println(CircularList.getNodePosition(new CircularListNode(100)));

        CircularList.removeMatchedNode(new CircularListNode(100));
        CircularList.removeMatchedNode(new CircularListNode(1440));
        System.out.println(CircularList);


        CircularList.removeMatchedNode(new CircularListNode(999));
        System.out.println(CircularList);

        CircularList.removeMatchedNode(new CircularListNode(12));
        System.out.println(CircularList);

        CircularList.removeMatchedNode(new CircularListNode(112));
        System.out.println(CircularList);
        CircularList.removeMatchedNode(new CircularListNode(1122));
        CircularList.removeMatchedNode(new CircularListNode(2000));
        CircularList.removeMatchedNode(new CircularListNode(9939));
        CircularList.removeMatchedNode(new CircularListNode(1500));
        CircularList.removeMatchedNode(new CircularListNode(900));
        System.out.println(CircularList);
        CircularList.insertAtGivenPosition(new CircularListNode(1000),0);
        System.out.println(CircularList);
        CircularList.insertAtGivenPosition(new CircularListNode(102),3);
        System.out.println(CircularList);
        CircularList.insertAtGivenPosition(new CircularListNode(1440),1);
        System.out.println(CircularList);
        CircularList.removeMatchedNode(new CircularListNode(1000));
        System.out.println(CircularList);
        CircularList.removeNodeAtGivenPos(1);
        CircularList.removeNodeAtGivenPos(0);
        System.out.println(CircularList);
        CircularList.insert(new CircularListNode(1002));
        CircularList.insert(new CircularListNode(1003));
        CircularList.insertAtGivenPosition(new CircularListNode(1004),1);
        System.out.println(CircularList);
        System.out.println("List Size : "+ CircularList.calLength());
        System.out.println(CircularList.getNode(0));
        CircularList.removeNodeAtGivenPos(0);
        CircularList.insert(new CircularListNode(1005));
        System.out.println(CircularList);
        CircularList.insert(new CircularListNode(10));
        CircularList.insert(new CircularListNode(103));
        CircularList.insert(new CircularListNode(705));
        CircularList.insert(new CircularListNode(500));
        CircularLL newList1 = new CircularLL();
        CircularLL newList2 = new CircularLL();
        System.out.println(CircularList);
        CircularList.splitIntoTwoCircularList(newList1, newList2);
        System.out.println(newList1);
        System.out.println(newList2);

    }
}
