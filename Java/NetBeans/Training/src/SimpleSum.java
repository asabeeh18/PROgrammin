
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.codechef.com/VIT2016/problems/SMPLSUM
class SimpleSum
{
	public static void main(String ar[]) throws IOException
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		while(t-->0)
		{
			int n=Integer.parseInt(r.readLine());
			long sum=0;
			for(int i=1;i<=n;i++)
			{
                if(n%i==0)
                    sum+=n/i;
                else
                    sum+=(n/hcf(n,i));
			}
			System.out.println((sum)+"");
		}
	}
	static int hcf(int n1, int n2)
	{
		if (n2!=0)
		   return hcf(n2, n1%n2);
		else 
		   return n1;
	}
}
//10000000;//