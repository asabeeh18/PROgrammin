import java.io.*;
class Digit
{ 
 
 public static void main(String args[])throws IOException
 {
     
     BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter d String") ;
    String s=bf.readLine();
    int l=s.length();
    String[]q={"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
    String c;
    for(int i=0;i<l;i++)
    {
     c=s.valueOf(s.charAt(i)); 
     for(int j=0;j<l;j++)
     {
      c=c+s.charAt(j);  
      for(int k=0;k<11;k++)
      {
       if(c.equalsIgnoreCase(q[k]))
       {
         System.out.println("Its a dig no. "+c);  
        }
     }
     c=s.valueOf(s.charAt(i));     
    }
   }
 }
}
    