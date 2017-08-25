package com.dsandalgos.CircularLinkedList;

public class CircularLL {
    private int length;
    private CircularListNode tail;

    public CircularLL() {
        this.length = 0;
        this.tail = null;
    }

    public CircularListNode getTail() {
        return tail;
    }

    public void setTail(CircularListNode tail) {
        this.tail = tail;
    }

    public synchronized void insert(CircularListNode node){
        if(tail == null){
            tail = node;
            node.setNext(tail);
            length++;
        }else{
            CircularListNode temp = tail;
            while(temp.getNext() != tail){
                temp = temp.getNext();
            }
            temp.setNext(node);
            node.setNext(tail);
            length++;
        }
    }

    public synchronized void insertAtBeginning(CircularListNode node){
        if(tail == null){
            tail = node;
            node.setNext(tail);
            length++;
        }else{

            CircularListNode temp = tail;
            while(temp.getNext() != tail){
                temp = temp.getNext();
            }
            temp.setNext(node);
            node.setNext(tail);
            tail=node;
            length++;
        }
    }

    public synchronized int calLength(){
        CircularListNode temp = tail;
        int length = 0;
        if(tail == null){
            return length;
        }
        length = 1;
        temp = temp.getNext();
        while(!temp.equals(tail)){
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    @Override
    public String toString() {
        CircularListNode temp = tail;
        StringBuilder strBld = new StringBuilder("[");

        while(temp != null && temp.getNext() != tail){
            strBld.append(temp);
            temp = temp.getNext();
        }
        if(temp !=null) {
            strBld.append(temp + "]");
        }else{
            strBld.append("]");
        }
        return strBld.toString();
    }

    public synchronized void insertAtGivenPosition(CircularListNode node,int pos){
        if(tail == null || pos < 0 || pos == 0){
            insertAtBeginning(node);
        }else if(pos >= calLength()){
            insert(node);
        }else{
            int position = 1;
            CircularListNode temp = tail;
            while(position < pos){
                temp = temp.getNext();
                position++;
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
            length++;
        }
    }

    public synchronized int getNodePosition(CircularListNode node){
        if(tail == null){
            System.out.println("List is empty...");
        }else{
            CircularListNode temp = tail;
            int position = 0;
            while(temp.getNext() != tail){
                if(temp.equals(node)){
                    return position;
                }
                position++;
                temp = temp.getNext();
            }
        }
        return Integer.MIN_VALUE;
    }

    public synchronized void removeNodeAtGivenPos(int pos){
        CircularListNode temp = tail;
        CircularListNode prev = temp;
        int position = 0;
        if(tail == null){
            System.out.println("List is empty...");
            return;
        }
        if(pos == 0 | pos < 0){
            if(temp.equals(temp.getNext())){
                tail = null;
            }else {
                temp = temp.getNext();
                while (!temp.equals(tail)) {
                    prev = temp;
                    temp = temp.getNext();
                }
                prev.setNext(temp.getNext());
                if (prev.equals(prev.getNext())) {
                    tail = prev;
                }
                else{
                    tail = temp.getNext();
                }
            }
            length--;
        }else if(pos >= calLength()){
            System.out.println("Invalid Lenghth...List size is : "+calLength());
        }
        else {
            while (pos > position) {
                prev = temp;
                temp = temp.getNext();
                position++;
            }
            prev.setNext(temp.getNext());
            temp.setNext(null);
            length--;
        }
    }

    public synchronized void removeMatchedNode(CircularListNode node){
        CircularListNode temp = tail;
        CircularListNode prev = tail;
        if(tail == null){
            System.out.println("List is empty...");
        }else if(temp.equals(node)){
            temp = temp.getNext();
            while(temp != tail){
                prev = temp;
                temp = temp.getNext();
            }
            if(calLength() == 1){
                tail = null;
            }else {
                prev.setNext(temp.getNext());
                tail = temp.getNext();
                temp.setNext(null);
            }
            length--;
        }else{
            prev = temp;
            temp = temp.getNext();
            while(temp != tail && !temp.equals(node)){
                prev = temp;
                temp = temp.getNext();
            }
            if(!temp.equals(tail)) {
                prev.setNext(temp.getNext());
                temp.setNext(null);
                length--;
            }else{
                System.out.println("List has not given node...");
            }
        }
    }

    public synchronized void clearList(){
        tail = null;
        length = 0;
    }

    public synchronized CircularListNode getNode(int pos){
        if(tail == null){
            System.out.println("list is empty...Returning null object...");
            return null;
        }else if(pos >= calLength()){
            System.out.println("List is of size : " + calLength());
            return null;
        }else{
            CircularListNode temp = tail;
            int position = 0;
            while(pos > position){
                temp = temp.getNext();
                position++;
            }
            return temp;
        }
    }


}
