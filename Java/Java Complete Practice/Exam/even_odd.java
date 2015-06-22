import java.io.*;
class large_no
{
 int d=0,k=0,s=0,p=0,m=0;
 int a[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void man()throws IOException
    {
        a=new int[20];
        for(int i=0;i<20;i++)
        {
        System.out.println("Enter a no.");
        int a[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0;i<20;i++)
        {
            if(a[i]%2==0)
            {
                s=a[i];
                
                
                
        