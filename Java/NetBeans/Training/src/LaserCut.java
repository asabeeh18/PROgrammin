//https://www.hackerrank.com/contests/101hack40/challenges/lazy-mayor-and-lasers
import java.io.*;
import java.util.*;

public class LaserCut
{
    public static void main(String args[] ) throws Exception {
        Scanner r=new Scanner(System.in);
        int n=r.nextInt();
        int a[]=new int[n+1];
        long sum=0;
        for(int i=1;i<=n;i++)
        {
            a[i]=r.nextInt();
            //sum+=a[i];
        }
        int m=r.nextInt();
        int b[]=new int[m];
        for(int i=0;i<m;i++)
        {
            b[i]=r.nextInt();
        }
        
        Arrays.sort(b); //is it sorted?
        int last=1;
        for(int i=0;i<m;i++)
        {
            for(int j=last;j<b[i];j++)
            {
                if(a[j]>b[i]-j)
                {
                    sum+=b[i]-j;
                }
                else
                    sum+=a[j];
            }
            last=b[i];
        }
        if(last<n+1)
        {
            for(int i=last;i<=n;i++)
            {
                sum+=a[i];
            }
        }
        System.out.println(sum);
    }
}
