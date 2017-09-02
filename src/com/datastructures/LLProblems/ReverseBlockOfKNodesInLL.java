package com.datastructures.LLProblems;

public class ReverseBlockOfKNodesInLL {

    //recursive solution
    public static Node reverseBlockOfNodes(Node head, int k){
        Node current = head;
        int count = k;
        Node prev=null;
        Node next=null;
        while(current!=null && count>0){
            next = current.getNext();
            current.setNext(prev);
            prev=current;
            current = next;
            count--;
        }
        if(next!=null){
            Node temp = reverseBlockOfNodes(next,k);
            head.setNext(temp);
        }
        return prev;
    }

    //iterative solution
    public static Node reverseKBlockOfNodes(Node head, int k){
        Node current = head;
        int count = k;
        Node prev = null;
        Node next = null;
        Node newHead = head;
        Node prevtail = null;
        Node prevCurrent = head;
        while(current != null){
            prev = null;
            while(current != null && count > 0){
                next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
                count--;
            }

            if(prevtail == null){
                newHead = prev;
            }else{
                prevtail.setNext(prev);
            }

            prevtail = prevCurrent;
            prevCurrent = current;
            count = k;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(new Node(1));
        list.insert(new Node(2));
        list.insert(new Node(3));
        list.insert(new Node(4));
        list.insert(new Node(5));
        list.insert(new Node(6));
        System.out.println(list);
        Node newHead = reverseBlockOfNodes(list.getHead(),5);
        System.out.println(list.printList(newHead));
        Node node1 = reverseKBlockOfNodes(newHead,2);
        System.out.println(list.printList(node1));
    }
}
