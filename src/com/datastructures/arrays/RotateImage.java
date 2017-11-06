package com.datastructures.arrays;

public class RotateImage {
    //leetcode : 48
    //You are given an n x n 2D matrix representing an image.
    //Rotate the image by 90 degrees (clockwise).
    /*Given input matrix =
            [
            [1,2,3],
            [4,5,6],
            [7,8,9]
            ],

    rotate the input matrix in-place such that it becomes:
            [
            [7,4,1],
            [8,5,2],
            [9,6,3]
            ]*/
    public void rotate(int[][] matrix) {
        int temp = 0;
        for(int i = 0; i < matrix.length/2 ; i++){
            for(int j = i; j < matrix[0].length - i -1;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-j-1][i];
                matrix[matrix.length - j - 1][i] = matrix[matrix.length-i-1][matrix.length-j-1];
                matrix[matrix.length-i-1][matrix.length-j-1] = matrix[j][matrix.length - i -1];
                matrix[j][matrix.length - i - 1] = temp;
            }
        }
    }


}
