package com.dsandalgos.LinkedList;

public class LinkedList {

    private int length;

    private LinkedListNode head = null;

    public LinkedList(){
        length = 0;
    }

    public LinkedListNode getHead() {
        return head;
    }

    public void setHead(LinkedListNode head) {
        this.head = head;
    }

    //Insert the node at the beginning
    public synchronized void insertAtBeginning(LinkedListNode node){

        if(isListEmpty()){
            head = node;
        }else{
            node.setNext(head);
            head = node;
            length++;
        }

    }

    //Insert the node at the end
    public synchronized void insertAtEnd(LinkedListNode node){

        if(isListEmpty()){
            head = node;
        }else{
            LinkedListNode temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        length++;
    }

    //Insert the node at the end
    public synchronized void insert(LinkedListNode node){
        insertAtEnd(node);
    }

    //Insert the node at given position
    public synchronized void insertAtPosition(LinkedListNode node, int position){
        if(position == 0 || position < 0){
            insertAtBeginning(node);  //position = 0 indicates insert at the beginning
        }else{
            if(position > length){
                position = length;
            }
            int pos = 1;
            LinkedListNode temp = head;
            while ( position > pos ){
               temp = temp.getNext();
               pos++;
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
            length++;
        }
    }

    //create node based on the data and insert at the given position
    public synchronized void insertAtPosition(int data, int position){
        if(position == 0 || position < 0){
            if(isListEmpty()){
                setHead(new LinkedListNode(data));
                length++;
            }else{
                LinkedListNode node = new LinkedListNode(data);
                node.setNext(head);
                setHead(node);
                length++;
            }
        }else{
            if(position > length){
                position = length;
            }
            int pos = 1;
            LinkedListNode temp = head;
            while ( position > pos ){
                temp = temp.getNext();
                pos++;
            }
            LinkedListNode node = new LinkedListNode(data);
            node.setNext(temp.getNext());
            temp.setNext(node);
            length++;
        }
    }

    //Display the linked list in the string
    @Override
    public String toString(){
        StringBuilder outputString = new StringBuilder();
        outputString.append("[");
        LinkedListNode temp = head;
        while(temp != null){
            outputString.append(temp.getData());
            outputString.append(" -> ");
            temp = temp.getNext();
        }
        outputString.append("]");

        return outputString.toString();
    }

    //remove node based on the given node's data
    public synchronized void removeMatched(LinkedListNode node){
        if(isListEmpty()){
            System.out.println("Sorry...List is empty");
        }else if(head.getData() == node.getData()){
            LinkedListNode temp = head;
            setHead(temp.getNext());
            temp.setNext(null);
            length--;
        }else {
            LinkedListNode temp = head.getNext();
            LinkedListNode prev = head.getNext();
            while(temp != null && temp.getData() != node.getData()){
                prev = temp;
                temp = temp.getNext();
            }
            if(temp != null) {
                prev.setNext(temp.getNext());
                temp.setNext(null);
                length--;
            }else{
                System.out.println("Node of value : " + node.getData() + " is not in the list");
                System.out.println(toString()); //print the list
            }
        }
    }

    //overloaded method of remove node by given data
    public synchronized void removeMatched(int data){
        if(isListEmpty()){
            System.out.println("Sorry...List is empty");
        }else if(head.getData() == data){
            LinkedListNode temp = head;
            head = temp.getNext();
            temp.setNext(null);
            length--;
        }else {
            LinkedListNode temp = head.getNext();
            LinkedListNode prev = head.getNext();
            while(temp != null && temp.getData() != data){
                prev = temp;
                temp = temp.getNext();
            }
            if(temp != null) {
                prev.setNext(temp.getNext());
                temp.setNext(null);
                length--;
            }else{
                System.out.println("Node of value : " + data + " is not in the list");
                System.out.println(toString());
            }
        }
    }

    //remove from the front
    public synchronized  void removeFromTheBeginning(){
        if(isListEmpty()){
            System.out.println("Sorry...List is empty");
        }else{
            LinkedListNode temp = head;
            head = temp.getNext();
            temp.setNext(null);
            length--;
        }
    }

    //remove from the back
    public synchronized void removeFromTheEnd(){
        if(isListEmpty()){
            System.out.println("Sorry...list is empty");
        }else if(head.getNext() == null){
            head = null;
            length--;
        }else{
            LinkedListNode temp = head.getNext();
            LinkedListNode prev = head.getNext();
            while(temp.getNext() != null){
                prev = temp;
                temp = temp.getNext();
            }
            prev.setNext(null);
            length--;
        }
    }

    //remove by position
    public synchronized void removeByPosition(int position){
        if(isListEmpty()){
            System.out.println("Sorry...list is empty");
        }else if(position < 0){
            System.out.println("Position should be greater than and equal to 0");
        }else if(position >= length){
            System.out.println("Position should be less than the size of the list");
        }else if(position == 0){
            head = head.getNext();
            length--;
        }else{
            LinkedListNode temp = head.getNext();
            LinkedListNode prev = head;
            int pos = 1;
            while(position > pos){
                prev = temp;
                temp = temp.getNext();
                pos++;
            }
            prev.setNext(temp.getNext());
            length--;
        }
    }

    //get the node position in the list, zero based indexing
    public synchronized int getNodePosition(LinkedListNode node){
        LinkedListNode temp = head;
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

    //get the node position in the list by the data, zero based indexing
    public synchronized int getNodePosition(int data){
        LinkedListNode temp = head;
        int position = 0;
        while(temp != null && temp.getData() != data){
            temp = temp.getNext();
            position++;
        }
        if(temp != null){
            return position;
        }
        return Integer.MIN_VALUE; //not found case
    }

    //get the length of the list
    public synchronized int getSize(){
        return length;
    }

    //clear the list
    public synchronized void clearList(){
        head = null;
        length = 0;
    }

    //overrided method of object class to compare two list based on the data
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkedList) {
            if (((LinkedList) obj).getSize() == this.getSize()) {
                LinkedListNode temp1 = ((LinkedList) obj).head;
                LinkedListNode temp2 = this.getHead();
                while (temp1 != null && temp2 != null && temp1.equals(temp2)) {
                    temp1 = temp1.getNext();
                    temp2 = temp2.getNext();
                }
                if (temp1 == null && temp2 == null) {
                    System.out.println("lists are equal");
                    return true;
                } else {
                    System.out.println("lists are different");
                }
            } else {
                System.out.println("Size of both list is not the same...:(");
            }
        }
        return false;
    }

    //returns the node based on the position
    public LinkedListNode getNodeAtPos(int pos){
        LinkedListNode temp = head;
        if(isListEmpty()){
            System.out.println("List is empty...Returning null object..");
            return null;
        }

        if(pos < 0){
            System.out.println("return first node if requested positiion is less than 0...");
            pos = 0;
        }
        if(pos >= length){
            System.out.println("Return last node...if requested position is greater than the size of the list...");
            pos = length - 1;

        }

        int position = 0;
        while(position < pos){
            temp = temp.getNext();
            position++;
        }
        return temp;
    }

//    public synchronized void printList(LinkedListNode node){
//        LinkedListNode temp = node;
//        StringBuilder str = new StringBuilder("[");
//        while(temp != null){
//            str.append(temp.getData());
//            temp = temp.getNext();
//        }
//        str.append("]");
//        System.out.println(str.toString());
//    }

    //method to check list is empty or not
    public boolean isListEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }
}
