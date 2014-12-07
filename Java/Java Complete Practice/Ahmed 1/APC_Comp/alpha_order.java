package APC_Comp;
import java.io.*;
class alpha_order
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String x;
    void main()throws IOException
    {
    char a,y;
    System.out.println("Enter a word");
    x=br.readLine();
    int t=x.length();
    for(int i=65;i<=90;i++)
    {
        for(int j=0;j<t;j++)
        {
            a=x.charAt(j);
            if(a==(char)i||a==(char)(i+32))
            {
                System.out.print(a);
            }
        }
    }
}
}
            
            
            