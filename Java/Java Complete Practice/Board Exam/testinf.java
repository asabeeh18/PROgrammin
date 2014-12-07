import java.io.*;
class testinf

{
 
 public static void main(String args[])throws IOException
 {
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter d string ") ;
    String s=bf.readLine();
    int l=s.length();
    int n=(2*l)-1;
    System.out.println();
    for(int i=0;i<l;i++)
    {
    for(int j=0;j<=i;j++)
      {
       System.out.print(s.charAt(j)) ;
     }
     for(int j=0;j<(n-i)-1;j++)
     {
       System.out.print(s.charAt(i)) ;
     }
     System.out.println();
    }}}
     