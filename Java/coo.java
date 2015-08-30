//1 2 3 5 7 11
//http://www.codechef.com/problems/COINS/
class Solution
{
	public static void main(String args[]) throws Exception
	{
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		
		int n;
		String s;
		while((s=r.readLine())!=null)
		{
			n=Integer.parseInt(s);
			
			
			System.out.println(dividor(++n));
		}
	}
	static long dividor(int n)
	{
		
		if(n==1 || n==2 || n==3 || n==5 || n==7 || n==11)
		{
			System.out.println("coin["+n+"]="+n+";");
			return n;
		}
		
		int ans= (int)dividor(n/2)+(int)dividor(n/3)+(int)dividor(n/4);
		System.out.println("coin["+n+"]="+ans+";");
		return ans;
	}
}