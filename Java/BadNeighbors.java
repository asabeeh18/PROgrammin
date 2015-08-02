//f(x)=f(x-2)+v[x],f(x-3)+v[x-1]
//http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
public class BadNeighbors
{
	int[] don;
	public int maxDonations(int[] don)
	{
		this.don=don;
		int a=claci(don.length-2);
		int b=calci(don.length-1);
		
		return max(a,b);
	}
	public int calci(int x)
	{
		if(x==2)
			return don[2];
		if(x==1)
			return don[1];
		if(x==0)
			return 0;
		int a= max(calci(x-2)+don[x],calci(x-3)+don[x-1]);
		if(x==0)
			System.out.println(x);
		return a;
	}
	public int claci(int x)
	{
		if(x==2)
			return max(claci(x-2)+don[x],don[2]);
		if(x==1 || x==0)
			return don[x];
		return max(claci(x-2)+don[x],claci(x-3)+don[x-1]);
	}
	public static int max(int a,int b)
	{
		return a>b?a:b;
	}
}