package Loops;
import java.io.*;
class Perfectno
{
   int n;
  int sum;
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void mian()throws IOException
 {
     System.out.println("Enter the number");
      n=Integer.parseInt(br.readLine());
      for(int i=0;i<=n;i++)
      {
          sum=0;
          for(int j=1;j<i;j++)
          {
           if(i%j==0)
           {
               sum=sum+j;
            }
          } 
        if(sum==i)
        {
            System.out.println(i);
        }
    }
 }
}
        