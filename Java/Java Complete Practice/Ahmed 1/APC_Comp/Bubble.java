package APC_Comp;
import java.io.*;
class Bubble
{
int tmp;

    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    void sort() throws IOException
    {
        System.out.println("Enter no. of nos. you want to enter");
        int n=Integer.parseInt(br.readLine());
        int a[]=new int [n];
        
        for(int i=0;i<n;i++)        //accepting the elements
        {
            System.out.println("Enter "+i+"st no.");
            a[i]=Integer.parseInt(br.readLine());
        }
        
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(a[j]<a[j+1])
                {
                    tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }
        System.out.println("The sorted array in descending order is =>");
        
        for(int i=0;i<a.length;i++)     //PRINTING  
        {
            System.out.print(a[i]+", ");
        }
    }
}
                
                
        
        