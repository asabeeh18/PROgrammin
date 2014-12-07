package APC_Comp;
import java.io.*;
class Binary
{
int n,tmp=0,a[];
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    void search() throws IOException
    {
        System.out.println("Enter the no.(<=100) of students");
        int n=Integer.parseInt(br.readLine());
        a=new int[n];
        
        for(int i=0;i<n;i++)
        {
            System.out.println("enter the marks for Student no. "+(i+1));
            a[i]=Integer.parseInt(br.readLine());
        }
        
        for(int i=0;i<=n;i++)   //sorting
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
        
        for(int i=0;i<n;i++)
        System.out.print(a[i]+",");
        binary_search();
    }
    
        
        
        void binary_search() throws IOException
        {
            System.out.println("Enter the element to search for:");
            int e=Integer.parseInt(br.readLine());
            int L=0;
            int g=a.length;
            int U=g-1;
            while(L<=U)
            {
                int M=(U+L)/2;
                if(a[M]==e)
                {
                    System.out.println("Element found at "+(M+1));
                    break;
                }
                
                else if(a[M]<e)
                {
                    L=M+1;
                }
                else if(a[M]>e)
                {
                    U=M-1;
                }
               
            }
            decide();
        }
        
        void decide()throws IOException
        {
            System.out.println("Do u want to continue searching?");
            System.out.println("press y for YES and n for NO");
            char d=(char)br.read();
            if(d=='y'||d=='Y')
            {
                binary_search();
            }
            else
            {
            }
        }
    }

        
        