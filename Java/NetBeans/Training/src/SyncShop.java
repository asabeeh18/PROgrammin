//https://www.hackerrank.com/challenges/synchronous-shopping
import java.io.*;
import java.util.*;

public class SyncShop {

    public static void main(String[] args) throws IOException 
    {
        //Read
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,m,k,t;
        String[] s=br.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        k=Integer.parseInt(s[2]);
        
        int[][] monger=new int[n+1][];
        for(int i=1;i<=n;i++)
        {
            s=br.readLine().split(" ");
            t=Integer.parseInt(s[0]);
            monger[i]=new int[t];
            for(int j=0;j<t;j++)
            {
                monger[i][j]=Integer.parseInt(s[j+1]);
            }
        }
        int city[][]=new int[n+1][n+1];
        
        //or adj list
        for(int i=0;i<m;i++)
        {
            s=br.readLine().split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            city[b][a]=city[a][b]=Integer.parseInt(s[2]);
        }
        
        //Process
        boolean[] fish=new boolean[k];
        Arrays.fill(fish, false);
        
        for(int i=0;i<monger[1].length;i++)
        {
            fish[monger[1][i]]=true;
        }
        for(int i=0;i<monger[n].length;i++)
        {
            fish[monger[n][i]]=true;
        }
        
        //dijkstras();
        
    }
}