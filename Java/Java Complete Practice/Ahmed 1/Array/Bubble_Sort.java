package Array;
import java.io.*;
class Bubble_Sort
{
 int n[],t;
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
     for(int i=0;i<x-1;i++)
     {
         for(int j=0;j<x-1;j++)
         {
             if(n[j]>n[j+1])
              {
                 t=n[j];
                 n[j]=n[j+1];
                 n[j+1]=t;
                }
            }
        }
        for(int i=0;i<x;i++)
        {
            System.out.print(n[i]+",");
        }
    }
}
     