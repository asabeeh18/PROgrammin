
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Kth
{
	public static void main(String ar[]) throws IOException
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		String[] s=r.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int q=Integer.parseInt(s[1]);
		int[] a=new int[n];
		int[] b=new int[n];
		int max=Integer.MIN_VALUE;
		s=r.readLine().split(" ");
		for(int i=0;i<n;i++)
		{
			a[i]=Integer.parseInt(s[i]);
		}
		
		System.arraycopy(a,0,b,0,n);
		java.util.Arrays.sort(b);
		int[][] list=new int[b[n-1]+1][n];
		int[] top=new int[b[n-1]+1];
		//Precomputation
                int old=-1;
		for(int i=0;i<n;i++)
		{
                    if(b[i]==old)
                        continue;
			int[] enter=list[b[i]];
                        
			for(int j=0;j<n;j++)
			{
				if(a[j]>=b[i])
					enter[top[b[i]]++]=a[j];
			}
                        old=b[i];
		}
		int x,y;
		while(q-->0)
		{
			s=r.readLine().split(" ");
			x=Integer.parseInt(s[0]);
			y=Integer.parseInt(s[1]);
                        if(top[x]==0)
                        {
                            while(top[x]==0)
                                x++;
                        }
			System.out.println(list[x][y-1]);
		}
	}
}