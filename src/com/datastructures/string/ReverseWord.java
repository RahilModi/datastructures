package com.datastructures.string;

import java.util.Stack;

//leetcode problem: 557
public class ReverseWord {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) != ' '){
                stack.push(s.charAt(i));
            }
            while(!stack.empty())
            {
                str.append(stack.pop());
            }
            if(i<s.length()-1){
                str.append(' ');
            }
        }
        return str.toString();
    }

    public String reverseWords2(String s) {
        if(s == null || s.length() == 0) return s;
        String[] words = s.split(" ");
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i < words.length ; i++){
            for(int j = words[i].length()-1; j>=0 ;j--){
                str.append(words[i].charAt(j));
            }
            if(i<words.length-1){
                str.append(' ');
            }
        }
        return str.toString();
    }


}
