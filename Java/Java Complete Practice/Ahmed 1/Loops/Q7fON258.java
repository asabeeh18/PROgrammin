package Loops;
import java.io.*;
class Q7fON258
{
   int n,k;
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void mian()throws IOException
 {
     System.out.println("Enter the number of lines");
     n=Integer.parseInt(br.readLine());
     k=n;
     for(int i=1;i<=n;i++)
     {
         int s=0;
         for(int j=1;j<=i;j++)
         {
             System.out.print(j);
             s=s+j;
            }
          System.out.print(" "+s);
        System.out.println();
    }
 }
}
            