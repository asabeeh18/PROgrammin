import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Recipe {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int r = in.nextInt();
            int p = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            int[] pantry = new int[m];
            for(int pantry_i=0; pantry_i < m; pantry_i++){
                pantry[pantry_i] = in.nextInt();
            }
            int[] cost = new int[p];
            for(int cost_i=0; cost_i < p; cost_i++){
                cost[cost_i] = in.nextInt();
            }
            int[][] recipe = new int[r][p];
            for(int recipe_i=0; recipe_i < r; recipe_i++){
                for(int recipe_j=0; recipe_j < p; recipe_j++){
                    recipe[recipe_i][recipe_j] = in.nextInt();
                }
            }
            
        }
    }
}
