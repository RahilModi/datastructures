package com.datastructures.LLProblems;


//For even number of items middle element would be [n/2]
public class MiddleElementOfLinkedList {
    public static void main(String[] args) {
        LinkedListChild list = new LinkedListChild();
        list.insert(new Node(100));
        list.insertAtBeginning(new Node(1002));
        list.insertAtPosition(new Node(1223),3);
        Node node1 = new Node(123);
        Node node2 = new Node(120);
        list.insert(node1);
        list.insert(node2);
        System.out.println(list);
        list.remove(new Node(1223));
        list.insert(new Node(123));
        System.out.println(list);
        System.out.println(list.middleElementOftheList());
    }
}
