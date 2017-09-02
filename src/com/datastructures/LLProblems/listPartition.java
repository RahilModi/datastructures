package com.datastructures.LLProblems;

public class listPartition {

    //keep node which's value is less than k into one partition and keep others are in other.
    //also order should be preserve.
    // 1->2->5->3->4->6 , k=4 => 1->2->3->5->4->6
    public static Node partitionBasedOnTheKey(Node head,int k){
        Node temp = head;
        Node pivot = null;
        Node root = null;
        Node rootHead = null;
        Node current = null;
        Node next = null;
        while(temp != null){
            next = temp.getNext();
            if(temp.getData() < k){
                if(pivot == null){
                    pivot = temp;
                    pivot.setNext(null);
                    current = pivot;
                }else{

                    current.setNext(temp);
                    temp.setNext(null);
                    current = current.getNext();
                }
            }else{
                if(rootHead == null){

                    rootHead = temp;
                    root = rootHead;
                }else{
                    rootHead.setNext(temp);
                    temp.setNext(null);
                    rootHead = rootHead.getNext();
                }
            }
            temp = next;
        }
        if(current != null)
            current.setNext(root);
        else{
            pivot  = root;
        }
        return pivot;

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(new Node(5));
        list.insert(new Node(2));
        list.insert(new Node(3));
        list.insert(new Node(5));
        list.insert(new Node(1));
        list.insert(new Node(6));

        System.out.println(list);
        Node newNode = partitionBasedOnTheKey(list.getHead(),2);
        System.out.println(list.printList(newNode));
    }
}
