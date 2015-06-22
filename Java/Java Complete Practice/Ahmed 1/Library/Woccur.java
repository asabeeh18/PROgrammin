package Library;
import java.io.*;
class Woccur
{
  int k=0,q=0;
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws IOException
  {
      System.out.println("Enter a sentence");
      System.out.println("You must end the sentence with a full stop");
      String x=bf.readLine();
      x=x.trim();
      int l=x.length();
      System.out.println("Enter the word you want to search");
      String s=bf.readLine();
      for(int i=0,k=0;i<=l-1;i++)
      {
          if(x.charAt(i)==' '||i==l-1)
          {
             
             String word=x.substring(k,i);
              System.out.println("The word is "+word);
              System.out.println(word.charAt(word.length()-1));
               System.out.println(s.charAt(s.length()-1));
              if(word.equalsIgnoreCase(s))
              {
                 System.out.println("word found");
                 q++;
                }             
              k=i+1;
          }           
        }
        System.out.println(q);
        
    }
}
       
        
        
        
        