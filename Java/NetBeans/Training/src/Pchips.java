
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.codechef.com/IPC15P1A/problems/PCHIPS
class Pchips
{
	public static void main(String ar[]) throws IOException 
	{
        
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		while(t-->0)
		{
			int n=Integer.parseInt(r.readLine());
			int sum=0;
			int[] a=new int[n];
			String s[]=r.readLine().split(" ");
			for(int i=0;i<n;i++)
			{
				a[i]=Integer.parseInt(s[i]);
				sum+=a[i];
			}
			int low=(2*sum-n*n-n)/(2*n)+1;
			int leftover=0;
			int moved=0;
			for(int i=0;i<n;i++)
			{
				int c=a[i]-low;
				if(c<0)
					leftover+=c;
				else
				{
					moved+=c;
					leftover+=c;
				}
                low++;
			}
            if(leftover==0)
                System.out.println(moved);
            else
                System.out.println("-1");
		}
	}
}