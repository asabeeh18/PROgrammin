
import java.io.*;
class Factors
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void mian()throws IOException
 {
     System.out.println("Enter the no. to find factors of");
     int n=Integer.parseInt(br.readLine());
     for(int i=1;i<=n;i++)
     {
         if(n%i==0)
        {
            System.out.print(i+" ");
        }
    }
}
}