//http://community.topcoder.com/stat?c=problem_statement&pm=1918&rd=5006
public class Test
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
			for(int j=0;j<height.length-i-1;j++)
			{
				if(wilt[j]>=bloom[j+1] && bloom[j]<=wilt[j+1] && height[j]>height[j+1])
				{
					System.out.println(i+" : "+j);
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
		return height;
	}
	public static void main(String arg[])
	{
		int[] a={5,4,3,2,1},b={1,5,10,15,20},c={5,10,14,20,25};
		System.out.println(getOrdering(a,b,c));
	}
}