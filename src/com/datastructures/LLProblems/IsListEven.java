package com.datastructures.LLProblems;

public class IsListEven {
    //use 2x pointers => at the end if 2x is null means length is even otherwise it will point to last node Complexity O(n/2)~=O(n)
    public static int findListIsEven(Node head){
        Node temp = head;
        while(temp != null && temp.getNext()!= null){
            temp = temp.getNext().getNext();
        }
        if(temp == null){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(new Node(100));
        list.insertAtBeginning(new Node(1002));
        //list.insertAtPosition(new Node(1223),3);
        Node node1 = new Node(123);
        Node node2 = new Node(120);
        list.insert(node1);
        list.insert(node2);
        System.out.println(list);
        if(findListIsEven(list.getHead()) == 0){
            System.out.println(list + " is even");
        }else{
            System.out.println(list + " is odd");
        };
    }
}
