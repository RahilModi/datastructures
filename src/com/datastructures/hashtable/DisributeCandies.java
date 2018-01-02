package com.datastructures.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//leetcode problem: 575
/*Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.*/
public class DisributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> s = new HashSet<>();
        int required = candies.length/2;
        for(int type: candies){
            s.add(type);
        }
        return Math.min(s.size(),required);
    }
}
