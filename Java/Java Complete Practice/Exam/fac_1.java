import java.io.*;
class fac_1

{
  int m=0,m2=0,p=1;
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void min()throws Exception
  {
    System.out.println("Enter the no.");
    m=Integer.parseInt(bf.readLine());
    for(int i=1;i<=m;i++)
    {
        for(int j=i;j<=i;j++)
        {
        p=p*i;
        }
        m2=m2+p;
        
    }
System.out.print(m2);
    
}
}