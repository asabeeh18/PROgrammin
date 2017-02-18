import java.io.*;
import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        Scanner r = new Scanner (System.in);
        int n=r.nextInt();
        int m=r.nextInt();
        int a[]=new int[m+1];
        for(int i=1;i<=m;i++)
            a[i]=r.nextInt();
        
        int[][] box=new int[m+1][n+1];
        Arrays.fill(box[0],0);
        for(int i=1;i<=m;i++)
        {
            box[i][0]=1;    //get that magical one
            for(int j=1;j<=n;j++)
            {
                if(j>=a[i])
                {
                    box[i][j]=box[i-1][j]+box[i][j-a[i]];
                }
                else
                {
                    box[i][j]=box[i-1][j];                    
                }
            }
        }
        System.out.println(box[m][n]);
    }
}