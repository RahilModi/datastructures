package com.datastructures.bitmanipulation;
//leetcode 693
public class binaryWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        String binaryString =Integer.toBinaryString(n);
        for(int i = 1; i<binaryString.length(); i++){
            if(binaryString.charAt(i) == binaryString.charAt(i-1)) return false;
        }
        return true;
    }

    public boolean hasAlternatingBits1(int n) {
        int x = n/2 ^ n;
        return (x & (x+1)) == 0;
    }
}
