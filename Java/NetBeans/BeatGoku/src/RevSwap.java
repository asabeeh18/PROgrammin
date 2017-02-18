import java.io.*;
import java.util.*;

public class RevSwap {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner r=new Scanner(System.in);
        
        int n=r.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=r.nextInt();
        }
        
        //find
        int decC=0,dec1=-1,dec2=-1,state=-1,swap=0,swap1=-1,swap2=-1,inc1=-1; 
        for(int i=0;i<n-1;i++)
        {
            if(!(a[i]<a[i+1]))
            {
                if(decC>0)
                {
                    swap2=i;
                    state=0;
                }
                if(decC==0 || dec1+1==i)
                {
                    decC++;
                    dec1=i;
                    if(decC==1)
                    {
                        swap1=i;
                    }
                    
                }
                else decC=0;
                if(decC>2)
                    state=1;
                if(decC>0)
                {
                    swap++;
                }
            }
            else if(state==1 && a[i]<a[i+1])
            {
                inc1=i;
            }
        }
        
        //fix
        if(state==0)
        {
            int t=a[swap1];
            a[swap1]=a[inc1];
            a[inc1]=t;
        }
        else if(state==1)
        {
            int x=((swap2==-1)?n:swap2+1);
            for(int i=swap1,j=0;i<=x/2;i++,j++)
            {
               int t=a[i];
               a[i]=a[x-j];
               a[x-j]=t;
            }
        }
        
        //check-out
        if(checkSort(a))
            System.out.println("yes");
        if(state==1)
        {
            
            System.out.println("reverse "+(swap1+1)+" "+(inc1+1));
        }
        else if(state==0)
        {
            System.out.println("swap "+(swap1+1)+" "+((swap2==-1)?n:swap2));
        }   
        else
            System.out.println("no");
    }

    private static boolean checkSort(int[] a)
    {
        for(int i=0;i<a.length-1;i++)
        {
            if(!(a[i]<=a[i+1]))
            {
                return false;
            }
        }
        return true;
    }
}