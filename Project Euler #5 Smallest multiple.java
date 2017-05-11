import java.util.*;
class HCF_LCM
{
		public static int lcm(int a,int b)
		{
			int max=a>b?a:b;
			int hcf=1;
			for(int i=1;i<=max;i++)
			{
				if(a%i==0 && b%i==0)
					hcf=i;
			}
			return (a*b/hcf);
		}
 public static void main(String args[])
 {
	Scanner src=new Scanner(System.in);
	int t=src.nextInt();
	while(t--!=0)
	{
		int hcf=1;
		int n=src.nextInt();
		int a[]=new int[n];
		for(int i=1;i<=n;i++)
			a[i-1]=i;
		int newlcm=a[0];
		for(int i=1;i<a.length;i++)
		{
			newlcm=lcm(newlcm,a[i]);
		}	
		System.out.println(newlcm);	
		}
	}
}
