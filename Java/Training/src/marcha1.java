//http://www.codechef.com/problems/MARCHA1/
class marcha1
{
	public static void display(boolean money[][])
	{
		for(int i=0;i<money.length;i++)
		{
			for(int j=0;j<money[0].length;j++)
				System.out.print(money[i][j]+" ");
			System.out.println();
		}
		System.out.println("---");
	}
	public static void main(String args[]) throws Exception
	{
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		int t=Integer.parseInt(r.readLine());
		while(t-->0)
		{
			//System.out.println(t);
			String split[]=r.readLine().split(" ");
			int n=Integer.parseInt(split[0]);
			int m=Integer.parseInt(split[1]);
			boolean money[][]=new boolean[2][m+1];
			int mon[]=new int[n];
			int sum;
			for(int i=0;i<n;i++)
			{
				mon[i]=Integer.parseInt(r.readLine());
			}
			int c=1,o=0,k;
			for(int i=0;i<=n;i++)
			{
				for(int j=0;j<=m;j++)
				{
					k=c;
					c=o;
					o=k;
					if(j==0)
						money[c][j]=true;
					else if(i==0 && j!=0)
						continue;
					//if(mon[i]==j)
						//money[i][j]=true;
					else
						money[c][j]= money[o][j] ||(j-mon[i-1]>=0) && money[o][j-mon[i-1]];
					//money[i][j]=money[i-1][j-mon[i-1]] || money[i-1];
				//	display(money);
				}
				System.out.println("=====");
			}
			System.out.println(money[c][m]?"Yes"+t:"No"+t);
		}
	}
}