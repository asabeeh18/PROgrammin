//1 2 3 5 7 11
//http://www.codechef.com/problems/COINS/
class Solution
{
	static long storage[];
	static int max;
	public static void main(String args[]) throws Exception
	{
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		//int t=Integer.parseInt(r.readLine());
		int n[]=new int[10];
		String s;
		int i=0;
		while((s=r.readLine())!=null)
		{
			n[i]=Integer.parseInt(s);
			i++;
			System.out.println(dividor(++n[i-1]));
		}
		max=n[0];
		for(int j=1;j<i;j++)
		{
			if(n[j]>max)
				max=n[j];
		}
		boolean mem=false;
		while(!mem)
		{
			try{
				storage=new long[1001];
			//	System.out.println(max);	
				mem=true;
			}
			catch(java.lang.OutOfMemoryError e)
			{
				max/=2;
				continue;
			}
		}
		for(int j=0;j<i;j++)
			System.out.println(dividor(n[j]));
	}
	static long dividor(int n)
	{
		try{
		if(1000>=n && storage[n]!=0)
			return storage[n];
		if(n==1 || n==2 || n==3 || n==5 || n==7 || n==11)
			return n;
		long x= dividor(n/2)+dividor(n/3)+dividor(n/4);
		//System.out.println(n+": "+x);
		if(1000>=n)
			storage[n]=x;
		return x;
		}
		catch(Exception e)
		{
			while(true);
		}
	}
}