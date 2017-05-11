package APC_Comp;
import java.io.*;
public class matris
{
int small;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    void add() throws IOException
    {
        int a[][]=new int[3][3];
        int b[][]=new int[3][3];
        int c[][]=new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
           System.out.println("Enter the element of a");
           a[i][j]=Integer.parseInt(br.readLine());
            }
        }
    
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
           System.out.println("Enter the element of b");
           b[i][j]=Integer.parseInt(br.readLine());
            }
        }
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
        
        /*for(int i=0;i<c.length-1;i++)
        {
            small = c[i][i];
            for(int j=i+1;j<c.length-1;j++)
            {
                if(small > c[j][])
                {
                    small=c[j];
                }
                System.out.println("the smallest element is "+c[j]+"its position is "+(j+1));
            }
        }*/
        
        
        
    }
}
        