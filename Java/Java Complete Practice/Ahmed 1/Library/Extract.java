
package Library;
import java.io.*;
class Extract
{
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void accept()throws IOException
 {
     System.out.println("Enter A String");
     String a=bf.readLine();
     System.out.println("Enter A the no. of characters to b printed");
     int b=Integer.parseInt(bf.readLine());
     System.out.println("Enter the no. to Start from");
     int c=Integer.parseInt(bf.readLine());
     int d=a.length();
     c--;
     String z=a.substring(c,(b+c));
     System.out.println(z);
     
     
     
    }
}