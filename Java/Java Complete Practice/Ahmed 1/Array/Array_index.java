package Array;
import java.io.*;
class Array_index
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
   System.out.println("Type the Array to Search");
   int s=Integer.parseInt(bf.readLine());
   c=0;
   System.out.println("The array element "+s+" Appears at index:");
   for(int i=0;i<x;i++)
   {
       if(n[i]==s)
       {
           System.out.println(i);
        }
    }
    
 }
}
           
   

