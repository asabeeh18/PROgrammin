package Loops;
import java.io.*;
class Odd_Interval
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
     System.out.println("Enter the nth term");
     int n=Integer.parseInt(br.readLine());
     int s=0;
     for(int i=1;i<=n;i++)
     {
         s=s+((i*i)+1);
         System.out.print(s+"+");
        }
     System.out.println(s);
    }
    
    }
            
     