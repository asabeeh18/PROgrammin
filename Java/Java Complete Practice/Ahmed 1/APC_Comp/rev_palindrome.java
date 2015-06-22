package APC_Comp;
import java.io.*;
class rev_palindrome
{
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String x,m,n;
    void main()throws IOException
    {
        String x,g=""; 
    int y;
    System.out.println("Enter a word");
    x=br.readLine();
    y=x.length();
    for(int i=y-1;i>=0;i--)
    {
        System.out.print(x.charAt(i));
        char h=x.charAt(i);
        g=g+h;
    }
    if(g.equalsIgnoreCase(x))
    {
        System.out.println("\nPalindrome");
    }
}
}
    
    