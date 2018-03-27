package com.datastructures.Math;

import java.util.HashMap;
import java.util.List;

public class perfectNum {

    public boolean checkPerfectNumber(int num) {
        if(num == 0) return true;
        if(num == 1) return false;
        int sum = 1;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) {
                sum += i;
                sum += (num / i);
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        perfectNum temp = new perfectNum();
        System.out.println(temp.checkPerfectNumber(28));
    }

}
