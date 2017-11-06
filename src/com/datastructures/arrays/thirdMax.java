package com.datastructures.arrays;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class thirdMax {
    public int findthirdMax(int[] nums) {

        Map<Integer,Integer> mapOfValues = new TreeMap<Integer,Integer>(Collections.reverseOrder());
        for(int num : nums){
            if(!mapOfValues.containsKey(num)){
                mapOfValues.put(num,1);
            }else{
                mapOfValues.put(num,mapOfValues.get(num)+1);
            }
        }
        Iterator<Integer> itr = mapOfValues.keySet().iterator();
        int count = 3;
        if(count > mapOfValues.size()){
            return itr.next();
        }
        int i = 0;
        while(count > 0){
            i = itr.next();
            count--;
        }
        return i;
    }

    //very efficient
    public int findthirdMaxWithoutMap(int[] nums) {

        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for(Integer num : nums){
            if(num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            if(max1 == null || num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(max2 == null || num > max2){
                max3 = max2;
                max2 = num;
            }
            else if(max3 == null || num > max3){
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }
    public static void main(String[] args) {
        thirdMax obj = new thirdMax();
        System.out.println(obj.findthirdMax(new int[]{2,3,1}));
        System.out.println(obj.findthirdMax(new int[]{1,2,2}));
        System.out.println(obj.findthirdMax(new int[]{2,2,3,1}));

        System.out.println(obj.findthirdMaxWithoutMap(new int[]{2,3,1}));
        System.out.println(obj.findthirdMaxWithoutMap(new int[]{1,2,2}));
        System.out.println(obj.findthirdMaxWithoutMap(new int[]{2,2,3,1}));
    }
}
