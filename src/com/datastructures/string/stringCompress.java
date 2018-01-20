package com.datastructures.string;

public class stringCompress {
    public int compress(char[] chars) {
        int index=0;
        int count =0;
        for(int i = 0; i < chars.length ;i++){
            char crt = chars[i];
            while(i<chars.length && chars[i] == crt){
                i++;
                count++;
            }
            i--;
            chars[index++] = crt;
            if(count != 1) {
                char[] counter = String.valueOf(count).toCharArray();
                for (int j = 0; j < counter.length; j++) {
                    chars[index++] = counter[j];
                }
            }
            count =0;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new stringCompress().compress(new char[]{'a','b','b','b','c'}));
    }
}
