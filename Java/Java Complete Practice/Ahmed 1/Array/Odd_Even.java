package Array;
import java.io.*;
class Odd_Even
{
 int pos=0,neg=0,even=0,odd=0;
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
     System.out.println("Type an array size");
     int x=Integer.parseInt(bf.readLine());
     int n[]=new int [x];
     for(int i=0;i<x;i++)
     {         
     System.out.println("Type the array element "+i);
     int l=Integer.parseInt(bf.readLine());
      n[i]=l;
     }
     for(int i=0;i<x;i++)
     {
        if(n[i]>0)
        {
            pos++;
        }
        if(n[i]<0)
        {
            neg++;
        }
        if(n[i]%2==0)
        {
            even++;
        }
        if(n[i]%2!=0)
        {
            odd++;
        }
    }
    System.out.println("odd nos. "+odd+"\nEven nos. "+even+"\npositive integers "+pos+"\nNegative integers "+neg);
 }
}
          
        
        
        
        
        