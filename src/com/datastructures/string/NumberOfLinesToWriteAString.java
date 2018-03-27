package com.datastructures.string;

public class NumberOfLinesToWriteAString {

    final int WIDTH = 100;

    public int[] numberOfLines(int[] widths, String S) {
        int numOfLines = 1;
        int charCountInLastLine = 0;

        for(char c:S.toCharArray()){
            if(widths[c-'a'] <= WIDTH-charCountInLastLine){
                charCountInLastLine += widths[c-'a'];
            }
            else{
                numOfLines++;
                charCountInLastLine = 0;
                charCountInLastLine += widths[c-'a'];
            }
        }
        return new int[]{numOfLines,charCountInLastLine};
    }

    public static void main(String[] args) {
       for(int i: new NumberOfLinesToWriteAString().numberOfLines(new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "abcdefghijklmnopqrstuvwxyz")){
           System.out.println(i);
       }
    }

}
