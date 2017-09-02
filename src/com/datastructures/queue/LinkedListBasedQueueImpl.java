package com.datastructures.queue;

class Node{
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

    public Node(int data) {
    this.data = data;
    this.next = null;
    }

    private int data;
    private Node next;

}

public class LinkedListBasedQueueImpl {


    protected int length;
    protected Node front,rear;

    LinkedListBasedQueueImpl(){
        this.front = null;
        this.rear = null;
        length = 0;
    }

    public boolean isEmpty(){
        return (length<=0);
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            front = newNode;
        }else{
            rear.setNext(newNode);
        }
        rear = newNode;
        length++;
    }

    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty..");
        }
        Node temp = this.front;
        return temp.getData();
    }

    public Node dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty..");
        }
        Node temp = this.front;
        front = front.getNext();
        length--;
        if(isEmpty()){
            rear = null;
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[ ");
        Node temp = this.front;
        while(temp != null){
            str.append(temp.getData());
            str.append(" | ");
            temp = temp.getNext();
        }
        str.append(" ]");
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedListBasedQueueImpl llQueue = new LinkedListBasedQueueImpl();
        llQueue.enqueue(1);
        llQueue.enqueue(22);
        llQueue.enqueue(88);
        llQueue.enqueue(2);
        llQueue.enqueue(21);
        System.out.println(llQueue);
        try{
            System.out.println(llQueue.peek());
            llQueue.dequeue();
            System.out.println(llQueue);
            llQueue.dequeue();
            System.out.println(llQueue);
            llQueue.dequeue();
            System.out.println(llQueue);
            llQueue.dequeue();
            System.out.println(llQueue);
            llQueue.enqueue(203);
            System.out.println(llQueue);
            llQueue.dequeue();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}