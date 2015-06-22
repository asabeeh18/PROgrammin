package Array;
import java.io.*;
class Binary_Search
{
 int n[],a[],t,pos=0;
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
     System.out.println("Type an array size");
     int x=Integer.parseInt(bf.readLine());
     a=new int [x];
     for(int i=0;i<x;i++)
     {      
      System.out.println("Enter Array Element"+i);
      a[i]=Integer.parseInt(bf.readLine());
     }
     Selection_Sort_Edited s1=new Selection_Sort_Edited();
     n=s1.m(a);
     System.out.println("Enter THe no. to Search");
     int z=Integer.parseInt(bf.readLine());
     int lb=0;
     int ub=n.length-1;
     int pos=-1;
     int mid;
     while(pos==-1&&(ub>=lb))
     {
      mid=(ub+lb)/2;
      if(n[mid]==z)
      {
          pos=mid;
        }
        if(n[mid]>z)
        {
          lb=mid+1;
        }
        else
        {
            lb=mid-1;
        }
    }
    if(pos==-1)
    {
        System.out.println("It doesnt exist");
    }
    else
    {
        System.out.println("It exists");
    }
  }
}
        