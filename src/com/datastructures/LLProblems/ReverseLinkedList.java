package com.datastructures.LLProblems;

class ReverseLinkedListImp extends LinkedList{

    //more efficient reverse method Time complexity O(n) and space complexity O(1)
    public synchronized void reverseLinkedList(){
        Node temp = getHead();
        if(temp == null){
            System.out.println("List is empty...");
        }else{
            Node prev = null;
            Node next = null;
            while(temp.getNext() != null){
                next = temp;
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
    public synchronized Node reverseByrecursion(Node node){
        if(node != null && node.getNext() != null){
            Node next = node.getNext();
            node.setNext(null);
            Node rest = reverseByrecursion(next);
            next.setNext(node);
            return rest;
        }else{
            return node;
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
        Node newHead = linkedList.reverseByrecursion(linkedList.getHead()); //heads and newHead will have new head
        linkedList.setHead(newHead);
        System.out.println(linkedList);
        linkedList.removeFromTheBeginning();
        System.out.println(linkedList);
        newHead = linkedList.reverseByrecursion(linkedList.getHead());
        linkedList.setHead(newHead);
        System.out.println(linkedList);

    }

}

