package Array;
import java.io.*;
class Linear_Search
{
 int n[],t,pos=0;
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
     System.out.println("Type an array size");
     int x=Integer.parseInt(bf.readLine());
     n=new int [x];
     for(int i=0;i<x;i++)
     {      
      System.out.println("Enter Array Element"+i);
      n[i]=Integer.parseInt(bf.readLine());
     }
     System.out.println("Enter THe no. to Search");
     int z=Integer.parseInt(bf.readLine());    
     for(int i=0;i<x-1;i++)
     {
         if(n[i]==z)
         {
          pos++;
        }
    }
    if(pos>0)
    {
        System.out.println("Variable found");
    }
    else
    {
        System.out.println("Variable not found");
    }
  }
}
        
        