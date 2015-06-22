import java.util.*;
public class Main
{
    public static long fact(int a)
	{	
		long f=1;
		if(a==0)
			return 1;
		for(int i=a;i>0;i--)
			f=f*i;
		return f;
	}
	public static long choose(int n,int i)	
	{
		return fact(n)/(fact(n-i)*fact(i));
	}	
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		while(t-->0)
		{
			long a[]=new long[300];
			int i=-1;
			int r=src.nextInt();
			int c=src.nextInt();
			long g=src.nextLong();
			for(int col=c;col>0 && g>0;col--)
			{
				long p=callme(2*col,col,g);
				if(p!=-1)
				{
				//	System.out.println("INE E  ");
					g-=p;
					a[++i]=p;
				}	
			}
			System.out.println(i+1);
			for(int j=0;j<=i;j++)
				System.out.print(a[j]+" ");
			System.out.println();	
		}
	}
	public static long callme(int a,int b,long g)
	{
		long k;
		//System.out.println(a+" "+b+" "+choose(a,b));
		if(a<b)
			return -1;	
		if((k=choose(a,b))>g)	
			return callme(a-1,b,g);
		else return k;
	}		
}	
