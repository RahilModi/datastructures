public class islandPerimeter {

    public int calcIslandPerimeter(int[][] grid) {
        int perimeter = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) return perimeter;

        for(int i = 0; i< grid.length ;i++){
            for(int j=0; j< grid[0].length; j++){

                //add 4 sides
                if(grid[i][j] == 1) {
                    perimeter += 4;


                    //remove the side shared between crt and upper cell
                    if (i > 0 && grid[i - 1][j] == 1) perimeter -= 2;

                    //remove the side shared between crt and left cell
                    if (j > 0 && grid[i][j - 1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        System.out.println(new islandPerimeter().calcIslandPerimeter(new int[][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}})); //16
    }
}
