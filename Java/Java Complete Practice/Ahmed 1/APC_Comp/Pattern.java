package APC_Comp;
import java.io.*;
class Pattern
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String x;
    void main()throws IOException
    {
    int a,y;
    System.out.println("Enter a word");
    x=br.readLine();
    x=" "+x;
    y=x.length();
    System.out.println(x);
    System.out.println(y);
    for(int i=1;i<=y;i++)
    {
        System.out.println(x.substring(1,i));
    }
}
}