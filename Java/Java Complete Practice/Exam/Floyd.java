import java.io.*;
class Floyd
{
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
   System.out.println("Enter the last no.");
   int n=Integer.parseInt(bf.readLine());
   int p=1;
   for(int i=1;i<=p;i++)
   {
     for(int j=1;j<=i;j++)
     {  
      System.out.print(p);
      p=p+1;
    }
    System.out.println();
   
  }
 }
}