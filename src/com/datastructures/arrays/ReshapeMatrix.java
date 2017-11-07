package com.datastructures.arrays;

public class ReshapeMatrix {

    //leetcode 566
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if((nums.length * nums[0].length) % (r*c) != 0){
            return nums;
        }

        int [][] reshapedMatrix = new int[r][c];
        int x = 0,y=0;
        for(int i = 0;i<nums.length;i++){
            for(int j = 0; j<nums[0].length ;j++){
                if(y >= c){
                    x++;
                    y = 0;
                }
                reshapedMatrix[x][y] = nums[i][j];
                y++;
            }
        }
        return reshapedMatrix;
    }

    public static void main(String[] args) {
        int [][]temp = new int[][]{{1,2,3,4}};
        ReshapeMatrix obj = new ReshapeMatrix();
        obj.matrixReshape(temp,2,2);
    }
}
