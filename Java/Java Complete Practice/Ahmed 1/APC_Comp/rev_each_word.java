package APC_Comp;
import java.io.*;
class rev_each_word
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    void add() throws IOException
    {
        int p=0;
        System.out.println("Enter a sentence");
        String s=br.readLine();
        int t=s.length();
        System.out.println("rev string");
        for(int i=0;i<t;i++)
        {
            if(s.charAt(i)==' '||i==t-1)
            {
                for(int j=i;j>=p;j--)
                {
                    System.out.print(s.charAt(j));
                }
                p=i;
            }
            
        }
    }
}
                