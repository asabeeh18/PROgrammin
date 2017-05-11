import java.io.*;
import java.util.*;

public class GreatEven {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner r=new Scanner(System.in);
        int t=r.nextInt();
        while(t-->0)
        {
            int n=r.nextInt();
            int a[]=new int[n];
            int e[]=new int[n];
            a[0]=r.nextInt();
            e[0]=a[0]%2==0?1:0;
            for(int i=1;i<n;i++)
            {
                a[i]=r.nextInt();
                if(a[i]%2==0)
                    e[i]=e[i-1]+1;
                else
                    e[i]=e[i-1];
            }
            int ev=0;
            int od=0;
                
            for(int j=0;j<n;j++)
            {
                if(a[j]%2==0)
                    ev++;
                else
                    od++;
                int e1=0,o1=0,co=0;
                for(int i=0;i<=j;i++)
                {
                    if(a[i]%2==0)
                        e1++;
                    else
                        o1++;
                    if(a[i]%2==0)
                    {
                        if(ev-e1+1>=od-o1)
                            co++;
                    }
                    else
                        if(ev-e1>=od-o1+1)
                            co++;
                }
                System.out.print(co+" ");
            }
            System.out.println();
        }   
    }
}