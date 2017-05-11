package Loops;
import java.io.*;
class xPow1___n
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
     System.out.println("Enter a number and the power till where it is to be summed in different lines");
     int x=Integer.parseInt(br.readLine());
     int n=Integer.parseInt(br.readLine());
     double sum=0;
     for(int i=1;i<=n;i++)
     {
       sum=sum+Math.pow(x,i);
    }
    System.out.println(sum);
}
}