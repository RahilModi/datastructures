package com.datastructures.Math;

import java.util.ArrayList;
import java.util.List;

public class uglyNumber {

    List<Integer> uglyNums = new ArrayList<>();

    public boolean isUgly(int num) {
        if(num == 0) return false;
        if(num == 1) return true;
        for(int i: new int[]{2,3,5}){
            while(num%i==0) num /= i;
        }
        return num == 1;
    }

}
