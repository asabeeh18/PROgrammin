package APC_Comp;
import java.io.*;
public class three_in_1
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String x;
    void main()throws IOException
    {char b,c;c=0;
        String x,m,d;m="";d="";
    int t,y,u,o,k,p,q,w,e;k=0;
    p=0;q=0;k=0;u=0;y=0;
    System.out.println("Enter a word");
    x=br.readLine();
    t=x.length();
    for(int i=0;i<t;i++)
    {
        b=x.charAt(i);
     if(b=='o')
     {
      p++;
    }
    if(b=='a')
     {
      q++;
    }
    if(b=='e')
     {
      k++;
    }
    if(b=='u')
     {
      u++;
    }
    if(b=='i')
     {
      y++;
    }
}
System.out.println("No. of vowels: "+(u+y+k+p+q));
   
//reversing
for(int i=t-1;i>=0;i--)
    {
        c=x.charAt(i);
        d=d+c ;
        
    }
    System.out.println("Reverse string: "+d);
    
    //total characters
    System.out.println("Total no. characters are: "+(x.length()));
    
 }
}
