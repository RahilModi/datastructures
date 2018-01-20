package com.datastructures.bitmanipulation;

public class reverseBits {
    public int reverseBits(int n) {
        int b = 0;
        while(n != 0){
            b<<=1;
            b |= (n&1);
            n>>=1;
        }
        return b;
    }

    public int reverseBitsIn32BitsForm(int n) {
        int b = 0;
        for(int j =0 ;j < 32;j++){
            b<<=1;
            b |= (n&1);
            n>>>=1;
        }
        return b;
    }


    public static void main(String[] args) {
        System.out.println(new reverseBits().reverseBitsIn32BitsForm(1));
    }
}
