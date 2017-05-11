import java.io.*;
class Sqrt
{
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws Exception
 {
    int m[][]=new int[9][9]; 
    int x=9;
    for(int i=0;i<9;i++)
    {
     m[0][i]=i/10; 
    }
    for(int i=0;i<9;i++)
    {
     m[i][0]=i; 
    }
    for(int i=0;i<x;i++)
    {
     for(int j=0;j<x;j++)
     {
      System.out.print(Math.sqrt(i+j)+" ");
     }
   System.out.println();
    }
}
}