//http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
class ZigZag
{
	int longestZigZag(int[] zig)
	{
		int minus=1,plus=1,c=1,last_minus=zig[0],last_plus=zig[0];
		for(int i=1;i<zig.length;i++)
		{
			if((last_plus-zig[i]>0 && c>0 )|| (last_plus-zig[i]<0 && c<0 )
			{
				plus++;
				last_plus=zig[i];
			}
			else
			{
				minus++;
				last_minus=zig[i]
			}
			c=-c;
		}
	}
	public static void main(String a[])
	{
		java.io.BufferedReader r=new BufferedReader(new java.io.InputStreamReader(System.in));
		
	}