//Project Euler #6: Sum square difference
import java.util.*;
class SumSquare
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		while(t--!=0)
		{
			int n=src.nextInt();
			long int sum=0,sumsq=0;;
			int a[]=new int[n];
			for(int i=1;i<=n;i++)
				a[i-1]=i;
			
			for(int i=0;i<a.length;i++)
			{
				sum+=a[i];
				sumsq+=a[i]*a[i];
			}	
			sum*=sum;
			System.out.println(sum-sumsq);	
		}
	}
}
