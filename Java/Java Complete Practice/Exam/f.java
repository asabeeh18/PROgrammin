import java.io.*;
class f
{
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
   System.out.println("Enter the n");
   int n=Integer.parseInt(bf.readLine());
   double sum=0,s=1;
   for(int i=2;i<=n;i++)
   {
       s=s+i;
     sum=sum+1/s;
       
    }
    System.out.println(sum);
  }
}





















        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        