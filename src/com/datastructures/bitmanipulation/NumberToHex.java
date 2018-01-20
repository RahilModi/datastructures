package com.datastructures.bitmanipulation;

public class NumberToHex {

    public String toHex(int num) {
        char [] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder str = new StringBuilder();
        if(num != 0) {
            int r;
            while (num != 0) {
                r = num & 15;
                num >>>= 4;
                str.append(hexDigits[r]);
            }
        }else{
            str.append('0');
        }
        return str.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new NumberToHex().toHex(-1));
    }
}
