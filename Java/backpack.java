//http://www.spoj.com/problems/BACKPACK/
class Baackpack
{
	public static int minjnotdone=9999999;
	//vol array,size left,attach array[],nombr of attachments
	public static int bestMatch(int[] vol,int[] c ,int j,int attach[],int n,int bag[])
	{
		if(j==0) return 0;
		if(n==0) return bag[j];
		if(minjnotdone<j) return bag[j];
		
		int sack[][]=new int[5][j+1];
		for(int i=1;i<=n+1;i++)
		{
			for(int k=0;k<=j;k++)
			{
				if(k==0)
				{
					sack[i][j]=0;
					continue;
				}
				if(i<=n)
				{if(j>=vol[attach[i-1]] && i<4)
				{
					sack[i][j]=max(sack[i-1][j],vol[attach[i-1]]*c[attach[i-1]]);
				}}
				else if(j>=bag[j] && i==n+1)
				{
					sack[i][j]=max(sack[i-1][j],bag[j]);
				}
				else if(vol[attach[i-1]]>j)
				{
					if(minjnotdone>vol[attach[i-1]])
						minjnotdone=vol[attach[i-1]];
				}
			}
			
		}
		return sack[n][j];
	}
	public static int max(int a,int b)
	{
		return a>b?a:b;
	}
	public static void main(String arp[]) throws Exception
	{
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		while(t-->0)
		{
			String split[]=r.readLine().split(" ");
			int vm=Integer.parseInt(split[0])/10;
			int n=Integer.parseInt(split[1]);
			
			int[] c=new int[n+1],v=new int[n+1],mainItem=new int[n+1],anotherFlist=new int[n+1];
			int[][] bag=new int[n+1][vm+1],attach=new int[n+1][3];
			int mItems=1,aItems=0,u;
			for(int i=1;i<=n;i++)
			{
				split=r.readLine().split(" ");
				v[i]=Integer.parseInt(split[0])/10;
				c[i]=Integer.parseInt(split[1]);
				u=Integer.parseInt(split[2]);
				if(u==0)
				{
					mainItem[mItems]=i;
					mItems++;
				}
				else
				{
					attach[u][anotherFlist[u]]=i;
					anotherFlist[u]++;
				}
			}
			int k=1;
			for(int i=1;i<=n;i++)
			{
				minjnotdone=9999999;
				if(i!=mainItem[k])		
				{
				for(int j=1;j<=vm;j++)
					bag[i][j]=bag[i-1][j];
				}
				else
				{
					for(int j=1;j<=vm;j++)
					{
						if(j>=v[i])
						{
							bag[i][j]=max(bag[i-1][j],v[i]*c[i]+bestMatch(v,c,j-v[i],attach[i],anotherFlist[i],bag[i-1]));	
						}
						else
							bag[i][j]=bag[i-1][j];
					}
					k++;
				}
			}
			System.out.println(bag[n][vm]);
			/*
		seperate attachmentsand main items 
		chk if the main item with the attachmnts has any advtg (not the other way around)
		
		
		bag[i][j]=bag[i-1][j]   ,v[i-1]*c[i-1]+ possible attachments put items for specific 'j' jitna bharta hai bhardo with attachments
			*/
		}
	}
}