//3.Standard Deviation
import java.util.*;
class Standard
{
	private int a[],n;
	public Standard(int n)
	{
		Scanner src=new Scanner(System.in);
		this.n=n;
		System.out.println("Enter the integers ");
		a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=src.nextInt();
	}		
	public double stdDev()
	{
		double s=0;
		for(int i=0;i<n;i++)
			s+=a[i];
		double m=s/n;
		s=0;
		for(int i=0;i<n;i++)
			s+=(a[i]-m)*(a[i]-m);
		double v=s/n;
		return Math.sqrt(v);	
	}
}
class Exp3
{	
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter number of integers ");
		int n=src.nextInt();
		Standard std=new Standard(n);
		System.out.print("Standard Deviation= "+std.stdDev());		
	}
}