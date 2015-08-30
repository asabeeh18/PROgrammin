class Coin
{
	public static void main(String ar[])
	{
		java.util.Scanner r=new java.util.Scanner(System.in);
		//boolean[] visited =new boolean[1000000000];
		/*
			int[] coin=new int[500000000];
			coin[0]=0;
			coin[1]=1;
			coin[2]=2;
			coin[3]=3;
			coin[4]=4;
			coin[5]=5;
			coin[6]=6;
			coin[7]=7;
			int maxyet=7;
			while(r.hasNextInt())
			{
			int n=r.nextInt();
			if(n==0)
			System.out.println("0");
			else
			{
			if(coin[n]==0)
			{
			for(int i=maxyet+1;i<=n;i++)
			{
			coin[i]=max(i,coin[i/2]+coin[i/3]+coin[i/4]);
			}
			maxyet=n;
			}
			System.out.println(coin[n]);
			}
			}
		*/
		while(r.hasNextInt())
		{
			int[] coin=new int[1000000000];
			coin[0]=0;
			coin[1]=1;
			coin[2]=2;
			coin[3]=3;
			coin[4]=4;
			coin[5]=5;
			coin[6]=6;
			coin[7]=7;
			
			int n=r.nextInt();
			if(n==0)
			System.out.println("0");
			else
			{
				for(int i=maxyet+1;i<=n;i++)
				{
					coin[i]=max(i,coin[i/2]+coin[i/3]+coin[i/4]);
				}
				maxyet=n;
			}
			System.out.println(coin[n]);
		}
	}
	
	public static int max(int a,int b)
	{
		return a>b?a:b;
	}
}