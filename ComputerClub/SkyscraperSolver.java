import java.util.*;
/**
 * Class by Danylo Mirin of Summit High School
 * Written to solve ONLY 4x4 skyscraper problems,
 * assumes that the input is always a string[] of 6
 */
public class SkyscraperSolver
{
    public static void main(String[] args) {
        int[][] result = solve(args);
        for(int[] i : result) {
            for(int j : i)
                System.out.print(j);
            System.out.println();
        }
    }
    
    private static int[][] solve(String[] input) {
        int[][] grid = new int[4][4];
        int[][] topbottom = new int[2][];
        String[] first = input[0].split(",");
        topbottom[0] = convertToInt(first[0]);//must be a 4
        topbottom[1] = convertToInt(first[5]);
        //check for 1 or 4 in the top part
        for(int i = 0; i < topbottom[0].length; i++) {
            if(topbottom[0][i] == 1)//set the first skyscraper to 4
                grid[0][i] = 4;
            if(topbottom[0][i] == 4) {//set all 1-4
                int temp = 1;
                for(int j = 0; j < grid.length; j++) {
                    grid[j][i] = temp;
                    temp++;
                }
            }
        }
        for(int i = 0; i < topbottom[1].length; i++) {
            if(topbottom[1][i] == 1)
                grid[3][i] = 4;
            if(topbottom[0][i] == 4) {
                int temp = 1;
                for(int j = grid.length-1; j >= 0; j--) {//same as above but backwards
                    grid[j][i] = temp;
                    temp++;
                }
            }
        }
        return null;
    }
    
    private static int[] convertToInt(String input) {
        String[] chars = input.split("");
        int[] parsed = new int[chars.length];
        for(int i = 0; i < chars.length; i++)
            parsed[i] = Integer.parseInt(chars[i]);
        return parsed;
    }
}