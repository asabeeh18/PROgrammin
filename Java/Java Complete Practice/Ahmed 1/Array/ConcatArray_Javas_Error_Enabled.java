package Array;
import java.io.*;


class ConcatArray_Javas_Error_Enabled
{
  char m[];
  int y;
  char l;
  char n[];
  int x;
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
   System.out.println("Type 1st array size");
   x=Integer.parseInt(bf.readLine());
   n=new char [x];
   for(int i=0;i<x;i++)
   {
      System.out.println("Enter Array1 Element: "+i); 
      l=(char)bf.read();
      n[i]=l;
   }
   
   System.out.println("Type 2nd array size");
   y=Integer.parseInt(bf.readLine());
   m=new char [y];
   for(int i=0;i<y;i++)
   {
      System.out.println("Enter Array2 Element: "+i); 
      l=(char)bf.read();
      m[i]=l;
   }
   
   char c[]=new char [x+y];
   for(int i=0;i<x;i++)
   {
       c[i]=n[i];
    }
    for(int i=0;i<y;i++)
    {
        c[i+x]=m[i];
    }
    System.out.println("the new Array is");
    for(int i=0;i<(x+y);i++)
    {
        System.out.print(" "+c[i]);
    }
 }
}      