import java.io.*;
class Geometry1_1

{
 
 public static void main(String args[])throws IOException
 {
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter d string ") ;
    String s=bf.readLine();
    int l=s.length();
    int n=l+(2*l)-1;
    for(int i=0;i<l;i++)
    {
    for(int j=0;j<=i;j++)
      {
       System.out.print(s.charAt(j)) ;
     }
     for(int j=0;j<(n-i)-1;j++)
     {
       System.out.print(s.charAt(i)) ;
     }
     for(int j=(i-1);j>-1;j--)
     {
       System.out.print(s.charAt(j)) ;
     }
     System.out.println();
    }
}
}
/*J J J J J J J 
  J a a a a a J 
  J a v v v a J 
  J a v a v a J 
  J a v v v a J 
  J a a a a a J 
  J J J J J J J */  
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  
// Tikona INcrease Speed ??THe        i have a circuit breaker plan oof tikona.So after downloading 2500mb the speed drops down from 2mbps to 64 kbps is there any way to increase the speed back to 2mbps or not let the Tikona people know how much i have downloaded.Secondly What is the use ofgoing in the MM210 page or to the modem settings page if it is of any good use please explain me how to do that