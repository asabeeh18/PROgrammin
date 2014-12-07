package Decision;
import java .io.*;
class Telegram
{
 int p=1;
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
     System.out.println("Enter the Telegram");
     String s=br.readLine();
     int t=s.length();
     for(int i=0;i<t;i++)
     {
         if(s.charAt(i)==' ')
         {
             p=p+1;
            }
        }
        if(p<=15)
        {
            System.out.println("The charge is: Rs."+5);
        }
        if(p>15)
        {
            int x=p-15;
            System.out.println("The charge is: Rs."+(x+5));
        }
    }
}
       
            
            
         
         
         
         
         
         
         