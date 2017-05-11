import java.util.*;
class P28
{
 public static void main(String args[])
 {
  Scanner src=new Scanner(System.in);
  
  System.out.print("Enter a number : ");
  int n=src.nextInt();
  int s=0;  
  for(int j=1;j<=n;j++)
  {
	s=0;
   for(int i=1;i<=j/2;i++)
   {
    if(j%i==0)
    {
     s=s+i;
    }
   }
   
   if(s==j)
   {
    System.out.print(j+" ");
   }
  }   
  System.out.println();  
 }  
}