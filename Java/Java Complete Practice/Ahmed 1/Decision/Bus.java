package Decision;
import java.io.*;
class Bus
{
  BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
  void main()throws IOException
  {
      System.out.println("Enter the Distance u want to travel");
      int x=Integer.parseInt(br.readLine());
      if(x<=5)
      {
          System.out.println("The fare is Rs. "+(4*x)+".00");
        }
      if(x>5 && x<=15)
      {
         System.out.println("The fare is Rs. "+(6*x)+".00");
        }
      if(x>15)
      {
          System.out.println("The fare is Rs. "+(8*x)+".00");
        }
    }
}
        
