import java.io.*;
class shift
{
 int d=0,k=0,j=0,p=0,m=0;
 int a[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void man()throws IOException
    {
        a=new int[10];
        int e[]=new int[10];
        int o[]=new int[10];

        for(int i=0;i<10;i++)
        {
        System.out.println("Enter a no.");
        a[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0;i<10;i++)
        {
            if(a[i]%2==0)
            {
                e[k]=a[i];
                k++;
            }
            else
            {
                o[j]=a[i];
                j++;
            }
        }
        for(int i=0;i<k;i++)
        System.out.print(e[i]+",");
        
        for(int g=0;g<j;g++)
        System.out.print(o[g]+",");
        
        for(int q=0;q<10;q++)
        System.out.print(a[q]+",");
        
        
    }
}