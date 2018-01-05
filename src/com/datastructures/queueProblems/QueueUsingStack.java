package com.datastructures.queueProblems;


import java.util.Stack;

public class QueueUsingStack {

    class MyQueue {
        Stack<Integer> stackIn = null;
        Stack<Integer> stackOut = null;
        /** Initialize your data structure here. */
        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackIn.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stackOut.empty()) moveStackInToStackOut();
            return stackOut.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(stackOut.empty()) moveStackInToStackOut();
            return stackOut.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if(stackOut.empty() && stackIn.empty()) return true;
            return false;
        }

        private void moveStackInToStackOut(){
            while(!stackIn.empty()){
                stackOut.push(stackIn.pop());
            }
        }
    }
}
