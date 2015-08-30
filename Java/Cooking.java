//https://www.codechef.com/AUG15/problems/COOKMACH/
import java.util.*;
public class Cooking
{
	static int twos(int n)
	{
		int count = 0;
		while(n!=1)
		{
			count++;
			n >>= 1;
		}
		return count;
	}
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		int t=r.nextInt();
		int n,a,b,count,n1;
		while(t-->0)
		{
			a=r.nextInt();
			b=r.nextInt();
			count=0;
			n=twos(b);
			while((a & (a-1))!=0)
			{
				a/=2;
				count++;
			}
			n1=twos(a);
			
			count+=n-n1>0?n-n1:n1-n;
			System.out.println(""+count);
		}
	}
}