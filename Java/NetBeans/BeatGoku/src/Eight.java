
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Eight
{

    public static void main(String[] args)
    {
        int M = 1000000007;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        int[] two3 =
        {
            00, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 56, 60, 64, 68, 72, 76, 80, 84, 88, 92, 96
        };
        
        // your code goes here
        long co = 0, uni = 0, duo = 0;
        int a[] = new int[n];
        boolean[] twos=new boolean[100];
        
        for(int i: two3)
        {
            twos[i]=true;
        }
        for (int i = 0; i < n; i++)
        {
            a[i] = s[i] - '0';
        }
        s = null;
        two3=null;
        for (int i = n - 1; i >= 0; i--)
        {
            
            int u=a[i];
            if (u == 0 || u == 8)
            {
                uni++;
            }
            if (u % 2 == 0)
            {
                for (int j = i - 1; j >= 0; j--)
                {
                    int t=a[j]*10+u;
                    if(t%8==0)
                        duo++;
                    if (twos[t])
                    {
                        for(int k=j-1;k>=0;k--)
                        {
                            int tri=a[k]*100+t;
                            if(tri%8==0)
                            {
                                co=(co+(long)Math.pow(2,k))%M;
                            }
                        }
                    }
                }
            }
        }
        co=(co+uni+duo)%M;
        System.out.println(co);
    }
}
