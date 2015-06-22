//1.Pascal Triangle
import java.util.*;
class Pascal
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter number of lines ");
		int n=src.nextInt();
		for(int i=0;i<=n;i++)
		{
			for(int j=1;j<=n-i-1;j++)
				System.out.print(" ");
			for(int j=0;j<=i;j++)
				System.out.print(fact(i)/(fact(i-j)*fact(j))+" ");
			System.out.println();	
		}
	}
	public static long fact(int k)
	{
		long f=1;
		for(int i=1;i<=k;i++) 
			f*=i;
		return f;	
	}	
}	