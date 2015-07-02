//http://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
class Test1
{
	static String baad[];
	public static long numWays(int width,int height,String[] bad)
	{
		/*String nums[];
		for(int i=0;i<bad.length;i++)
		{
			nums=bad[i].split(" ");
			baad[i]=nums[2]+" "+nums[3];
		}
		*/
		baad=bad;
		
		long ways[][]=new long[width+1][height+1];
		ways[0][0]=1;
		for(int i=0;i<=width;i++)
			for(int j=0;j<=height;j++)
			{
				if(i!=0 && !blocked(i,j,i-1,j))
					ways[i][j]+=ways[i-1][j];
				if(j!=0 && !blocked(i,j,i,j-1))
					ways[i][j]+=ways[i][j-1];
				System.out.println(ways[i][j]+": "+i+","+j);
			}
		return ways[width][height];
	}
	public static boolean blocked(int a,int b,int c,int d)
	{
		String s=a+" "+b+" "+c+" "+d;
		String s1=c+" "+d+" "+a+" "+b;
		for(int i=0;i<baad.length;i++)
			if(s.equals(baad[i]) || s1.equals(baad[i]))
				return true;
		return false;
	}
	public static void main(String as[]) throws Exception
	{
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String s[]={r.readLine(),r.readLine(),r.readLine()};
		System.out.println(numWays(Integer.parseInt(r.readLine()),Integer.parseInt(r.readLine()),s));
	}
}