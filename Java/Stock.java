import java.io.*;
class Stock
{
    public static void main(String ar[]])
    {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n=Integer.parseInt(br.readLine());	
			int a[]=new int[n];
			String s[]=br.readLine().split(" ");
			for(int i=0;i<n;i++)
			{
				a[i]=Integer.parseInt(s[i]);
			}
			//max routine
			for(int i=1;i<n-1;i++)
			{
				if(a[i-1]%2==0 && a[i+1]%2==0)
				{
					avg=a[i-1]+a[i+1];
					if((avg>a[i] && i<n/2) || (avg<a[i] && i<n/2))
					{
						a[i]=avg;
					}
				}
				sum+=a[i];
			}
			//min
			for(int i=1;i<n-1;i++)
			{
				if(a[i-1]%2==0 && a[i+1]%2==0)
				{
					avg=a[i-1]+a[i+1];
					if((avg<a[i] && i<n/2) || (avg>a[i] && i<n/2))
					{
						a[i]=avg;
					}
				}
				sum1+=a[i];
			}
			System.out.println(sum>sum1?sum:sum1);
		}
    }
}