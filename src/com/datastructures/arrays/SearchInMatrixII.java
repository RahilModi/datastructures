package com.datastructures.arrays;

import java.util.Arrays;

public class SearchInMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        boolean bFound = false;
        for(int i = 0; i < matrix.length; i++){
            int len = matrix[i].length;
            if(len>0 && target >= matrix[i][0] && target <= matrix[i][len-1]){
                int j = Arrays.binarySearch(matrix[i],target);
                if(j>=0){
                    bFound = true;
                    break;
                }
            }
        }
        return bFound;
    }

    public static void main(String[] args) {
        int[][] temp = new int[1][1];
        temp[0][0] = -5;

        new SearchInMatrixII().searchMatrix(temp,-5);
    }
}
