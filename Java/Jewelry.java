class Jewelry
{
	public long howMany(int[] values)
	{
		values=bubbleSort(values);
		for(int i=0;i<values.length;i++)
		{
			sumset(
		}
	}
	public static int[] bubbleSort(int[] height)
	{
		int temp;
		for(int i=0;i<height.length;i++)
		{
			for(int j=0;j<height.length-i-1;j++)
			{
				if(height[j]<height[j+1])
				{
					temp=height[j];
					height[j]=height[j+1];
					height[j+1]=temp;
				}
			}
		}
	}
	public static int sum(int[] x, int k)
	{
		int s=0,i;
		for(i=0;i<k;i++)
		s+=x[i];
		return s;
	}	
	public static boolean proper(int[] x, int[] v, int k, int i, int sumreq)
	{
		for(int j=0;j<=k-1;j++)
		if(x[j]==v[i])
		return false;
		if(sum(null, k-1)+v[i]>sumreq)
		return false;
		return true;
	}
	public static void sumset(int[] x, int[] v, int k, int sumreq)
	{
		int i,j,s;
		for(i=k;i<v.length;i++)
		{
			if(proper(x,v,k,i,sumreq))
			{
				x[k]=v[i];
				s=sum(x, k);
				if(s==sumreq)
				{
					return;
				}
				sumset(x,v,k+1,sumreq);
			}
		}
	}