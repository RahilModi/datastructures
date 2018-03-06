public class NumOfIslands {
    public int numOfIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length ; i++){
            for(int j=0; j<grid[0].length ; j++){
                if(grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    int area = 1 + helper(i+1,j,visited,grid) + helper(i-1,j,visited,grid) + helper(i,j+1,visited,grid) + helper(i,j-1,visited,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public int helper(int row, int col, boolean[][] visited, char[][] input){
        if(row < 0 || row >= input.length || col <0 || col >= input[0].length) return 0;
        if(input[row][col] == '1' && !visited[row][col]){
            visited[row][col] = true;
            return 1 + helper(row+1,col,visited,input) + helper(row-1,col,visited,input)+ helper(row,col+1,visited,input)+ helper(row,col-1,visited,input);
        }
        else{
            return 0;
        }
    }
}
