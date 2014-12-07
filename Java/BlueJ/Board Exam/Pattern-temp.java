import java.io.*;
class Pattern

{
 
 public static void main(String args[])throws IOException
 {
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter d string ") ;
    String s=bf.readLine();
    int l=s.length();
    int n=l+(2*l)-1;
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<=i;j++)
      {
       System.out.println(s.charAt(j)) ;
     }
     for(int j=0;j<(n-i)-1;j++)
     {
       System.out.println(s.charAt(i)) ;
     }
     for(int j=(i-1);j>-1;j--)
     {
       System.out.println(s.charAt(j)) ;
     }
    }
}
}
/*J J J J J J J 
  J a a a a a J 
  J a v v v a J 
  J a v a v a J 
  J a v v v a J 
  J a a a a a J 
  J J J J J J J */  