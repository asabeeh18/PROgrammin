//http://www.spoj.com/problems/BACKPACK/
class Solution
{
	public static void main(String arp[])
	{
		java.io.BufferedReader r=new java.io.BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLIne());
		while(t-->0)
		{
			String split[]=r.readLine().split(" ");
			int vm=Integer.parseInt(split[0])/10;
			int n=Integer.parseInt(split[1]);
			
			int[] c=new int[n],v=new int[n],mainItem=new int[n],anotherFlist=new int[n];
			int[][] bag=new int[n+1][vm+1],attach=new int[n-1][3];
			int mItems,aItems=0,u;
			for(int i=0;i<n;i++)
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
					attach[u-1][anotherFlist[u-1]=i;
					anotherFlist[u-1]++;
				}
			}
			for(int i=mainItem[0];i<mItems;i++)
			{
				for(int j=0;j<vm;j++)
				{
					if(v[i]>=j)
						max(bag[i-1][j],v[i]*c[i]+(anotherFlist[i]>0)?
													((anotherFlist[i]>1)?
														(attach[i][anotherFlist[i]]+attach[i][anotherFlist[i-1]]):
														(attach[i][anotherFlist[i]])
													):
													(0)
													);
				}
			}
		seperate attachmentsand main items 
		chk if the main item with the attachmnts has any advtg (not the other way around)
		
		
		bag[i][j]=bag[i-1][j]   ,v[i-1]*c[i-1]+ possible attachments put items for specific 'j' jitna bharta hai bhardo with attachments
		}