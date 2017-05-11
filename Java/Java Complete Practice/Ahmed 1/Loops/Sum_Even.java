package Loops;
import java .io.*;
class Sum_Even
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
     System.out.println("Enter the nth term");
     int n=Integer.parseInt(br.readLine()),s=0;
     for(int i=1;i<=n;i++)
     {
         if(i%2==0)
         {
             s=s+i;
             System.out.print(s+" + ");
            }
        }
        System.out.println(s);
    }
}
