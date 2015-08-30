//https://www.hackerrank.com/contests/codeagon/challenges/sherlock-and-subarray-queries
import java.util.Scanner;
class Sherl
{
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		int n=r.nextInt();
		int m=r.nextInt();
		int[] a=new int[n],max=new int[n];
		a[0]=r.nextInt();
		max[0]=a[0];
		for(int i=1;i<n;i++)
		{
			a[i]=r.nextInt();
			max[i]=(a[i]>max[i-1])?a[i]:max[i-1];
		}
		int l,rt,count;
		for(int i=0;i<m;i++)
		{
			count =0;
			l=r.nextInt()-1;
			rt=r.nextInt()-1;
			if(max[l-1]==max[rt])
			{
			//new max
				int ma=a[l];
				for(int j=l;j<rt;j++)
				{
					if(a[j]>ma)
					{
						ma=a[j];
						count=0;
					}
					else if(a[j]==ma)
					{
						count++;
					}
				}
				
			}
			else
			{
				for(int j=rt;j<=l;j++)
				{
					if(a[j]==max[rt])
						count++;
				}
			}
			System.out.println(count);
		}
	}
}