package Loops;
import java.io.*;
class Series_Add_Factorial_Nested_Loop
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void mian()throws IOException
 {
     System.out.println("Enter the last no.of the factorial series");
     int n=Integer.parseInt(br.readLine()),s=0,p;
     for(int i=1;i<=n;i++)
     {
         p=1;
         for(int j=1;j<=i;j++)
         {
             p=p*j;
         }
         System.out.print(s+"+");
         s=s+p;
        }
        System.out.println(s);
    }
}
         

