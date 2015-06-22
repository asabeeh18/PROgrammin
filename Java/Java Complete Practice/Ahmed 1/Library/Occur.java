package Library;
import java.io.*;
class Occur
{
  int k=0;
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws IOException
  {    
      System.out.println("Enter a word");
      String x=bf.readLine();
      int l=x.length();
      System.out.println("Enter the letter u want 2 search for");
      char c=(char)bf.read();
      for(int i=0;i<=l--;i++)
      {
          if(x.charAt(i)==c)
         {
             k++;
            }
        }
        System.out.println("The no. of times  "+c+" occurs is  "+k);
    }
}
      