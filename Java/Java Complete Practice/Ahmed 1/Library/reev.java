package Library;

import java.io.*;
class reev
{
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws IOException
  {
      System.out.println("Enter a sentence");
      String x=bf.readLine();
      int p=0;
      int t=x.length();
      
      for(int i=0;i<t;i++)
      {
          int v=(int)x.charAt(i);
          
          if(v==32||i==t-1)
          {
              for(int j=i-1;j>=p;j--)
              {
                  System.out.print(x.charAt(j));
                }
                System.out.print(" ");
                p=i+1;
            }
        }
    }
}
