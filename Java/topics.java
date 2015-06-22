//https://www.hackerrank.com/challenges/acm-icpc-team
import java.util.*;
class Solution
{
	static int hamming_distance(long x, long y)
	{
		int       dist;
		long  val;
	 
		dist = 0;
		val = x ^ y;    // XOR
	 
		// Count the number of bits set
		while (val != 0)
		{
			// A bit is set, so increment the count and clear the bit
			dist++;
			val &= val - 1;
		}
	 
		// Return the number of differing bits
		return dist;
	}
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int n=src.nextInt();
		int m=src.nextInt();
		long p[]=new long[n];
		for(int i=0;i<n;i++)
		{
			p[i]=Long.parseLong(src.next(),2);
		}
		int d[][]=new int[n][n];
		long max=0,count=0;
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(i!=j)
				{
					d[i][j]=d[j][i]=hamming_distance(p[i],p[j]);
					if(d[i][j]==max)
						count++;
					else if(d[i][j]>max)
					{
						max=d[i][j];
						count=1;
					}
				}
		System.out.println(max+"\n"+count);
	}
}
		