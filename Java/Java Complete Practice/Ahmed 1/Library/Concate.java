package Library;
import java.io.*;
class Concate
{
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
     System.out.println("Enter the name");
     String s=bf.readLine();
     System.out.println("Enter the surname");
      String j=bf.readLine();
      System.out.println(s.concat(j));
    }
}