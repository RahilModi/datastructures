package com.dsandalgos.LLProblems;

import com.dsandalgos.LinkedList.LinkedListNode;

public class LinkedList {
    private Node head;

    public LinkedList() {
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

    //Insert the node at the beginning
    public synchronized void insertAtBeginning(Node node){

        if(isListEmpty()){
            head = node;
        }else{
            node.setNext(head);
            head = node;
        }

    }

    //Insert the node at the end
    public synchronized void insertAtEnd(Node node){

        if(isListEmpty()){
            head = node;
        }else{
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }


    //Insert the node at given position
    public synchronized void insertAtPosition(Node node, int position){
        if(position == 0 || position < 0){
            insertAtBeginning(node);  //position = 0 indicates insert at the beginning
        }else{
            int pos = 1;
            Node temp = head;
            if(position >= length()){
                insert(node);
                return;
            }
            while ( position > pos ){
                temp = temp.getNext();
                pos++;
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
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

    public synchronized int getNodePosition(Node node){
        Node temp = head;
        int position = 0;
        while(temp != null && !temp.equals(node)){
            temp = temp.getNext();
            position++;
        }
        if(temp != null){
            return position;
        }else{
            System.out.println("Node of value : " + node.getData() + " is not in the list");
        }
        return Integer.MIN_VALUE; //not found case
    }


    //remove from the front
    public synchronized  void removeFromTheBeginning(){
        if(isListEmpty()){
            System.out.println("Sorry...List is empty");
        }else{
            Node temp = head;
            head = temp.getNext();
            temp.setNext(null);
        }
    }

    //remove from the back
    public synchronized void removeFromTheEnd(){
        if(isListEmpty()){
            System.out.println("Sorry...list is empty");
        }else if(head.getNext() == null){
            head = null;
        }else{
            Node temp = head.getNext();
            Node prev = head.getNext();
            while(temp.getNext() != null){
                prev = temp;
                temp = temp.getNext();
            }
            prev.setNext(null);
        }
    }

    //remove by position
    public synchronized void removeByPosition(int position){
        if(isListEmpty()){
            System.out.println("Sorry...list is empty");
        }else if(position < 0){
            System.out.println("Position should be greater than and equal to 0");
        }else if(position >= length()){
            System.out.println("Position should be less than the size of the list");
        }else if(position == 0){
            head = head.getNext();
        }else{
            Node temp = head.getNext();
            Node prev = head;
            int pos = 1;
            while(position > pos){
                prev = temp;
                temp = temp.getNext();
                pos++;
            }
            prev.setNext(temp.getNext());
        }
    }

    public boolean isListEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }

    public synchronized int length(){
        int length = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.getNext();
            length++;
        }
        return length;
    }

    public synchronized Node middleElementOftheList(){
        if(head == null){
            return null;
        }else{
            Node slwPtr = head;
            Node fastPtr = head;
            while(fastPtr != null){
                fastPtr = fastPtr.getNext();
                if(fastPtr != null){
                    slwPtr = slwPtr.getNext();
                    fastPtr = fastPtr.getNext();
                }
            }
            return slwPtr;
        }
    }

    public void printListInReverse(Node head){
        if(head == null){
            return;
        }
        printListInReverse(head.getNext());
        System.out.println(head.getData());
    }

}
