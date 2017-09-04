package com.datastructures.stackProblems;

import java.util.Stack;

public class LargestRectangleUnderHistogram {

    public static int calculateMaxArea(int [] inputs){
        int max_area = 0;
        Stack<Integer> stack = new Stack<>();
        int tp=0,area =0;
        int i =0;
        while(i< inputs.length){
            if(stack.isEmpty() || inputs[stack.peek()] <= inputs[i]){
                stack.push(i++);
            }
            else {
                tp = stack.peek();
                stack.pop();
                area = inputs[tp] * (stack.isEmpty()?i:i-stack.peek()-1);

                if(max_area < area){
                    max_area = area;
                }

            }

        }
        while(!stack.isEmpty()){
            tp = stack.peek();
            stack.pop();
            area = inputs[tp] * (stack.isEmpty()?i:i- stack.peek()-1);

            if(max_area < area){
                max_area = area;
            }
        }
        return max_area;
    }

    public static void main(String[] args) {
        int[] inputs = new int[7];
        inputs[0] = 6;
        inputs[1] = 2;
        inputs[2] = 0;
        inputs[3] = 2;
        inputs[4] = 5;
        inputs[5] = 7;
        inputs[6] = 6;

        System.out.println("Max rectangle area of histogram is : "+calculateMaxArea(inputs));

    }
}
