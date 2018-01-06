package com.datastructures.stackProblems;

import java.util.Stack;

//leetcode 735: We are given an array asteroids of integers representing asteroids in a row.
//
//For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
public class AsteroidCollision {


    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) return asteroids;
        Stack<Integer> opt = new Stack<>();
        for(int i : asteroids){
            if(i > 0) opt.push(i);
            else{
                while(!opt.empty() && opt.peek() > 0 && opt.peek() < -i){
                    opt.pop();
                }
                if(!opt.empty() && opt.peek() == -i){
                    opt.pop();
                }else if(opt.empty() || opt.peek() < 0){
                    opt.push(i);
                }
            }
        }
        return opt.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        AsteroidCollision temp =  new AsteroidCollision();
        temp.asteroidCollision(new int[]{5,10,-5});
    }
}
