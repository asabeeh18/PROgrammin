import java.io.*;
class Mirrorsuper
{
 
 public static void main(String args[])throws IOException
 {
     BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter d no of line") ;
    int l=Integer.parseInt(bf.readLine());
    System.out.println("Enter d ") ;
    String s=bf.readLine();
      for(int i=0;i<l;i++)
      {
        for(int j=0;j<l-i;j++)
        {
         System.out.print(" ");
        }
        for(int j=0;j<=i;j++)
        {
         System.out.print(s);
        }
        for(int j=0;j<=i;j++)
        {
         System.out.print(s);
        }
        
       System.out.println();
}
        for(int i=l;i>0;i--)
        {
         for(int j=0;j<l-i;j++)
        {
         System.out.print(" ");
        }
        for(int j=0;j<=i;j++)
        {
         System.out.print(s);
        }
        for(int j=0;j<=i;j++)
        {
         System.out.print(s);
        }
        System.out.println();
    }
}}
