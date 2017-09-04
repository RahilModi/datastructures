package com.datastructures.stackProblems;

import java.util.Stack;

public class AscendingSort {

    public static Stack<Integer> ascendingSort(Stack<Integer> stack){
        Stack<Integer> s = new Stack<>();
        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!s.isEmpty() && s.peek() > temp){
                stack.push(s.pop());
            }
            s.push(temp);
        }
        return s;
    }

    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<>();
        inputStack.push(100);
        inputStack.push(12);
        inputStack.push(222);
        inputStack.push(50);
        inputStack.push(23);
        inputStack.push(1);
        System.out.println(inputStack);
        System.out.println(ascendingSort(inputStack));
    }
}
