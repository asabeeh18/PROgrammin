import java.io.*;
class sec_largest_no

{
  int m=0,m2=0,s=0;
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
    System.out.println("Enter the no");
    String s=bf.readLine();
    int l=s.length();
    int n=Integer.parseInt(s);
    int m=0;
    int x=0;
    int n1;
    for(int i=0;i<l;i++)
    {
     n1=n%10;
     if(n1>m)
     {
       x=m;  
       m=n1;
    }
    n1=n/10;
  }
  System.out.println(x);
    
}
 void min()throws Exception
  {
    System.out.println("Enter the no");
    int n=Integer.parseInt(bf.readLine());
    
    while(n>0)
    {
        int d=n%10;
        
         m2=m;   
         m=d; 
         if(m>m2)
        {
            s=m2;
        }
        n=n/10;
        
    }
    System.out.println(s);
}

}
        