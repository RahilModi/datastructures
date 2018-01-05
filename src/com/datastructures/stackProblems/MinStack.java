package com.datastructures.stackProblems;

import java.util.Stack;


class MinStackV2 {

    Stack<Integer> minStack;
    int min = Integer.MAX_VALUE;

    public MinStackV2() {
        minStack = new Stack<>();
    }

    public void push(int x) {
            if(x <= min){
                minStack.push(min);
                min = x;
            }
            minStack.push(x);
        }

    public void pop() {
        if(minStack.pop() == min) min = minStack.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return min;
    }

}


public class MinStack {

        static  class Number{
            int min;
            int value;

            Number(int val, int min){
                this.min = min;
                this.value = val;
            }
        }

        Stack<Number> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            minStack = new Stack<>();
        }

        public void push(int x) {
            int min = minStack.empty() ? x : Math.min(minStack.peek().min, x);
            minStack.push(new Number(x, min));
        }

        public void pop() {
            minStack.pop();
        }

        public int top() {
            return minStack.peek().value;
        }

        public int getMin() {
            return minStack.peek().min;
        }

}
