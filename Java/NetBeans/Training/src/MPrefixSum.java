
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.codechef.com/FEB16/problems/STROPR
class MPrefixSum
{
	public static void main(String ar[]) throws IOException
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		String line=r.readLine();
		int t=Integer.parseInt(line);
        while(t-->0)
        {
            String s[]=r.readLine().split(" ");
            int n=Integer.parseInt(s[0]);
            int pos=Integer.parseInt(s[1])-1;
            int round=Integer.parseInt(s[2]);
            s=r.readLine().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
            }
            int sum=a[pos];
            for(int i=pos-1,factor=round;i>=0;i--,factor++)
            {
                sum+=a[i]*factor;
            }
            System.out.println(sum);
        }
	}
}