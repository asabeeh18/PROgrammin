import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int n=src.nextInt();
		int k=src.nextInt();
		String s=src.next();
		char a[];
		a=s.toCharArray();
		int max=0,cmax,pmax=0;
		for(int i=0;i<n;i++)
		{
			cmax=0;
			for(int j=i+1;j<n;j++)
				if(a[i]==a[j])
					cmax++;
			if(cmax>max || (cmax==max && a[pmax]>a[i]))
			{
				max=cmax;
				pmax=i;
			}	
		}
		max++;
		int inc=0,cost=0;
		for(int i=max;i<k;inc++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[j]-inc-1==a[pmax] && i<k)
				{
					cost+=a[j]-a[pmax];
					a[j]=a[pmax];
					i++;
				}	
			}	
			for(int j=0;j<n;j++)
			{
				if(a[j]+inc+1==a[pmax] && i<k)
				{
					cost+=a[pmax]-a[j];
					a[j]=a[pmax];
					i++;
				}	
			}	
		}
		
		System.out.println(inc+"\n"+new String(a));
	}
}	