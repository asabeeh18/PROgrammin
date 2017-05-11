package APC_Comp;
import java.io.*;
class matrix
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    void index()throws IOException
    {
        int a[][]=new int [3][3];
        for(int l=0;l<3;l++)
        {
            for (int j=0;j<3;j++)
            if(l==j)
                a[l][j]=1;
                else
                a[l][j]=0;
                
                for(int i=0;i<3;i++)
        {
            for (int g=0;g<3;g++)
            System.out.print(a[i][g]);
            System.out.println();
        }
    }
}
}
            
                