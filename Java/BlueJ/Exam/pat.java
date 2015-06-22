import java.io.*;
class pat

{
  int m=0,m2=0;
  int k=1;
  int f=0;
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
    System.out.println("Enter the no.");
    int n=Integer.parseInt(bf.readLine());
    
    for(int i=0;i<=n;i++)
    {
        for(int j=0;j<=i;j++)
        {
            System.out.print(i*j+" ");
            
        }
        System.out.println();
        
    }
    
    
}
}
        