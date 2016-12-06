
import java.io.*;
import java.util.*;

public class BonAppetit 
{
    public static void main(String[] args)
    {
        Scanner r=new Scanner(System.in);
        int n=r.nextInt();
        int k=r.nextInt();
        int a[]=new int[n];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            a[i]=r.nextInt();
            sum+=a[i];
        }
        
        int b=r.nextInt();
        if(sum-a[k]<2*b)
        {
            System.out.println((2*b-(sum-a[k]))/2);
        }
        else
        {
            System.out.println("Bon Appetit");
        }
    }
}
