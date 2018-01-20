package com.datastructures.string;

public class RepeatedSubString {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = len/2 ; i >= 1 ; i--){
            if(len % i == 0){
                int times = len / i;
                String t = s.substring(0,i);
                StringBuilder str = new StringBuilder(t);
                for(int j = times; j > 0; j++){
                    str.append(t);
                }
                if(str.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
