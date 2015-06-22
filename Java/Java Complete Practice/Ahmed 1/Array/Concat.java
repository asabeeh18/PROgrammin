package Array;
import java.io.*;
class Concat
{
  char m[]={'a','b','c'};
  int y=3;
  char l;
  char n[]={'d','e','f'};
  int x=3;
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {  
   char c[]=new char [x+y];
   for(int i=0;i<y;i++)
   {
       c[i]=m[i];
    }
    for(int i=0;i<x;i++)
    {
        c[i+x]=n[i];
    }
    System.out.println("the new Array is");
    for(int i=0;i<(x+y);i++)
    {
        System.out.print(" "+c[i]);
    }
 }
}      