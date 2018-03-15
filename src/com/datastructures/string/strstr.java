package com.datastructures.string;

public class strstr {

    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        int start = -1;

        for(int i = 0 ; i < haystack.length(); i++){
            int index = i, j = 0;
            while( j<needle.length() && haystack.charAt(index) == needle.charAt(j) ){
                j++;
                index++;
            }
            if(j==needle.length()){
                start = i;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new strstr().strStr("hello","ll"));
    }
}
