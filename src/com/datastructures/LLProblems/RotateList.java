package com.datastructures.LLProblems;

public class RotateList {

    //10->20->30->40->50->60 where k=2 right rotate will be 50->60->10->20->30->40

    public static Node rightRotate(Node head, int k){

        Node temp = head;
        if(k<=0){
            return head;
        }
        int count = 0;
        while(k > 0){
            if(temp != null) {
                count++;
                temp = temp.getNext();
            }
            else {
                k = k % count; //to handle larger value > list length
                temp = head;
                continue;
            }
            k--;
        }

        Node t = head;
        while(temp.getNext() != null){
            t = t.getNext();
            temp = temp.getNext();
        }

        Node newHead = t.getNext();
        temp.setNext(head);
        t.setNext(null);

        return newHead;

    }

    //10->20->30->40->50->60 where k=2 left rotate will be 30->40->50->60->10->20
    public static Node leftRotate(Node head, int k){

        Node temp = head;
        if(k<=0){
            return head;
        }
        int count = 0;
        Node prev = null;
        while(k > 0){
            if(temp != null) {
                count++;
                prev=temp;
                temp = temp.getNext();
            }
            else {
                k = k % count; //to handle larger value > list length
                temp = head;
                continue;
            }
            k--;
        }
        Node kthNode = prev;
        Node t = head;
        while(prev.getNext() != null){
            prev = prev.getNext();
        }
        prev.setNext(head);
        Node newHead = kthNode.getNext();
        kthNode.setNext(null);

        return newHead;

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i = 0; i<6; i++){
            list.insert(new Node((i+1)*10));
        }

        System.out.println(list);
        Node newHead = rightRotate(list.getHead(),100);
        System.out.println(list.printList(newHead));

        Node newLeftRotated = leftRotate(newHead,10);
        System.out.println(list.printList(newLeftRotated));

    }
}
