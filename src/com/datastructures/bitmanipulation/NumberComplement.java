package com.datastructures.bitmanipulation;

//leetcode problem : 476
public class NumberComplement {

    public int findComplement(int num) {
        String input = Integer.toBinaryString(num);
        StringBuilder str = new StringBuilder();
        for(char ch:input.toCharArray()){
            ch ^= 1;
            str.append(ch);
        }
        return Integer.parseInt(str.toString(),2);
    }

    public static void main(String[] args) {
        new NumberComplement().findComplement(20161211);
    }
}
