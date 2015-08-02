//http://community.topcoder.com/stat?c=problem_statement&pm=1918&rd=5006
public class FlowerGarden
{
	public static int[] getOrdering(int[] height, int[] bloom, int[] wilt)
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
					
					temp=wilt[j];
					wilt[j]=wilt[j+1];
					wilt[j+1]=temp;
					
					temp=bloom[j];
					bloom[j]=bloom[j+1];
					bloom[j+1]=temp;
				}
			}
		}
		for(int i=0;i<height.length;i++)
		{
			for(int j=i+1;j<height.length;j++)
			{
                            if(i==j)
                                continue;
                            if(wilt[i]>=bloom[j] && bloom[i]<=wilt[j] && height[i]>height[j])
                            {
                                    height=rot(height,i,j);
                                    bloom=rot(bloom,i,j);
                                    wilt=rot(wilt,i,j);

                                    i=0;
                                    j=1;
                            }
			}
		}
		return height;
	}
	public static void main(String args[])
	{
		int[] a={1,2,3,4,5,6},b={1,3,1,3,1,3},c={2,4,2,4,2,4};
		System.out.println(getOrdering(a,b,c));
	}
        public static int[] rot(int a[],int i,int j)
	{
		int x=a[j];
		//int temp=a[i];
		for(int k=j;k>i;k--)
		{
			a[k]=a[k-1];
		}
		a[i]=x;
                return a;
	}
}