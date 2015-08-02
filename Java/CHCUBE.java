//http://www.codechef.com/JULY15/problems/CHCUBE
/*
0(4/5)(2/3)
1(4/5)(2/3)
f(t/B)(r/l)
b(t/B)(r/l)
*/
class Solution
{
	public static void main(String ar[]) throws Exception
	{
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		String s;
		while(t-->0)
		{
			s=r.readLine();
			String ss[]=s.split(" ");
			if((ss[0].equals(ss[4]) || ss[0].equals(ss[5])) && (ss[0].equals(ss[2]) || ss[0].equals(ss[3])))
			{
				System.out.println("YES");
			}
			else if((ss[1].equals(ss[4]) || ss[1].equals(ss[5])) && (ss[1].equals(ss[2]) || ss[1].equals(ss[3])))
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
	}
}