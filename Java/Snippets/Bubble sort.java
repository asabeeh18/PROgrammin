public static int[] bubbleSort(int[] height)	//Descending
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