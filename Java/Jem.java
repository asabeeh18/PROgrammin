class Jem
{
	public static void main(String ar[])
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		String[] s=r.nextLine().split(" ");
		int t=Integer.parseInt(s[0]);
		while(t-->0)
		{
			s=r.nextLine().split(" ");
			int n1=Integer.parseInt(s[0]);
			int n2=Integer.parseInt(s[1]);
			int m=Integer.parseInt(s[2]);
			while(true)
			{
				if(m<=n1 && m<=n2)
				{
					n1-=m;
					n2-=m;
					m--;
				}
				else
				{
					if(n1<n2)
					{
						n1=0;
						n2-=n1;
					}
					else
					{
						
					}
				}
			}	
		}
	}
}