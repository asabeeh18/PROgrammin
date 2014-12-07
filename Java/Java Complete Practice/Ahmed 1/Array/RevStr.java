package Array;
import java.io.*;
class RevStr
{
 String n;
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
   System.out.println("Enter a String");
    n=bf.readLine();
   int t=n.length();t--;
   for(int i=t;i<=0;i++)
   {
       System.out.print(n.charAt(i));
    }
  }
}
       