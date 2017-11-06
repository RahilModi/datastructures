package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    //leetcode 118
/*    Given numRows, generate the first numRows of Pascal's triangle.

            For example, given numRows = 5,
            Return

        [
                [1],
                [1,1],
                [1,2,1],
                [1,3,3,1],
                [1,4,6,4,1]
         ]*/
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalTri = new ArrayList<>();
        for(int i = 0; i<numRows ;i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j<=i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(pascalTri.get(i-1).get(j-1)+pascalTri.get(i-1).get(j));
                }
            }
            pascalTri.add(row);
        }
        return pascalTri;
    }

    //leetcode: 119s
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
            row.add(1);
            for(int j=i-1;j>0;j--) {
                row.set(j, row.get(j-1)+row.get(j));
            }
        }
        return row;
    }

    public static void main(String[] args) {
        PascalTriangle obj = new PascalTriangle();
        obj.getRow(3).stream().forEach(System.out::println);
    }


}
