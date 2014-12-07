package Array;
import java.io.*;
class Reverse_String_Array
{
 String n[],m[];
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
   System.out.println("Type an array size");
   int x=Integer.parseInt(bf.readLine());
   n=new String [x];
   m=new String[x];
   int k=x--;
   for(int i=0;i<x;i++)
   {
      System.out.println("Enter Array Element: "+i); 
      String l=bf.readLine();
      n[i]=l;
   }
   for(int i=1;i<x;i++,k--)
   {
       m[k]=n[i];
    }
    for(int i=0;i<x;i++)
    {
    System.out.println(m[i]); 
    }
  }
}
   
   
   