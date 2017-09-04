package com.datastructures.stackProblems;

import java.util.Stack;

public class AdvancedStack extends Stack{

    private Stack<Integer> elementStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    //Keep two stacks one is original elements stack and other has list of min values at the time of new value push
    //So on the call of find min value we will return the peek value of the min stack.
    public int getMinimumValueInStack(){
        if(!minStack.isEmpty())
            return minStack.peek();
        return Integer.MIN_VALUE;
    }

    @Override
    public Object push(Object item) {
        if(!minStack.isEmpty()){
            if(item instanceof Integer) {
                if (((Integer) item).intValue() <= minStack.peek().intValue()) {
                    minStack.push((Integer) item);
                }
                elementStack.push((Integer) item);
            }
        }else{
            minStack.push((Integer)item);
            elementStack.push((Integer)item);
        }
        return item;
    }

    @Override
    public synchronized Object pop() {
        if(!minStack.isEmpty()){
            if((Integer)elementStack.peek() == (Integer)minStack.peek()){
                minStack.pop();
            }
            return elementStack.pop();
        }else{
            System.out.println("Stack is empty..");
            return null;
        }
    }

    public static void main(String[] args) {
        AdvancedStack aStack = new AdvancedStack();
        aStack.push(100);
        aStack.push(1223);
        aStack.push(223);
        aStack.push(232);
        aStack.push(1);
        aStack.push(12);
        aStack.push(1);

        System.out.println("Minimum value in the stack is : "+aStack.getMinimumValueInStack());
        aStack.pop();
        aStack.pop();
        aStack.pop();
        System.out.println("Minimum value in the stack is : "+aStack.getMinimumValueInStack());

    }
}
