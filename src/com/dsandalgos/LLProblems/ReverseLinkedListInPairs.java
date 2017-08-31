package com.dsandalgos.LLProblems;

public class ReverseLinkedListInPairs {

    //using iterative method
    //current will move ahead in new list.
    //newHead will always points the first node
    public static Node reverseInPairs(Node head){
        if(head == null || head.getNext() == null){
            return head;
        }else{
            Node next = head;
            Node newHead = null;
            Node current = null;
            while(next != null && next.getNext() != null){
                Node temp = next.getNext().getNext();
                if(newHead == null){
                    newHead = next.getNext();
                    current = newHead;
                }
                current.setNext(next.getNext());
                current = current.getNext();
                current.setNext(next);
                next.setNext(null);
                current = current.getNext();
                next = temp;
            }
            if(next != null){
                current.setNext(next);
            }
            return newHead;
        }

    }

    //using recursive method
    public static Node reverseInPairsRecursive(Node head){
        if(head == null || head.getNext() == null){
            return head;
        }else{
            Node temp = head.getNext();
            head.setNext(temp.getNext());
            temp.setNext(head);
            head = temp;
            Node next = reverseInPairsRecursive(head.getNext().getNext());
            head.getNext().setNext(next);

            return head;
        }

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
        Node newHead = reverseInPairs(list.getHead());
        System.out.println(list.printList(newHead));

        Node newNode = reverseInPairsRecursive(newHead);
        System.out.println(list.printList(newNode));
    }
}
