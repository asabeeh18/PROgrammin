package Array;
import java.io.*;
class EvenArray
{
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
   System.out.println("Type an array size");
   int x=Integer.parseInt(bf.readLine());
   int n[]=new int [x];
   for(int i=0;i<x;i++)
   {
      System.out.println("Enter Array Element: "+i); 
      int l=Integer.parseInt(bf.readLine());
      n[i]=l;
   }
   for(int i=0;i<x;i++)
   {
       System.out.print(" "+n[i]);
   }
   System.out.println("\nthe even Arrays");
   for(int i=0;i<x;i++)
   {
     if(n[i]%2==0)
     {
         System.out.println(n[i]);
        }
   }
 }
}
   
       