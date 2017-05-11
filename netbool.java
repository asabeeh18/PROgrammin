import java.util.*;
class Solution
{
	static boolean a[][];
	public static boolean friend(int n1,int n2)
	{
		boolean value=false;
		if(a[n1]!=null)
		if(a[n1].length>=n2)
			if(a[n1][n2])
				return true;
		else
		{
			int i=1;
			while(true)
			{
			if(a[i]==null)
			{
				i++;
				continue;
			}
			if(i>=a[i].length)
				break;
			if((a[n1][i] && n1!=i))
			{
					System.out.println(i+" "+n1);
					value=(friend(i,n2));
			}
			i++;
			}
		}
		return value;
	}
	public static void inc(int i,int l)
	{
		boolean b[]=new boolean[a[i].length];
		for(int j=0;j<a[i].length;j++)
			b[j]=a[i][j];
		a[i]=new boolean[l];
		for(int j=0;j<b.length;j++)
			a[i][j]=b[j];
		
	}
	public static void main(String args[])
	{
		int i,j;
		Scanner src=new Scanner(System.in);
		int n=src.nextInt();
		src.nextLine();
		n++;
		a=new boolean[n][];
		//for(i=0;i<n;i++)
			
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
				if(a[i]==null)
					a[i]=new boolean[j+1];
				else
				{
					if(a[i].length<j)
						inc(i,j+1);
				}
				if(a[j]==null)
					a[j]=new boolean[i+1];
				else
				{
					if(a[j].length<i)
						inc(j,i+1);
				}	
				a[i][j]=true;
				a[j][i]=true;
			}
			else if(s.charAt(0)=='Q')
			{
					if( a[i]!=null  && a[j]!=null && friend(i,j))
						System.out.println("YES");
					else
						System.out.println("NO");
						
			}
		}
		}
	}
}