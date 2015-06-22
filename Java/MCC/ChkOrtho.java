import java.util.*;

class ort
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the length of code");
		int n=src.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		
		System.out.println("Enter the elements 1");
		for(int i=0;i<n;i++)
		{
			a[i]=src.nextInt();
			if(a[i]==0)
				a[i]=-1;
		}	
		System.out.println("Enter the elements 2");
		for(int i=0;i<n;i++)
		{
			b[i]=src.nextInt();
			if(b[i]==0)
				b[i]=-1;
		}
		
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=a[i]*b[i];
			//sum=sum+c[i];
		}
		
		if(sum==0)
			System.out.println("codes are orthogonal to each other");
		else
			System.out.println("codes are NOT orthogonal to each other");
	}
}
