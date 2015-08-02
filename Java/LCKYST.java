class Solution
{
	public static void main(String ar[]) throws Exception
	{
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int n=Integer.parseInt(r.readLine());
		String ss[]=r.readLine().split(" ");
		for(int i=0;i<n;i++)
		{
			Integer.parseInt(ss[i]);
			if(ss[i].charAt(ss[i].length()-1)=='5')
				System.out.println(Integer.parseInt(ss[i])*4);
			else
				System.out.println(Integer.parseInt(ss[i]));
		}
	}
}