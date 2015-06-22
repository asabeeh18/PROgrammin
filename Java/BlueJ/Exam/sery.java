import java.io.*;
class sery
{
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
      int sum=0;
    System.out.println("Enter the no.");
    int n=Integer.parseInt(bf.readLine());
    
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=i;j++)
        {
            System.out.print(j);
                sum=sum+j;
            
            
            
        }
        System.out.print(" "+sum);
        sum=0;
        System.out.println();
    }
}
}