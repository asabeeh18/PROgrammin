//subseq divisiblity
import java.util.*;
class Solution
{
	static int x[],c;
	public static void back(int a[],int d,int k,int i)
	{
		x[i]=a[k];
		int j=x.length;
		int s=0;
		for(j=x.length-1;j>=0;j--)
			s+=x[x.length-j-1]*Math.pow(10,j);
		if(s%d!=0)
		{
			x[i]=0;
            if(k+1<a.length)
			back(a,d,k+1,i);
		}
		else
		{
			c++;
            if(k+1<a.length)
			back(a,d,k+1,i+1);
		}	
	}	
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int test=src.nextInt();
		while(test--!=0)
		{
			c=0;
			int n=src.nextInt();
			int a[]=new int[n];
			x=new int[n];
			int div=src.nextInt();
			for(int i=0;i<n;i++)
				a[i]=src.nextInt();
			back(a,div,0,0);
			System.out.println(c);
		}
	}
}	
	