import java.io.*;
class d
{
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
   System.out.println("Enter the no. of lines");
   int n=Integer.parseInt(bf.readLine());
   for(int i=1;i<=n;i++)
   {
    for(int j=1;j<=(n-i);j++)
    {
      System.out.print(" ");  
    }
    for(int j=0;j<i;j++)
    {
      System.out.print("a ");  
    }
    System.out.println();  
   }
  //////////////////////////////////////////////////////////////// 
   for(int i=n-1;i>=1;i--)
   {
     for(int j=0;j<(n-i);j++)
     {
       System.out.print(" ");  
    }
    for(int j=0;j<i;j++)
    {
      System.out.print("a ");  
    }
    System.out.println();
   }
  }
}
         