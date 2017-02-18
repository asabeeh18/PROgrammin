import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NonDivisible {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner r=new Scanner(System.in);
        int n=r.nextInt();
        long k=r.nextLong();
        long a[]=new long[n];
        for(int i=0;i<n;i++)
        {
            a[i]=r.nextLong();       
        }
        long b[]=new long[(int)k];
        Arrays.fill(b,0);
        for(long i:a)
        {
            b[(int)(i%k)]++;  
        }
        long sum=b[0];
        if(k%2==0)
            for(int i=1;i<k/2;i++)
        {
            sum+=(b[i]>b[(int)k-i])?b[(int)i]:b[(int)k-i];
        }
        else
        for(int i=1;i<=k/2;i++)
        {
            sum+=(b[i]>b[(int)k-i])?b[i]:b[(int)k-i];
        }
        if(k!=1 && k>1)
        System.out.println(sum);
        else
        System.out.println("1");
    }
}