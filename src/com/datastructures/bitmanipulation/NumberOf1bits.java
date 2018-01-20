package com.datastructures.bitmanipulation;

public class NumberOf1bits {
    public int hammingWeight(int n) {
        int count = 0;
        while( n != 0){
            count += (n&1);
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1bits().hammingWeight(7));
    }
}
