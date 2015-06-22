

import java.util.*;
class e1
{
	public static void main(String args[])
	{	
		int array[]=new int[21];
		for(int i=0;i<array.length;i++)
		array[i]=i+30;
		int index, temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--)
		{
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]+"\t");
			if(i!=0 && i%5==0)
			System.out.println();
		}
	}
}