import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int n=src.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
				a[i]=src.nextInt();
		for (int c = 0 ; c < ( n - 1 ); c++)
			for (int d = 0 ; d < n - c - 1; d++)
				if (a[d] > a[d+1])
				{
					int swap = a[d];
					a[d] = a[d+1];
					a[d+1] = swap;
				}
		int l=0,r=n-1,c=0;
		while(!(a[r]<=(2*a[l])))
		{
			if(2*(a[r]-a[r-1])>=(a[l+1]-a[l]))
				r--;
			else
				l++;
			c++;	
		}
		System.out.println(c);
	}
}	