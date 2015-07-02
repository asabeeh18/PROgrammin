//http://www.codechef.com/problems/MARCHA1/
//TODO reduce mem consumption
class Solution
{
	public static void main(String args[]) throws Exception
	{
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		int t=Integer.parseInt(r.readLine());
		while(t-->0)
		{
			String split[]=r.readLine().split(" ");
			int n=Integer.parseInt(split[0]);
			int m=Integer.parseInt(split[1]);
			boolean money[][]=new boolean[n+1][m+1];
			int mon[]=new int[n];
			int sum;
			for(int i=0;i<n;i++)
			{
				mon[i]=Integer.parseInt(r.readLine());
			}
			
			for(int i=0;i<=n;i++)
			{
				for(int j=0;j<=m;j++)
				{
					if(j==0)
						money[i][j]=true;
					else if(i==0 && j!=0)
						continue;
					//if(mon[i]==j)
						//money[i][j]=true;
					else
						money[i][j]= money[i-1][j] ||(j-mon[i-1]>=0) && money[i-1][j-mon[i-1]];
					//money[i][j]=money[i-1][j-mon[i-1]] || money[i-1];
				}
			}
			System.out.println(money[n][m]?"Yes":"No");
		}
	}
}