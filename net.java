import java.util.*;
class Solution
{
	static byte a[][];
	public static boolean friend(int n1,int n2)
	{
		if(a[n1][n2]==1)
			return true;
		else
		{
			for(int i=n1;i<a[0].length;i++)
				if(a[n1][i]==1 && n1!=i)
					return(friend(i,n2));
		}
		return false;
	}
	public static void main(String args[])
	{
		int i,j;
		Scanner src=new Scanner(System.in);
		int n=src.nextInt();
		src.nextLine();
		n++;
		a=new byte[n][n];
		while(true)
		{
		String s=src.nextLine();
		if(s.equals("-1"))
			return;
		else
		{
			int k=2;
			while(s.charAt(k)!=' ')
				k++;
			i=Integer.valueOf(s.substring(2,k));
			//System.out.println(i);
			k++;
			j=Integer.valueOf(s.substring(k,s.length()));
			//System.out.println(i);
				
			if(s.charAt(0)=='C')
			{
				a[i][j]=1;
				a[j][i]=1;
			}
			else if(s.charAt(0)=='Q')
			{
					if(friend(i,j))
						System.out.println("YES");
					else
						System.out.println("NO");
						
			}
		}
		}
	}
}