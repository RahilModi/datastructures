package com.datastructures.bitmanipulation;

public class PowerOf4 {
    //method1
    public boolean isPowerOfFour(int num) {
        if(num>1){
            while(num%4 ==0){
                num/=4;
            }
        }
        return num == 1;
    }

    //method2
    public boolean isPowerOfFourUsingRegex(int num) {
        System.out.println(Integer.toString(num,4));
        return num > 0 && Integer.toString(num,4).matches("10*");
    }

    //method3
    public boolean isPowerOfFourBitManipulation(int num) {
        return num>0 && (num & (num-1))==0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        boolean ans = new PowerOf4().isPowerOfFourUsingRegex(18);
        if(ans) System.out.println("Is power of 4");
    }

}
