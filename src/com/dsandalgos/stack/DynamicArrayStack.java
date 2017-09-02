package com.dsandalgos.stack;

public class DynamicArrayStack {

    protected int data;
    public static final int CAPACITY = 16;

    public int capacity;
    public static int MINCAPACITY = 1<<15;

    protected int top = -1;
    protected int[] stackRep;


    public DynamicArrayStack(){
        this(CAPACITY);
    }

    public DynamicArrayStack(int cap){
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

    public void push(int newEntry){
        if(size()==this.capacity){
            expand();
        }
        stackRep[++this.top]=newEntry;
    }

    public void expand(){
        System.out.println("Expanded...");
        int length = this.capacity;
        int[] newStackRep = new int[length<<1];
        System.arraycopy(stackRep,0,newStackRep,0,length);
        stackRep = newStackRep;
    }

    public void shrink(){
        int length = this.capacity;
        if(length <= MINCAPACITY || top<<2 >= length){
            return;
        }
        length = length + (top << 1);
        if(top < MINCAPACITY){
            length = MINCAPACITY;
        }
        int[] newStackRep = new int[length];
        System.arraycopy(stackRep,0,newStackRep,0,top+1);
        stackRep = newStackRep;
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

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty...");
        }
        int data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE;
        return data;
    }
    public static void main(String[] args) {
        try{

            DynamicArrayStack stack = new DynamicArrayStack(5);
            stack.push(1);
            System.out.println(stack);
            stack.push(3);
            stack.push(9);
            System.out.println(stack);
            System.out.println("stack size: " + stack.size());
            stack.push(5);
            stack.push(11);
            stack.push(13);
            stack.push(273);
            stack.push(2222);
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
