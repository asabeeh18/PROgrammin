import java.util.*;
class StdDev
{
	double dev(int a[])
	{
		int l=a.length;
		int s=0;double avg;
		for(int i=0;i<l;i++)
			s=s+a[i];	
		avg=(double)s/l;
		s=0;
		for(int i=0;i<l;i++)
		{
			s+=(a[i]-avg)*(a[i]-avg);
		}
		return Math.sqrt(s)/l;
	}
	void read(int a[])
	{
		Scanner src=new Scanner(System.in);
		for(int i=0;i<a.length;i++)
			a[i]=src.nextInt();
	}
}
class Expt
{
	public static void main(String args[])
	{
	
		System.out.println("ENter the number of elements");
		Scanner src=new Scanner(System.in);
		int l=src.nextInt();
		int a[]=new int[l];
		StdDev d=new StdDev();
		System.out.println("Enter the elements");
		d.read(a);
		double ans=d.dev(a);		 
		System.out.println("ANSWER "+ans);

	}
}