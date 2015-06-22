package Loops;
import java.io.*;
class Series_Add_Factorial_Func_Call
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void mian()throws IOException
 {
     System.out.println("Enter the last no.of the factorial series");
     int n=Integer.parseInt(br.readLine()),s=0;
     for(int i=1;i<=n;i++)
     {
        s=s+fact(i);
        }
        System.out.println(s);
    }
    int fact(int x)
    {
        int p=1;
        for(int i=1;i<=x;i++)
        {
            p=p*i;
        }
        return p;
    }    
}
         

