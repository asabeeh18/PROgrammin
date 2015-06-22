//subseq divisiblity
import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int test=src.nextInt();
		while(test--!=0)
		{
			int c=0,sum=0;
			int n=src.nextInt();
			if(n!=0)
				String s=src.next();
			for(int i=0;i<n;i++)
				if(s.charAt(i)=='1')
				{
					c++;
					for(int j=i+1;j<n;j++)
					{
						if(s.charAt(j)=='1')
							c++;
					}
				}	
			//sum=c*(c+1)/2;
			System.out.print(c);
		}
	}
}	
	