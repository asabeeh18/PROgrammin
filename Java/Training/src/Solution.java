class Solution
{
	public static int max(int a,int b)
	{
		return (a>b)?a:b;
	}
	public static void main(String as[]) throws Exception
	{
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		int bud,party;
		String split[]=r.readLine().split(" ");
		bud=Integer.parseInt(split[0]);
		party=Integer.parseInt(split[1]);
		while(bud!=0 || party!=0)
		{
			int plan[][]=new int[party+1][bud+1];
			int fee[]=new int[party];
			int fun[]=new int[party];
			int fees=0;
			for(int i=0;i<party;i++)
			{
				split=r.readLine().split(" ");
				fee[i]=Integer.parseInt(split[0]);
				fun[i]=Integer.parseInt(split[1]);
			}
			for(int i=0;i<=party;i++)
			{
				for(int j=0;j<=bud;j++)
				{
					 if (i==0 || j==0)
						plan[i][j] = 0;
					else if(fee[i-1]<=j)
					{
						plan[i][j]=max(fun[i-1]+plan[i-1][j-fee[i-1]],plan[i-1][j]);
						//if(!(plan[i][j]==plan[i-1][j]))
							//fees+=fee[i]-fee[i-1];
						//else
							//fees-=fee[i]+fee[i-1];
					}
					else
						plan[i][j]=plan[i-1][j];
				}
			}
			int funy=plan[party][bud];
			int j=bud;
			while(plan[party][j]==funy)
			{
				j--;
			}
			System.out.println(plan[party][bud]+" :"+(j+1)); 
			r.readLine();
			split=r.readLine().split(" ");
			bud=Integer.parseInt(split[0]);
			party=Integer.parseInt(split[1]);
		
		}
	}
}