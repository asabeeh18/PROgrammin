//https://www.hackerrank.com/contests/w27/challenges/zero-move-nim
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ZeroNim {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int[] p = new int[n];
            for(int p_i=0; p_i < n; p_i++){
                p[p_i] = in.nextInt();
            }
            boolean won=isWinning(p,new boolean[p.length]);
        }
    }

    private static boolean isWinning(int[] p,boolean[] zero)
    {
        losing for current player only if XOR of all piles =0
        possible moves
        for(each move in possible moves)
        {
            
            if(!isWinning(p,zero)) return true;
        }
        return false;
    }
}
