package Library;
import java.io.*;
class rec
{
  int k=0,q=0;
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws IOException
  {
      System.out.println("Enter a sentence");
      String x=bf.readLine();
      x=x.trim();
      int l=x.length();
      for(int i=0,k=0;i<=l-1;i++)
      {
          if(x.charAt(i)==' '||i==l-1)
          {
            String word=x.substring(k,i);
            int w=word.length();
            w--;
            for(int t=w;t<=0;t--)
            {
             System.out.println(word.charAt(t));
            }
              k=i+1;
          }           
        }
        System.out.println("bye");
        
    }
}
       
        
        
        
        