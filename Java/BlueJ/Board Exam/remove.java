import java.io.*;
class remove
{
 BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
  System.out.println("Enter d no. of lines");
  int l=Integer.parseInt(bf.readLine());
  int n[][]=new int[l][l];
  for(int j=0;j<l;j++)
  {
   System.out.println("Line no.:"+j);
   for(int i=0;i<l;i++)
    {
     System.out.print("Enter d digit ");
      n[j][i]=Integer.parseInt(bf.readLine());
    }
  }
   for(int i=0;i<l;i++)
   {
   for(int j=((l-i)-1);j<l;j++) //Style
   {
    System.out.print(n[i][j]+" ");
    }
   System.out.println("");
  }
 }
}
/*2 4 6 8 10
1 3 5 7 9
12 14 16 18 20
11 13 15 17 19
22 24 26 28 30 
-------------
17                   
1618
357
2468*/
