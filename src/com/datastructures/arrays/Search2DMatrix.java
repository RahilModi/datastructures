package com.datastructures.arrays;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row =0;
        int col = 0;
        while(row < matrix.length && col<matrix[row].length){
            if(target == matrix[row][col]){
                return true;
            }else if(target > matrix[row][matrix[row].length-1]){
                row++;
                col = 0;
            }else if(target > matrix[row][col]) {
                col++;
                if(col == matrix[row].length){
                    row++;
                    col--;
                }
            }else{
                break;
            }
        }
        return false;
    }
}
