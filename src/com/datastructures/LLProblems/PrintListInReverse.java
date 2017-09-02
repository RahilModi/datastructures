package com.datastructures.LLProblems;

public class PrintListInReverse  {
    public static void printListInReverse(Node head){
        if(head == null){
            return;
        }
        printListInReverse(head.getNext());
        System.out.println(head.getData());
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(new Node(100));
        list.insertAtBeginning(new Node(1002));
        list.insertAtPosition(new Node(1223),3);
        Node node1 = new Node(123);
        Node node2 = new Node(120);
        list.insert(node1);
        list.insert(node2);
        System.out.println(list);
        printListInReverse(list.getHead());
    }

}
