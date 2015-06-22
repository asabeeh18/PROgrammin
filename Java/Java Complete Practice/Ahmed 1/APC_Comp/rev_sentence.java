package APC_Comp;
import java.io.*;
class rev_sentence
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String x;
    void main()throws IOException
    {char b;b=0;
        String x,m,p;p="";m="";
    int t;
    System.out.println("Enter a sentence");
    x=br.readLine();
    x=x+" ";
    t=x.length();
    for(int i=0;i<t;i++)
    {
      b=x.charAt(i);
      if(b==' ')
      {
          p=p+" "+m;
          System.out.println("Every no.  "+p);
          m="";
          System.out.println("Each  "+m);
        }
        else
        m=b+m;
        System.out.println("Eacher  "+m);
    }
    System.out.println("Reversed String ====>");
    System.out.println(p);
}
}