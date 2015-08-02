//http://www.codechef.com/submit/CHEFSTLT
class Solution
{
	public static void main(String ar[]) throws Exception
	{
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		char[] s,s1;
		while(t-->0)
		{
			s=r.readLine().toCharArray();
			s1=r.readLine().toCharArray();
			int diff=0,same=0;
			for(int i=0;i<s.length;i++)
			{
				if(s[i]!='?' && s1[i]!='?' && s[i]!=s1[i])
					diff++;
				else if(s[i]!='?' && s[i]==s1[i])
					same++;
			}
			System.out.println(diff+" "+(s.length-same));
		}
	}
}