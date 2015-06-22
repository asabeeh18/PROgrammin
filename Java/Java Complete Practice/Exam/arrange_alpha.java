import java.io.*;
class arrange_alpha
{
 int d=0,k=0,small=0,pos=0,m=0;
 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void man()throws IOException
    {
        
        
      System.out.println("Enter a string");
      String s=br.readLine();
      s=s.trim();
      int t=s.length();
      char a[]=new char[t];
      int b[]=new int[t];
      char c[]=new char[t];
      for(int i=0;i<t;i++)
      {
          a[i]=s.charAt(i);
          System.out.print(a[i]);
        }
        System.out.println();
       for(int i=0;i<t;i++)
       {
           b[i]=(int)a[i];
           
        }
        System.out.println();
        
        for(int i=0;i<=t-2;i++)
        {
            small=b[i]; 
            pos=i;
            for(int j=i+1;j<=t-1;j++)
            {
                if(small>b[j])
                {
                    small=b[j];
                    pos=j;
                }
            }
            b[pos]=b[i];
            b[i]=small;
        }
        
        
        for(int i=0;i<t;i++)
       {System.out.print(b[i]+", ");
        }
        
        for(int i=0;i<t;i++)
        {
              c[i]=(char)b[i]; 

        }
        
        System.out.println();

        for(int i=0;i<t;i++)
       {System.out.print(c[i]);
        }
        
        System.out.println();
        for(int i=t-1;i>=0;i--)
       {System.out.print(c[i]);
        }
        
    }
}
        