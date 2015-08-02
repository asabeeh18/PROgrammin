//http://www.codechef.com/JULY15/problems/MCHEF
import java.util.Arrays;
class Solution
{
	public static void main(String ar[]) throws Exception
	{
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		String s;
		while(t-->0)
		{
			s=r.readLine();
			String ss[]=s.split(" ");
			int n=Inter.parseInt(ss[0]),k=Inter.parseInt(ss[1]),m=Inter.parseInt(ss[2]);
			s=r.readLine();
			ss=s.split(" ");
			
			int a[]=new int[n];
			int sum=0;
			for(int i=0;i<n;i++)
			{
				a[i]=Integer.parseInt(ss[i]);
				sum+=a[i];
			}
			
			
			int[][] bag=new int[m+1][k+1];
			Arrays.fill(bag[0],sum);
			for(int i=1;i<=m;i++)
			{
				s=r.readLine();
				ss=s.split(" ");
				int l=Inter.parseInt(ss[0])-1,r=Inter.parseInt(ss[1])-1,c=Inter.parseInt(ss[2]);
				for(int j=0;j<=k;j++)
				{
					if(j<c)
					{
						bag[i][j]=bag[i-1][j];
						continue;
					}
					
					min(l,r,
								