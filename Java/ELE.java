import java.util.*;
class Ele
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in)
		try{
		int n=src.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=src.nextInt();
		int q=src.nextInt();
		
		while(q-->0)
		{
			int k=src.nextInt();
			int count=0;
			//search k
			for(int i=0;i<n;i++)
			{
				if(a[i]==k)
				{
					//left checker
					int l=i-1;
					while(l>-1 && a[l]>k)
						l--;
					l++;
					
					//right check
					int r=i+1;
					while(r<n && a[r]>=k)	
						r++;
					r--;
					//boundary cut check	
					for(int m=l;m<=i;m++)
					{
						for(int p=r;p>=i;p--)
						{
							//if(foo(a,m,p)==k)
								count++;
							//else break;
							
						}
					}
				}
			}
			System.out.println(count);
		}
		}
		catch(Exception e)
		{}
	}
}