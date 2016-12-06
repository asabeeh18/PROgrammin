import java.util.*;
class Alien
{
	public static void main(String are[])
	{
		Scanner r=new Scanner(System.in);
		int n=r.nextInt();
		int re[][]=new int[n][2];
		for(int i=0;i<n;i++)
		{
			re[i][0]=r.nextInt();
			re[i][1]=r.nextInt();
		}
		int q=r.nextInt();
		for(int i=0;i<q;i++)
		{
			boolean b[]=new boolean[n];
			Arrays.fill(b,false);
			int c=0;
			int m=r.nextInt();
			for(int j=0;j<m;j++)
			{
				int a=r.nextInt();
				for(int k=0;k<n;k++)
				{
					if(a>=re[k][0] && a<=re[k][1])
					{
						if(!b[k])
						{
							c++;
							b[k]=true;
						}
					}
				}
			}
			System.out.println(c);
		}
	}
}