package com.datastructures.stackProblems;

import java.util.Stack;

public class ReverseStack {

    public static void reverseStack(Stack stack) {
        if(stack.isEmpty()) return;
        int temp = (Integer)stack.pop();
        reverseStack(stack);
        insertAtbottom(stack,temp);
    }
    public static void insertAtbottom(Stack stack,int data){

        if(stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int tmp = (Integer)stack.pop();
        insertAtbottom(stack,data);
        stack.push(tmp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(110);
        stack.push(12);
        stack.push(120);
        stack.push(103);
        stack.push(132);
        stack.push(127);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }
}
