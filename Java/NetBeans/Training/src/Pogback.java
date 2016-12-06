import java.io.*;
import java.util.*;

public class Pogback 
{

    public static void main(String[] args) {
        Scanner r =new Scanner(System.in);
        long a=r.nextLong();
        long n=r.nextLong();
        long k=r.nextLong();
        
        if(a%k==0)
        {
            System.out.println(n*(n-1)/2);
        }
        else
        {
            long i=1,num=0;
            while(k*i<=n)
            {
                num+=(k*i-1)/2;
                i++;
            }
            System.out.println(num);
        }
    }
}