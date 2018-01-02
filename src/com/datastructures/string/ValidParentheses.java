package com.datastructures.string;
//leetcode problem : 20
import java.util.Stack;

public class ValidParentheses  {
    public boolean isValid(String s) {
        if(s ==null || s.length() == 0) return true;
        if(s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        char[] charArray = s.toCharArray();
        for(char ch: charArray){
            if(ch == ')' || ch == '}' || ch == ']'){
                if(st.empty()) return false;
                else{
                    char prev = st.peek();
                    if(ch == ']' && prev =='[') st.pop();
                    else if(ch ==')' && prev == '(') st.pop();
                    else if(ch == '}' && prev == '{') st.pop();
                    else
                        return false;
                }
            }
            else{
                st.push(ch);
            }
        }
        if(st.empty()) return true;
        return false;
    }
}
