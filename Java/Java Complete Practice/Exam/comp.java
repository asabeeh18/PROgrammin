import java.io.*;
class comp
{
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main(String args[])throws Exception
  {
      int sum=0;
    System.out.println("Enter the no.");
    int n=Integer.parseInt(bf.readLine());
    
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=i;j++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
    
    for(int i=n-1;i>0;i--)
    {
        for(int j=1;j<=i;j++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}
}