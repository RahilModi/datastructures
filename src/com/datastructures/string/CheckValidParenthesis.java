package com.datastructures.string;

import java.util.Stack;

public class CheckValidParenthesis {

    public boolean checkValidString(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        int count = 0;
        int low = 0;
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                low++;
                count++;
            }else if(s.charAt(i) == ')'){
                if(low > 0){
                    low--;
                }
                count--;
            }else{
                if(low > 0){
                    low--;
                }
                count++;
            }
            if(count < 0) return false;
        }
        return low == 0;
    }

    public static void main(String[] args) {
        CheckValidParenthesis check = new CheckValidParenthesis();
        String test = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        boolean b = check.checkValidString(test);
        System.out.println(b);
    }
}
