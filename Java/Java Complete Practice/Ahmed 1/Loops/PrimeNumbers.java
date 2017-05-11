package Loops;
import java.io.*;
class PrimeNumbers
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void mian()throws IOException
 {
    System.out.println("Enter the last no.");
     int n=Integer.parseInt(br.readLine());
     for(int i=1;i<=n;i++)
     {
       int c=0;         
       for(int j=2;j<i;j++)
       {
           if(i%j==0)
           {c++;}
        }
        if(c==0)
        {
            System.out.println(i);
        }
    }
  }
}
               