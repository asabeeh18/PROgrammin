import java.util.*;
public class Milk
{
	public static int min(int a,int b)
	{
		return a<b?a:b;
	}
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		int t=r.nextInt();
		int n;
		while(t-->0)
		{
			n=r.nextInt();
			int a[][]=new int[5][n+1];
			int k[]={0,1,5,7,10};
			for(int i=0;i<=n;i++)
				a[1][i]=i;
			for(int i=2;i<=4;i++)
			{
				for(int j=1;j<=n;j++)
				{
					if(j>=k[i])
						a[i][j]=min(a[i-1][j],a[i][j-k[i]]+1);
                                        else 
                                            a[i][j]=a[i-1][j];
				}
			}
			System.out.println(a[4][n]);
		}
	}
}