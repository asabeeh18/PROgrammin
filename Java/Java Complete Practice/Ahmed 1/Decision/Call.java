package Decision;
import java.io.*;
class Call
{
  double x,d,g;
  BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
  void main()throws IOException
  {
      double c,f;
      System.out.println("Enter the no. of calls you made");
      x=Double.parseDouble(br.readLine());
      c=x-120;
      d=c-1000;
      if(c==0)
      {
       System.out.println("Your bill amount is Rs.380.00");  
      }    
    if(c>0 && c<=1000)
    {
        f=c+380;
        System.out.println("Your bill amount is: "+f);
    }
    if(d>0)
    {
        g=(d*1.25)+380;
      System.out.println("Your bill is: "+g) ;
    }
}
}
     