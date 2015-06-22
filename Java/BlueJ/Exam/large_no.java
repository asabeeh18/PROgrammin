import java.io.*;
class large_no
{
 int d=0,k=0,small=0,pos=0,m=0;
 int a[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void man()throws IOException
    {
        a=new int[100];
        System.out.println("Enter a no.");
        int n=Integer.parseInt(br.readLine());
        while(n>0)
        {
            d=n%10;
            a[k]=d;
            k++;
            n=n/10;
        }
        
        System.out.println("length= "+k);
        for(int i=k-1;i>=0;i--)
        {
            System.out.println("array "+i+"="+a[i]);
        }
        
        
        for(int i=0;i<=k-2;i++)
        {
            small=a[i]; 
            pos=i;
            for(int j=i+1;j<=k-1;j++)
            {
                if(small>a[j])
                {
                    small=a[j];
                    pos=j;
                }
            }
            a[pos]=a[i];
            a[i]=small;
        }
        
        for(int i=0;i<k;i++)
        {
            System.out.print(a[i]+",");
        }
        
        System.out.println("largest no. is "+a[k-1]+"\n smallest is "+a[1]);
    }
}
    