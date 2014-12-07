import java.io.*;
class arr_pat
{int t=5;
 int d=0,k=0,small=0,pos=0,m=0;
 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void man()throws IOException
    {
        System.out.println("enter rows");
        int x=Integer.parseInt(br.readLine());
        System.out.println("enter columns");
        int y=Integer.parseInt(br.readLine());
        int a[][]=new int[x][y];
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                System.out.print("enter element");
                a[i][j]=Integer.parseInt(br.readLine());
            }
        }
        t=x;
        
         for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        
        for(int i=0;i<x;i++)
        {
            for(int j=y-1;j>0;j--)
            {
                for(int k=t;k>0;k--)
                {
                    System.out.print(" ");
                }
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
            t=x-1;
        }
    }
}
            
        