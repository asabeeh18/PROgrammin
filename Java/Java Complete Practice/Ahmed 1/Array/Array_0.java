package Array;
import java.io.*;
class Array_0
{
int c;
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
   c=0;
   for(int i=0;i<x;i++)
   {
       if(n[i]==0)
       {c++;}
    }
    System.out.println("The array element 0 Appears "+c+" times");
 }
}
           
   

