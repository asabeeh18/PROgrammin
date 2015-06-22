import java.io.*;
class Cg
{
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
    System.out.println("Enter the no.");
    int n=Integer.parseInt(bf.readLine());
    String x=String.valueOf(n);
    int l=x.length();
    int j[]=new int[l];
    for(int i=l--;i>=0;i++)
     {
      j[l]=n%10;  
      n=n/10;
    }
    for(int i=0;i<l;i++)
    {
      System.out.println(j[i]);
    }
    
}
}