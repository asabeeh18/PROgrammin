package APC_Comp;
import java.io.*;
public class vowel
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String x;
    void main()throws IOException
    {char b,c;c=0;
        String x,m,p;p="";m="";
    int t,y,u,o,k;k=0;
    System.out.println("Enter a word");
    x=br.readLine();
    t=x.length();
    for(int i=0;i<t;i++)
    {
        b=x.charAt(i);
     if(b=='o'||b=='a'||b=='u'||b=='i'||b=='e')
     {
         System.out.println(b);
        }
    }
}
}