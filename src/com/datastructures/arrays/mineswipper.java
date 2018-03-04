import java.util.ArrayList;
import java.util.HashSet;

public class mineswipper {

    public int[][] minesweeper(String[][] matrix) {

        int[][] output = new int[matrix.length][matrix[0].length];
        ArrayList<String> positions = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j].equals("m")){
                    positions.add(String.valueOf(i)+'-'+String.valueOf(j));
                }
            }
        }

        output = applyrule1(output, positions);
        output = applyRule2(output, positions);
        output = applyRule3(output, positions);
        output = applyRule4(output, positions);
        output = applyRule5(output, positions);
        output = applyRule6(output, positions);


        printOutput(output);

        return output;
    }

    private int [][] applyrule1(int[][] nums, ArrayList<String> pos){
        for(int i=0 ; i < pos.size(); i++){
            int x = Integer.parseInt(pos.get(i).split("-")[0]);
            int y = Integer.parseInt(pos.get(i).split("-")[1]);
            if( x-1 >= 0) {
                nums[x - 1][y] += 1;
                if(y-1 >= 0)
                    nums[x - 1][y - 1] += 1;
                if(y+1 < nums[0].length)
                    nums[x-1][y+1] += 1;
            }
            if( x+1 < nums.length ) {
                nums[x + 1][y] += 1;
                if (y - 1 >= 0)
                    nums[x + 1][y - 1] += 1;
                if (y + 1 < nums[0].length)
                    nums[x + 1][y + 1] += 1;
            }
            if(y-1 >= 0)
                nums[x][y-1] += 1;
            if(y+1 < nums[0].length)
                nums[x][y+1] += 1;
        }
        return nums;
    }

    private int[][] applyRule2(int[][] nums, ArrayList<String> pos){
        for(int i=0 ; i < pos.size(); i++) {
            int x = Integer.parseInt(pos.get(i).split("-")[0]);
            int y = Integer.parseInt(pos.get(i).split("-")[1]);

            if(x+1 < nums.length){
                nums[x+1][y] = 2;
            }
        }
        return nums;
    }

    private int[][] applyRule3(int[][] nums, ArrayList<String> pos){
        for(int i=0 ; i < pos.size(); i++) {
            int x = Integer.parseInt(pos.get(i).split("-")[0]);
            int y = Integer.parseInt(pos.get(i).split("-")[1]);

            if(y+1 < nums[0].length){
                nums[x][y+1] = 0;
            }
        }
        return nums;
    }

    private int[][] applyRule4(int[][] nums, ArrayList<String> pos){
        HashSet<Integer> visitedRows = new HashSet<>();
        for(int i=0 ; i < pos.size(); i++) {
            int x = Integer.parseInt(pos.get(i).split("-")[0]);
            int y = Integer.parseInt(pos.get(i).split("-")[1]);

            if(x%2 != 0 && !visitedRows.contains(x)){
                visitedRows.add(x);
                for(int j = 0; j < nums[0].length ;j++){
                    nums[x][j] *= 3;
                }
            }
        }
        return nums;
    }

    private int[][] applyRule5(int[][] nums, ArrayList<String> pos){
        HashSet<String> visited = new HashSet<>();
        for(int i=0 ; i < pos.size(); i++) {
            int x = Integer.parseInt(pos.get(i).split("-")[0]);
            int y = Integer.parseInt(pos.get(i).split("-")[1]);

            if(y-1 >= 0){
                if(x-1 >= 0) {
                    if(!visited.contains(String.valueOf(x-1)+"-"+String.valueOf(y-1))) {
                        nums[x - 1][y - 1] *= 2;
                        visited.add(String.valueOf(x - 1) + "-" + String.valueOf(y - 1));
                    }
                }
                if(x+1 < nums.length)
                    if(!visited.contains(String.valueOf(x+1)+"-"+String.valueOf(y-1))) {
                        nums[x + 1][y - 1] *= 2;
                        visited.add(String.valueOf(x + 1) + "-" + String.valueOf(y - 1));
                    }
            }

            if(y+1 < nums[0].length){
                if(x-1 >= 0)
                    if(!visited.contains(String.valueOf(x-1)+"-"+String.valueOf(y+1))) {
                        nums[x - 1][y + 1] *= 2;
                        visited.add(String.valueOf(x - 1) + "-" + String.valueOf(y + 1));
                    }
                if(x+1 < nums.length)
                    if(!visited.contains(String.valueOf(x+1)+"-"+String.valueOf(y+1))) {
                        nums[x + 1][y + 1] *= 2;
                        visited.add(String.valueOf(x + 1) + "-" + String.valueOf(y + 1));
                    }
            }

        }
        return nums;
    }

    private int[][] applyRule6(int[][] nums, ArrayList<String> pos){
        for(int i=0 ; i < pos.size(); i++) {
            int x = Integer.parseInt(pos.get(i).split("-")[0]);
            int y = Integer.parseInt(pos.get(i).split("-")[1]);

            nums[x][y] = -1;
        }
        return nums;
    }



    private void printOutput(int[][] output){
        for(int i = 0; i < output.length; i++){
            for(int j =0; j< output[0].length ; j++){
                System.out.print(output[i][j]+ ", ");
            }
            System.out.println();
        }
    }

    private void printOutput(String [][] output){
        for(int i = 0; i < output.length; i++){
            for(int j =0; j< output[0].length ; j++){
                System.out.print(output[i][j]+ ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[][] input = new String[][]{{".","m",".","."},{".",".",".","."},{".",".",".","m"},{"m",".",".","."}};
        int[][] output = new mineswipper().minesweeper(input);
    }
}
