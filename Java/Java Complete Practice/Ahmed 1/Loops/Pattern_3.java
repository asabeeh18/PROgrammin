package Loops;
import java.io.*;
class Pattern_3
{
   int n;
  int k=n;
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void mian()throws IOException
 {
     System.out.println("Enter the number of lines");
      n=Integer.parseInt(br.readLine());
      k=n;
     for(int i=1;i<=n;i++)
     {
         for(int j=1;j<=n-i;j++)
         {
             System.out.print("");
            }
            for (int j=1;j<=i;j++)
            {
              System.out.print(j);  
            }
            for (int j=i-1;j>=1;j--)
            {
               System.out.print(j);
            }
            System.out.println();
        }
//_______________________________________________________________________________________
     for(int i=n-1;i<=1;i--)
     {
      for (int j=1;j<=n-i;j++)
      {
          System.out.print(" ");
        }
        for (int j=1;j<=i;j++)
        {
            System.out.print(j);
        }
        for(int j=i-1;j>=1;j--)
        {
         System.out.print(j);
        }
         System.out.println();
        }
    }
}
            
          