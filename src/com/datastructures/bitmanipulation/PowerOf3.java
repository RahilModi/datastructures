package com.datastructures.bitmanipulation;

public class PowerOf3 {

    public boolean isPowerOfTwo(int num) {
        if(num>1){
            while(num % 3 == 0){
                num /= 3;
            }
        }
        return num == 1;
    }

    //method2
    public boolean isPowerOfFourUsingRegex(int num) {
        System.out.println(Integer.toString(num,3));
        return num > 0 && Integer.toString(num,3).matches("10*");
    }

    //method3
    public boolean isPowerOfTWOBitManipulation(int num) {
        //3 is prime number and 3^20 is out of range for int so max possible number is 3^19;
        return ( num>0 &&  1162261467%num==0);
    }
}
