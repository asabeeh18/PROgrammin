//Java
import java.util.*;
class Chef
{
    public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		while(t--!=0)
		{
			int n=src.nextInt();
			int m=src.nextInt();
			int b=0;
			int max=0;
			for(int i=0;i<n;i++)
			{
				int a=src.nextInt();
				if(max<a)
				{
					b=b+i*(a-max);
					max=a;
				}
				else
					b+=max-a;
				//System.out.println(max+" "+b);
			}
			if(b==m)
				System.out.println("Yes");
			else
				System.out.println("No");
			
		}
	}
}