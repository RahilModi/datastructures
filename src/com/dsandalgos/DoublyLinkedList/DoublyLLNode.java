package com.dsandalgos.DoublyLinkedList;

public class DoublyLLNode {

    private int data;
    private DoublyLLNode next;
    private DoublyLLNode prev;

    public DoublyLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLLNode getNext() {
        return next;
    }

    public void setNext(DoublyLLNode next) {
        this.next = next;
    }

    public DoublyLLNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyLLNode prev) {
        this.prev = prev;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DoublyLLNode){
            if(((DoublyLLNode) obj).getData() == this.getData()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("Node value is : " + this.getData());
        if(this.getPrev() != null){
            strBuilder.append(". Prev Node value is :"+this.getPrev().getData());
        }
        if(this.getNext() != null){
            strBuilder.append(". Next node value : " +this.getNext().getData());
        }
        return strBuilder.toString();
    }
}
