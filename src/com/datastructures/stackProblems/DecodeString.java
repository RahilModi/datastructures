package com.datastructures.stackProblems;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                while(Character.isDigit(s.charAt(i))){
                    count = count * 10 + s.charAt(i)-'0';
                    i++;
                }
                i--;
                intStack.push(count);
                count = 0;
            }
            else if(s.charAt(i) == '['){
                if(Character.isDigit(s.charAt(i-1))){
                    charStack.push(s.charAt(i));
                }else{
                    charStack.push(s.charAt(i));
                    intStack.push(1);
                }
            }else if(s.charAt(i)==']'){
                count = 0;
                if(!intStack.empty()){
                    count = intStack.pop();
                }
                while(!charStack.empty() && charStack.peek() != '['){
                    temp.append(charStack.pop());
                }
                if(!charStack.empty() && charStack.peek() == '[')
                    charStack.pop();
                temp=temp.reverse();
                for(int j =0; j< count;j++){
                    res.append(temp);
                }
                count=0;
                for(int k =0; k<res.length();k++){
                    charStack.push(res.charAt(k));
                }
                temp.setLength(0);
                res.setLength(0);
            }else{
                charStack.push(s.charAt(i));
            }
        }

        while(!charStack.empty()){
            res.append(charStack.pop());
        }
        return res.reverse().toString();
    }

    public static void main(String args[])
    {
        String str = "3[b]2[ca]";
        System.out.println(new DecodeString().decodeString((str)));
    }
}
