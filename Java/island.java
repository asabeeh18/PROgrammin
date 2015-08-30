//https://www.codechef.com/problems/CD1IT5
class UF
{
	public static int[] a,rank;
	public static int find(int x)
	{
		if(a[x]!=x)
			a[x]=find(a[x]);
		//System.out.println(x);
		return a[x];
	}
	public static void merge(int x,int y)
	{
		int xx=find(x),yy=find(y);
		//System.out.println(yy+":"+xx);
		if(rank[xx]>rank[yy])
		{
			int t=xx;
			xx=yy;
			yy=t;
		}
		if(rank[xx]==rank[yy])
			rank[yy]++;
		a[xx]=yy;
		//System.out.println(yy+":"+a[xx]);
	}
	public static void main(String ar[])
	{
		java.util.Scanner r=new java.util.Scanner(System.in);
		int n=r.nextInt(),q=r.nextInt();
		a=new int[n+1];
		rank=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			a[i]=i;
		}
		int x,y,s;
		while(q-->0)
		{
			s=r.nextInt();
			x=r.nextInt();
			y=r.nextInt();
			if(s==0)
			merge(x,y);
			else if(s==1)
			{
				if(find(x)==find(y))
				{
					System.out.println("Yes");
				}
				else
				System.out.println("No");
			}
		}
	}
}	