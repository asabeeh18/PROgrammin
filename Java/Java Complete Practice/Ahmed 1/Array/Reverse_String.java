package Array;
import java.io.*;
class Reverse_String
{
 String n;
 char m[];
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
   System.out.println("Enter the String");
   n=bf.readLine();
   int t=n.length();
   m=new char[t];
   t--;
   for(int i=0,j=t;i<=t;i++,j--)
   {
       m[i]=n.charAt(j);
   }
   for(int i=0;i<=t;i++)
   {
       System.out.print(m[i]);
    }
}
}
       
   
   
   
   