package APC_Comp;
import java.io.*;
class lower_left_half
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    void arr()throws IOException
    {
        
        System.out.println("enter no. of rows");
        int n=Integer.parseInt(br.readLine());
        System.out.println("enter no. of columns");
        int m=Integer.parseInt(br.readLine());
        int a[][]=new int[n][m];
        for(int i=0;i<n;i++)                //accepting
        {
            for(int j=0;j<m;j++)
            {
                a[i][j]=Integer.parseInt(br.readLine());
            }
        }
        
        for(int g=0;g<n;g++)            //printing
        {
            for(int h=0;h<m;h++)
            {
                System.out.print(a[g][h]+" ");
            }
            System.out.println();
        }
        
        for(int q=0;q<n;q++)
        {
            for(int w=0;w<=q;w++)
            {
                System.out.print(a[q][w]+" ");
            }
            System.out.println();
        }
        
                
    }
}
        
                
        