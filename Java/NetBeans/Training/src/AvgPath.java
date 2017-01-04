
import java.util.Arrays;
import java.util.Scanner;

/*
 * Source:https://www.codechef.com/problems/AVGSHORT
 * Status/Result:  * 
 */

/**
 *
 * @author Ahmed
 */
public class AvgPath {
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0)
        {
            int n=in.nextInt();
            int e=in.nextInt();
            int box[][]=new int[n+1][n+1];
            long cost[]=new long[n+1];
            int path[]=new int[n+1];
            int a,b;
            for(int i=0;i<e;i++)
            {
                a=in.nextInt();
                b=in.nextInt();
                box[a][b]=in.nextInt();
            }
            //djik
            Arrays.fill(cost,Long.MAX_VALUE);
            
            
        }
            
    }
    
            
    
}
