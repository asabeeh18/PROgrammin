import java.io.*;
class largest

{
  int m=0,m2=0;
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
    System.out.println("Enter the no.");
    int n=Integer.parseInt(bf.readLine());
    
    while(n>0)
    {
        int d=n%10;
        if(d>=m)
        { 
         m2=m;
         m=d; 
        }
        n=n/10;
        
    }
    System.out.println(m);
}
}
        