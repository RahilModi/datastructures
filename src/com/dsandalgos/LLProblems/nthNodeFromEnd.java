package com.dsandalgos.LLProblems;

import java.util.Hashtable;

class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node){
            if(((Node) obj).getData() == this.getData()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if(this == null){
            return "";
        }
        StringBuilder str = new StringBuilder("[ "+ this.getData());

        if(this.getNext() != null){
            str.append("-> " + this.getNext().getData());
        }

        str.append(" ]");
        return  str.toString();
    }
}

class ListImp{

    private Node head;
    static int counter=0;

    public ListImp() {
        this.head = null;
    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public synchronized void insert(Node newNode){
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public synchronized void remove(Node node){
        if(head == null){
            System.out.println("List is empty...");
        }else{
            Node temp = head;
            Node prev = head;
            while(temp != null && !temp.equals(node)) {
                prev = temp;
                temp = temp.getNext();
            }

            if(temp == null){
                System.out.println("node is not present...");
            }else if(temp.equals(head)){
                head = temp.getNext();
            }else{
                prev.setNext(temp.getNext());
                temp.setNext(null);
            }
        }
    }

    //Main problem find nth node from the end in Linked list...
    //using two pointers...
    //time complexity = O(n)
    public synchronized Node findnthFromEnd(int nthPosFromEnd){
        if(head == null){
            System.out.println("List is empty...");
        }else {
            int posDifference = 1;
            if(nthPosFromEnd <= 0){
                nthPosFromEnd = 1;
            }
            Node temp = head;
            Node temp1 = head;

            while (posDifference < nthPosFromEnd && temp1.getNext() != null) {
                temp1 = temp1.getNext();
                posDifference++;
            }

            if(posDifference == nthPosFromEnd){

                while(temp1.getNext() != null){
                    temp = temp.getNext();
                    temp1 = temp1.getNext();
                }
                return temp;
            }else{
                System.out.println("List is smaller than "+ nthPosFromEnd +" length...");
            }
        }
        return null;
    }

    //first calculate length => position from the beginning => traverse to that position
    //time complexity O(n) + O(n) = O(n)
    public synchronized Node getnthNodeFromBack(int pos){
        int length = 0;
        if(head == null){
            return null;
        }else{
            length = 1;
            Node temp = head;
            while(temp.getNext() != null){
                length++;
                temp = temp.getNext();
            }
            int fromStart = length - pos;
            temp = head;
            if(length < pos){
                System.out.println("List is smaller in size...");
            }else {
                while (fromStart != 0) {
                    temp = temp.getNext();
                    fromStart--;
                }
                return temp;
            }
        }
        return null;
    }

    //using recursion O(n) prerecursive call and O(n) post recusive  => O(2n) ~= O(n)
    public synchronized Node getnthNodeFromBack(Node head, int pos){
        if(head != null){
            Node temp = getnthNodeFromBack(head.getNext(), pos);
            counter++;
            if(pos == counter && temp == null){
                temp = head;
                return temp;
            }else if(temp != null){
                return temp;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder("[ ");
        Node temp = getHead();
        while(temp != null){
            strBld.append(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        strBld.append(" ]");
        return strBld.toString();
    }
}

public class nthNodeFromEnd{

    public static void main(String[] args) {

        ListImp list = new ListImp();
        list.insert(new Node(11));
        list.insert(new Node(122));
        list.insert(new Node(18));
        list.insert(new Node(12));
        list.insert(new Node(14));
        list.insert(new Node(13));
        System.out.println(list);
        list.remove(new Node(11));
        System.out.println(list);
        Node find = list.findnthFromEnd(3); //indexing from 1 to n..
        if(find != null)
            System.out.println(find);
        else{
            System.out.println(list);
        }
        System.out.println(list.getnthNodeFromBack(6)); //indexing is from 1 to n
        Node temp = list.getnthNodeFromBack(list.getHead(),1);
        ListImp.counter = 0; //need to reset static variable..
        System.out.println(list.getnthNodeFromBack(list.getHead(),5));

    }
}