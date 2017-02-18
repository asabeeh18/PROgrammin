
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PartArray
{
    public static void main(String arp[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int a[]=new int[n];
        String s[]=br.readLine().split(" ");
        long sum=0;
        for(int i=0;i<n;i++)
        {
           a[i]=Integer.parseInt(s[i]);
           sum+=a[i];
        }
        double avg=sum/3.0;
        
        
    }
    
}