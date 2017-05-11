package Loops;
import java.io.*;
class Q7iON258
{
   int n;
  int sum;
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void mian()throws IOException
 {
     System.out.println("Enter the number of lines");
     n=Integer.parseInt(br.readLine());
     int k=n;
     for(int i=1;i<=n;i++,k--)
     {
       for(int j=i;j>=1;j--)
       {
         System.out.print(" ");
        }
       for(int j=1;j<=k;j++)
       {
           System.out.print("*");
        }
        for(int j=1;j<=k;j++)
       {
           System.out.print("*");
        }
        System.out.println();
     }
     
     System.out.print("*");
     
//_____________________-------------------------------------------------------
    for(int i=n;i>=1;i--,k++)
    {
        for(int j=0;j<=i;j++)
        {
            System.out.print(" ");
        }
       for(int j=k;j>=1;j--)
       {
           System.out.print("*");
        }
        for(int j=k;j>=1;j--)
       {
           System.out.print("*");
        }
        System.out.println();
     }
    }
}
          
     
  
     