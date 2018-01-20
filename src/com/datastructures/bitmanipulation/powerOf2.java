package com.datastructures.bitmanipulation;

public class powerOf2 {

    public boolean isPowerOfTwo(int num) {
        if(num>1){
            while(num % 2 == 0){
                num /= 2;
            }
        }
        return num == 1;
    }

    //method2
    public boolean isPowerOfFourUsingRegex(int num) {
        System.out.println(Integer.toBinaryString(num));
        return num > 0 && Integer.toBinaryString(num).matches("10*");
    }

    //method3
    public boolean isPowerOfTWOBitManipulation(int num) {
        return num>0 && (num & (num-1))==0;
    }

    public static void main(String[] args) {
       new  powerOf2().isPowerOfFourUsingRegex(16);
    }
}
