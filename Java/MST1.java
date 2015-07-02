//http://www.spoj.com/problems/MST1/
class Solution
{
	public static int min(int a,int b)
	{
		if(a<b) return a;
		return b;
	}
	public static void main(String args[]) throws Exception
	{
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		int t=Integer.parseInt(r.readLine());
		int dp[]=new int[20000001];
		int j=0;
		while(j++<t)
		{
			int n=Integer.parseInt(r.readLine());
			
			//0 1 2 3 4
			//- 0 1 2 2
			if(dp[n]!=0)
			{
				System.out.println("Case "+j+": "+dp[n]);
				continue;
			}
			for(int i=2;i<=n;i++)
			{
				if(dp[i]!=0) continue;
				dp[i]=1+dp[i-1];
				if(i%2==0)
					dp[i]=(dp[i]<1+dp[i/2])?dp[i]:1+dp[i/2];
				if(i%3==0)
					dp[i]=(dp[i]<1+dp[i/3])?dp[i]:1+dp[i/3];
				//System.out.println(dp[i]);
			}
			System.out.println("Case "+j+": "+dp[n]);
		}
	}
}