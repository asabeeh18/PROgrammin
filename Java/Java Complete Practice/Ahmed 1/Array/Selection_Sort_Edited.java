package Array;
import java.io.*;
class Selection_Sort_Edited
{
  int[] m(int n[])
 {
     int x=n.length;
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
        return n;
    }
}
         