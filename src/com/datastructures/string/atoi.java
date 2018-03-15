package com.datastructures.string;

public class atoi {

    public int myAtoi(String str) {

        int result = 0;
        if(str == null || str.isEmpty() || str.length() == 0) return result;
        str = str.trim();
        if(str.length() < 1) return result;
        int i = 0;
        boolean isNegative = false;
        StringBuilder out = new StringBuilder();
        while(i< str.length()){
            char crt = str.charAt(i);
            if(i == 0 && (crt == '-' || crt == '+')){
                if(crt == '-'){
                    isNegative = true;
                }
                i++;
                continue;
            }
            if(crt >= '0' && crt <= '9'){
                int v = (int) crt - '0';
                if(!isNegative && result > (Integer.MAX_VALUE - v) /10 ) return Integer.MAX_VALUE;
                else if(isNegative && -result < (Integer.MIN_VALUE  + v)/10) return Integer.MIN_VALUE;
                result = result * 10 + v;
            }
            else{
                break;
            }
            i++;
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new atoi().myAtoi("--"));
    }
}
