import java.io.*;
class Stock
{
    
    static int n;
    public static void main(String ar[])throws IOException
    {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
                int avg,sum,sum1;
		while(t-->0)
		{
                        avg=0;
                        sum=0;
                        sum1=0;
			n=Integer.parseInt(br.readLine());	
			int[] a=new int[n];
                        int[] b=new int[n];
			String s[]=br.readLine().split(" ");
			for(int i=0;i<n;i++)
			{
				a[i]=Integer.parseInt(s[i]);
                                b[i]=a[i];
			}
                        
			//max routine
			for(int i=1;i<n-1;i++)
			{
				if(a[i-1]%2==0 && a[i+1]%2==0)
				{
					avg=(a[i-1]+a[i+1])/2;
					if((avg>a[i] && i<n/2) || (avg<a[i] && i<n/2))
					{
						a[i]=avg;
					}
				}
				
			}
                        sum=calcSum(a);
			//min
			for(int i=1;i<n-1;i++)
			{
				if(b[i-1]%2==0 && b[i+1]%2==0)
				{
					avg=(b[i-1]+b[i+1])/2;
					if(avg<b[i] && i<n/2)
					{
						b[i]=avg;
					}
                                        else if(avg>b[i] && i>=n/2)
                                        {
                                            b[i]=avg;
                                        }
				}
				
			}
                        sum1=calcSum(b);
			System.out.println(sum>sum1?sum:sum1);
		}
    }
    public static int calcSum(int a[])
    {
        int sum=0;
        for(int i=0;i<n/2;i++)
        {
            sum+=Math.abs(a[i]-a[n-i-1]);
        }
        return sum;
    }
}