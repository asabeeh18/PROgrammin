import java.util.*;

class Hotel_Trip
{
	static int prev[] = {-1,-1,-1,-1,-1,-1,-1};
	public static void display(int w[],int x[],int k)
	{
		int i=0,j=0;
		for(i=0;i<w.length;i++)
			if(x[i]==1)
				if(w[i]!=prev[j++])
					break;
		if(i<w.length)
		{	
			System.out.print("[");
			for(i=0;i<k;i++)
				if(x[i]==1)
					System.out.print(w[i]+", ");
			System.out.println(w[i]+"]");
			
		}
		j=0;
		for(i=0;i<w.length;i++)
		{
			if(x[i]==1)
			{
				prev[j++]=w[i];
			}
		}
	}
	
	public static void sumOfSubsets(int w[],int x[],int sum,int rsum,int csum,int k,int n)
	{
		int i;
		x[k]=1;
		if(csum+w[k]==sum)
		{
			display(w,x,k);
		}	
		else
		{
			for(i=k+1;i<n;i++)
					if(csum+w[k]+w[i]<=sum)
						break;
			if(i<n)
				sumOfSubsets(w,x,sum,rsum-w[k],csum+w[k],i,n);
		}
		for(i=k+1;i<n;i++)
			if(csum+rsum-w[k]>=sum && csum+w[i]<=sum)
				break;		
		if(i<n)
		{
			x[k]=0;
			sumOfSubsets(w,x,sum,rsum-w[k],csum,i,n);
		}
	}

	public static void sort(int w[],int n)
	{
		int i,j,temp;
		for(i=0;i<n-1;i++)
			for(j=0;j<n-i-1;j++)
				if(w[j]<w[j+1])
				{
					temp=w[j];
					w[j]=w[j+1];
					w[j+1]=temp;
				}	
	}

	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		String s = src.nextLine();
		String words[]= s.split(" ");
		int w[]=new int[words.length];
		int x[]=new int[words.length];
		int rsum=0;
		for(int i=0;i<words.length;i++)
		{
			w[i]=Integer.parseInt(words[i]);
			x[i]=0;
			rsum+=w[i];
		}
		int sum = src.nextInt();
		sumOfSubsets(w,x,sum,rsum,0,0,w.length);
	}
}