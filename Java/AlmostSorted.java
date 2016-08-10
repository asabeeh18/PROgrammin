import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class AlmostSorted
{
	public static void main(String ar[]) throws IOException
	{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		while(t-->0)
		{
			int n=Integer.parseInt(r.readLine());
			int a[]=new int[n];
            String[] s=r.readLine().split(" ");
			for(int i=0;i<n;i++)
			{
				a[i]=Integer.parseInt(s[i]);
			}
			boolean flag=true;
			boolean blunder=false;
			for(int i=0;i<n-1;i++)
			{
				if(a[i+1]<a[i])
				{
					if(!flag)
					{
				
						blunder=true;
						break;
					}
					int k=a[i];
					a[i]=a[i+1];
					a[i+1]=k;
					flag=false;
				}
				else
				{
					flag=true;
				}
			}
			if(blunder)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}