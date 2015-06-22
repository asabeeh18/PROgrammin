import java.io.*;
class seru
{
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
      int sum=0;
      int p=0;
    System.out.println("Enter the no.");
    int n=Integer.parseInt(bf.readLine());
    
    for(int i=n;i>0;i=i-2)
    {
        for(int k=0;k<=p;k++)
        {
            System.out.print(" ");
        }
        
        for(int j=1;j<=i;j++)
        {
            System.out.print("*");
        }
        
        System.out.println();
        p++;
    }
}
}
        
           