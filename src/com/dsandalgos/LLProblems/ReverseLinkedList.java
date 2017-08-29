package com.dsandalgos.LLProblems;

import java.util.Arrays;
import java.util.List;

class ReverseLinkedListImp extends LinkedList{

    //more efficient reverse method Time complexity O(n) and space complexity O(1)
    public synchronized void reverseLinkedList(){
        Node temp = getHead();
        if(temp == null){
            System.out.println("List is empty...");
        }else{
            Node prev = null;
            while(temp.getNext() != null){
                Node next = temp;
                temp = temp.getNext();
                next.setNext(prev);
                prev = next;
            }
            if(!temp.equals(getHead())) {
                temp.setNext(prev);
                setHead(temp);
            }
        }
    }

    //reverse using recursion time complexity = O(n) and Space complexity = O(n) recursive stack..
    //if list is already empty return null and newhead will also have null;
    public synchronized Node reverseByrecursion(Node head,Node[] newhead){
        if(head != null && head.getNext() != null){
            Node prev = reverseByrecursion(head.getNext(),newhead);
            if(head == getHead()){
                head.setNext(null);
                prev.setNext(head);
                setHead(newhead[0]);
                return getHead();
            }else {
                prev.setNext(head);
                head.setNext(null);
                return head;
            }
        }else{
            newhead[0] = head;
            return head;
        }
    }

}

public class ReverseLinkedList {
    public static void main(String[] args) {

        ReverseLinkedListImp linkedList = new ReverseLinkedListImp();
        linkedList.insert(new Node(100));
        linkedList.insertAtBeginning(new Node(102));
        linkedList.insertAtEnd(new Node(105));
        linkedList.insertAtPosition(new Node(1),1);
        System.out.println(linkedList);
        linkedList.insert(new Node(120));
        System.out.println(linkedList);
        linkedList.remove(new Node(100));
        linkedList.removeFromTheBeginning();
        System.out.println(linkedList);
        linkedList.reverseLinkedList();

        System.out.println(linkedList);
        linkedList.insert(new Node(1201));
        linkedList.insertAtEnd(new Node(1430));
        Node[] heads = new Node[1];
        System.out.println(linkedList);
        Node newHead = linkedList.reverseByrecursion(linkedList.getHead(),heads); //heads and newHead will have new head
        System.out.println(linkedList);
        linkedList.removeFromTheBeginning();
        System.out.println(linkedList);
        linkedList.reverseByrecursion(linkedList.getHead(),heads);
        System.out.println(linkedList);

    }

}

