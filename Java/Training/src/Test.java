class Test
{
	public static long howMany(int sz,int[] strt,int[] end,int move)
	{
		
		long ways[][]=new long[sz][sz];
		long ways1[][]=new long[sz][sz];
		
		ways[strt[0]][strt[1]]=1;
		//ways1[strt[0]][strt[1]]=1;
		for(int a=-1;a<=1;a++)
		{
			int i=strt[0];
			int j=strt[1];
			for(int b=-1;b<=1;b++)
			{
				if(a==0 && b==0) continue;
				if(0<=i+a && i+a<sz && 0<=j+b && j+b<sz) ways1[i+a][j+b]++;
			}
		}
		for(int a=-2;a<=2;a++)
		{
			int i=strt[0];
			int j=strt[1];
			for(int b=-2;b<=2;b++)
			{
				if(a==b) continue;
				if(a==0 || b==0) continue;
				if(0<=i+a && i+a<sz && 0<=j+b && j+b<sz) ways1[i+a][j+b]++;
			}
		}
		
		long ref[][]=ways1;
		long cur[][]=ways1;
		for(int mv=1;mv<move;mv++) 
		{
			cur=new long[sz][sz];
			for(int i=0;i<sz;i++)
			{
				for(int j=0;j<sz;j++)
				{
					if((ref[i][j]<=0))
					continue;
					//if(i==strt[0] && j==strt[1]) continue;
					for(int a=-1;a<=1;a++)
					for(int b=-1;b<=1;b++)
					{
						if(a==0 && b==0) continue;
						if(0<=i+a && i+a<sz && 0<=j+b && j+b<sz) cur[i+a][j+b]++;
					}
					for(int a=-2;a<=2;a++)
					{
						for(int b=-2;b<=2;b++)
						{
							if(a==b) continue;
							if(a==0 || b==0) continue;
							if(0<=i+a && i+a<sz && 0<=j+b && j+b<sz) cur[i+a][j+b]++;
						}
					}
					//if(mv==0) break;
				}
				//if(mv==0) break;
			}
			//long t[]=cur;
			//cur=ref;
			for(int i=0;i<sz;i++) System.arraycopy(cur[i],0,ref[i],0,sz);
		}
		System.out.println(cur[end[0]][end[1]]);
		return cur[end[0]][end[1]];
	}
	
	public static void main(String as[]) throws Exception
	{
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int a[]={Integer.parseInt(r.readLine()),Integer.parseInt(r.readLine())};
		int b[]={Integer.parseInt(r.readLine()),Integer.parseInt(r.readLine())};
		howMany(Integer.parseInt(r.readLine()),a,b,Integer.parseInt(r.readLine()));
	}
}