package Array;
import java.io.*;
class Tilluser
{
int c;
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
   for(String z="y";z=="y";)
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
   for(int i=0;i<x;i++)
   {
       if(n[i]==s)
       {c++;}
    }
    System.out.println("The array element "+s+" Appears "+c+" times");
    System.out.println("Du u want to do this whole operation once more  y/n");
     z=bf.readLine();
}
 }
}
           
   

