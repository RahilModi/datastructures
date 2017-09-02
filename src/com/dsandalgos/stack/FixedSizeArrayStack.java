package com.dsandalgos.stack;

import org.omg.PortableInterceptor.INACTIVE;

public class FixedSizeArrayStack {

    protected int capacity;
    public static final int CAPACITY = 10;
    protected int[] stackRep;
    protected int top = -1;

    public FixedSizeArrayStack(){
        this(CAPACITY);
    }

    public FixedSizeArrayStack(int cap){
        this.capacity = cap;
        stackRep = new int[this.capacity];
    }

    public int size(){
        return (this.top+1);
    }

    public boolean isEmpty(){
        return (this.top<0);
    }

    public int top() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        return stackRep[this.top];
    }

    public void push(int newEntry) throws Exception{
        if(size()==this.capacity){
            throw new Exception("Stack is full..");
        }
        stackRep[++this.top]=newEntry;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        int data = stackRep[this.top];
        stackRep[this.top--] = Integer.MIN_VALUE;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[ ");
        int count = 0;
        while(count <= this.top){
            str.append(stackRep[count]);
            str.append(" | ");
            count++;
        }
        str.append(" ]");
        return str.toString();
    }

    public static void main(String[] args) {
        try{

            FixedSizeArrayStack stack = new FixedSizeArrayStack(5);
            stack.push(1);
            System.out.println(stack);
            stack.push(3);
            stack.push(9);
            System.out.println(stack);
            System.out.println("stack size: " + stack.size());
            stack.push(5);
            stack.push(11);
            System.out.println(stack);
            System.out.println("removed : "+ stack.pop());
            stack.push(10);
            System.out.println(stack);
            System.out.println("last inserted in stack is : " + stack.top());
            System.out.println("removed : "+ stack.pop());
            System.out.println(stack);
            System.out.println("stack size?"+ stack.size());
            System.out.println("last inserted in stack is : " + stack.top());
        }
        catch(Exception e){
            System.out.println("Unhandled exception : "+e.getMessage());
        }
    }
}
