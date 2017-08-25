package com.dsandalgos.DoublyLinkedList;

public class DoublyLinkedList {

    private DoublyLLNode head;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.length = 0;
    }
    public DoublyLLNode getHead() {
        return head;
    }

    public void setHead(DoublyLLNode head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public synchronized void insertNodeAtBeginning(DoublyLLNode node){
        if(head == null){
            head = node;
        }else{
            DoublyLLNode temp = head;
            temp.setPrev(node);
            node.setNext(temp);
            head = node;
        }
        length++;
    }

    public synchronized void insertNodeAtBeginning(int data){
        DoublyLLNode newNode = new DoublyLLNode(data);
        insertNodeAtBeginning(newNode);
    }

    public synchronized void insertAtTheEnd(DoublyLLNode node){
        if(head == null){
            head = node;
        }else{
            DoublyLLNode temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            node.setPrev(temp);
            temp.setNext(node);
        }
        length++;
    }

    public synchronized void insertAtTheEnd(int data){
        DoublyLLNode newNode = new DoublyLLNode(data);
        insertAtTheEnd(newNode);
    }

    public synchronized void insert(DoublyLLNode node){
        insertAtTheEnd(node);
    }
    public synchronized void insert(int data){
        insertAtTheEnd(new DoublyLLNode(data));
    }
    public synchronized void insertAtGivenPosition(DoublyLLNode node,int pos){
        if(pos == 0 || pos < 0){
            if(pos <  0){
                System.out.println("Position should be greater or equal to zero...Node has been inserted at the beginning...");
            }
            insertNodeAtBeginning(node);

        }else if(pos >= length){
            if(pos > length){
                System.out.println("Position should be equal to length of the list or less than it...Node has been added at the end...");
            }
            insertAtTheEnd(node);
        }else{
            if(head == null){
                head = node;
            }else{
                DoublyLLNode temp = head;
                int position = 0;
                while(position < pos){
                    temp = temp.getNext();
                    position++;
                }
                temp.getPrev().setNext(node);
                node.setPrev(temp.getPrev());
                temp.setPrev(node);
                node.setNext(temp);
            }
            length++;
        }
    }
    public synchronized void insertAtGivenPosition(int data, int pos){
        DoublyLLNode newNode = new DoublyLLNode(data);
        insertAtGivenPosition(newNode,pos);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("[");
        DoublyLLNode temp = head;
        while(temp != null){
            strBuilder.append(temp.getData() + ",");
            temp = temp.getNext();
        }
        strBuilder.append("] List size is : " + getLength());
        return  strBuilder.toString();
    }

    public String reverseString(){
        StringBuilder strBuilder = new StringBuilder("[");
        DoublyLLNode temp = getNode(length -1);
        while(temp != null){
            strBuilder.append(temp.getData() + ",");
            temp = temp.getPrev();
        }
        strBuilder.append("] List size is : " + getLength());
        return  strBuilder.toString();
    }

    public synchronized int getNodePosition(DoublyLLNode node){
        DoublyLLNode temp = head;
        int pos = 0;
        while(temp != null){
            if(temp.getData() == node.getData()){
                return pos;
            }
            pos++;
            temp = temp.getNext();
        }
        System.out.println("Node not fund in the list..");
        return Integer.MIN_VALUE;
    }

    public synchronized int getNodePosition(int data) {
        DoublyLLNode temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.getData() == data) {
                return pos;
            }
            pos++;
            temp = temp.getNext();
        }
        System.out.println("Node with : " + data + ", not fund in the list..");
        return Integer.MIN_VALUE;
    }

    public synchronized DoublyLLNode getNode(int pos){
        DoublyLLNode temp = head;
        if(head == null){
            System.out.println("List is empty...Returning null object");
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

    public synchronized DoublyLLNode getNodeFromTheLast(int pos){
        DoublyLLNode temp = head;

        if(head == null){
            System.out.println("List is empty...Returning null object..");
            return null;
        }

        if(pos < 0){
            System.out.println("return first node if requested positiion is less than 0...");
            pos = 0;
        }
        if(pos >= length ){
            System.out.println("Return last node...if requested position is greater than the size of the list...");
            pos = length - 1;
        }

        return getNode(length - 1 - pos);
    }

    public synchronized void removeNode(int data){
        DoublyLLNode temp = head;
        if(temp == null){
            System.out.println("List is empty...");
        }else{
            while(temp != null){
                if(temp.getData() == data){
                    if(temp.equals(head)){
                        DoublyLLNode _temp = head;
                        head = _temp.getNext();
                        head.setPrev(null);
                        _temp.setNext(null);
                    }else{
                        temp.getPrev().setNext(temp.getNext());
                        if(temp.getNext() != null) {
                            temp.getNext().setPrev(temp.getPrev());
                        }
                        temp.setNext(null);
                        temp.setPrev(null);
                    }
                    length--;
                }
                temp = temp.getNext();
            }
        }
    }

    public synchronized void removeMatchedNode(DoublyLLNode node){
        DoublyLLNode temp = head;
        if(temp == null){
            System.out.println("List is empty...");
        }else{
            while(temp != null){
                if(temp.equals(node)){
                    if(temp.equals(head)){
                        DoublyLLNode _temp = head;
                        head = _temp.getNext();
                        head.setPrev(null);
                        _temp.setNext(null);
                    }else{
                        temp.getPrev().setNext(temp.getNext());
                        if(temp.getNext() != null) {
                            temp.getNext().setPrev(temp.getPrev());
                        }
                        temp.setNext(null);
                        temp.setPrev(null);
                    }
                    length--;
                }
                temp = temp.getNext();
            }
        }
    }

    public synchronized void removeNodeAtGivenPosition(int pos){
        if(head == null){
            System.out.println("List is empty...Returning null object");
            return;
        }
        DoublyLLNode temp = head;
        if(pos < 0){
            System.out.println("returning first node if requested positiion is less than 0...");
            pos = 0;
        }
        else if(pos >= length){
            System.out.println("Returning last node...if requested position is greater than the size of the list...");
            pos = length - 1;
        }
        if(pos == 0){
            head = temp.getNext();
            temp.setNext(null);
            if(head != null) {
                head.setPrev(null);
            }
            length--;
        }else {
            int position = 1;
            temp = head.getNext();
            while (pos > position) {
                temp = temp.getNext();
                position++;
            }
            temp.getPrev().setNext(temp.getNext());
            if (temp.getNext() != null) {
                temp.getNext().setPrev(temp.getPrev());
            }
            temp.setPrev(null);
            temp.setNext(null);
            length--;
        }
    }

    public synchronized void removeFromTheBeginning(){
        if(head == null){
            System.out.println("List is empty...");
        }else{
            DoublyLLNode temp = head;
            head = temp.getNext();
            temp.setNext(null);
            if(head != null){
                head.setPrev(null);
            }
            length--;
        }
    }

    public synchronized void removeFromTheEnd(){
        if(head == null){
            System.out.println("List is empty...");
        }else{
            DoublyLLNode temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            if(temp.equals(head)){
                head = null;
            }else {
                temp.getPrev().setNext(null);
                temp.setPrev(null);
            }
            length--;

        }
    }

    public void clearList(){
        head = null;
        length = 0;
    }
}

