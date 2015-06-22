package Array;
import java.io.*;
class Selection_Sort
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
      System.out.println("Enter Array Element "+i);
      n[i]=Integer.parseInt(bf.readLine());
     }
     int m,p;
     for(int i=0;i<x-1;i++)
     {
         m=n[i];
         p=i;
         for(int j=i+1;j<x;j++)
         {
             if(n[j]>m)
             {
                 m=n[j];
                 p=j;
                }
            }
            n[p]=n[i];
            n[i]=m;
        }
        for(int i=0;i<x;i++)
        {
            System.out.print(n[i]+",");
        }
    }
}
         