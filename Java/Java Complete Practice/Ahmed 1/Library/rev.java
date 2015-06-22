package Library;
import java.io.*;
class rev
{
    String j;
    int f;
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws IOException
  {
      System.out.println("Enter a sentence");
      String x=bf.readLine();
      int t=x.length();
      t--;
      int k=0;
      for(int ctr=1;ctr<=t;ctr++)
      {
          f=ctr;
          System.out.print("yo");
          if(x.charAt(ctr)==' '||ctr==t)
          {
              j=x.substring(k,ctr);
              System.out.println("oh");
              int n=j.length();
              n--;
              k=k+f;
              for(int m=n;m>=0 && m<=n ;m--)
              {
                 System.out.print(j.charAt(m));
                 System.out.println("hai");
                }
                System.out.print(" ");
            }
        }
         System.out.print("bye");
        
    } 
}
