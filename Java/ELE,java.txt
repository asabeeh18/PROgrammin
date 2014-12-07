import java.io.*;
class Ele
{
	publuc static int foo(int a[],int l,int r)
	{
		int min=a[l];
		for(int i=l+1;i<=r;i++)
			min=(min>a[i])?a[i]:min;
		return min;	
	}
	public static void main(String args[])
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.read());
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(bf.read());
		int q=Integer.parseInt(bf.read());
		while(q-->0)
		{
			int k=Integer.parseInt(bf.read());
			int count=0;
			//search k
			for(itn i=0;i<n;i++);
			{
				if(a[i]==k)
				{
					//left checker
					int l=i-1;
					while(a[l]>k)
						l--;
					//right check
					int r=i+1;
					while(a[r]>=k)	
						r++;
					//boundary cut check	
					for(int m=l;m<=i;m++)
					{
						for(int n=r;n>=i;n--)
						{
							if(foo(a,m,n)==k)
								count++;
							else break;
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}	