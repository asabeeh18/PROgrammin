//https://www.codechef.com/VIT2016/problems/SMPLSUM
class SimpleSum
{
	public static void main(String ar[])
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in))l
		int t=Integer.parseInt(r.readLine());
		while(t-->0)
		{
			int n=Integer.parseInt(r.readLine());
			double sum=0;
			for(int i=1;i<=n;i++)
			{
				sum+=(1.0/hcf(n,i));
			}
			System.out.println((n*sum)+"");
		}
	}
	int hcf(int n1, int n2)
	{
		if (n2!=0)
		   return hcf(n2, n1%n2);
		else 
		   return n1;
	}
}