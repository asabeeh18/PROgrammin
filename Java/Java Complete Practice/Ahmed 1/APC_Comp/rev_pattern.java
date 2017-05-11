package APC_Comp;
import java.io.*;
class rev_pattern
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
    k=t;
    for(int i=0;i<t;i++)
    {
        for(int j=1;j<=k;j++)
        {
            b=x.charAt(i);
            System.out.print(b+" ");
        }k=k-1;
        System.out.println();
        
    }
}
}
        