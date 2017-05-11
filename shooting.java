import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		while(t--!=0)
		{
			int n=src.nextInt();
			int m=src.nextInt();
			char g[][]=new char[n][m];
			boolean l[]=new boolean[n];
			boolean e[]=new boolean[n];
			//System.out.println(src.next());
			for(int i=0;i<n;i++)
			{
				g[i]=(src.next()).toCharArray();
				//System.out.println("A="+g[i][0]);
				for(int j=0;j<m;j++)
				{
					if(g[i][j]=='L')
					{
						l[i]=true;
					}
					else if(g[i][j]=='E')
						e[i]=true;
				}
			}
			boolean print=true;
			if(!l[n-1] && e[n-1])
			{
				print=false;
			}
			else
			impo:for(int i=0;i<n;i++)
				if(!l[i] && e[i])	//infected row
				{
					for(int j=0;j<m;j++)	//break should run this try inserting >1 E in a row
						if(g[i][j]=='E')	//column found
						{	
							boolean found=false;
							for(int k=i+1;k<n;k++)
							{
								if(g[k][j]=='L')
								{
									found=true;
									break;
								}
								if(!found)
								{
									print=false;
									break impo;
								}
							}							
						}			
				}
			if(print)	
				System.out.print("\nPossible");
			else
				System.out.print("\nImpossible");
		}
	}
}