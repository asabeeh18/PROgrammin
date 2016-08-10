
class Grav
{
	public static int min(int a,int b)
	{
		return a<b?a:b;
	}
	public static void main(String ar[]) throws Exception
	{
		final int inf=Integer.MAX_VALUE;
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		//r.nextLine();
		char s[][]=new char[2][];
		
		
		while(t-->0)
		{
			
			s[0]=r.readLine().toCharArray();
			s[1]=r.readLine().toCharArray();
			int[] ad=new int[2],d=new int[2];	
			for(int i=0;i<s[0].length;i++)
			{
				ad[0]=s[0][i]=='#'?inf:min(d[0],d[1]+1);
				ad[1]=s[1][i]=='#'?inf:min(d[1],d[0]+1);
				d[0]=ad[0];
				d[1]=ad[1];
			}
			int miin=min(d[0],d[1]);
			if(miin>=inf)
				System.out.println("No");
			else
				System.out.println("Yes\n"+(miin));
		}
	}
}