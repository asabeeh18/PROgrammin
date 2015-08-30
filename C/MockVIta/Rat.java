import java.util.Scanner;
public class Rat
{
	static boolean[][] a,visited;
	static boolean[] rat;
	static int[][] ratLoc;
	static int n;
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		n=r.nextInt();
		r.nextLine();
		a=new boolean[n+1][n+1];
		visited=new boolean[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			String row=r.nextLine();
			int col=0;
			for(int j=1;j<=n;j++)
			{
				if(row.charAt(col)=='O')
				{
					a[i][j]=true;
				}
				else a[i][j]=false;
				col+=2;
			}
		}
		int rats=r.nextInt();
		//r.nextLine();
		rat=new boolean[rats+1];
		ratLoc=new int[rats+1][2];
		for(int i=1;i<=rats;i++)
		{
			ratLoc[i][0]=r.nextInt();
			ratLoc[i][1]=r.nextInt();
		}
		
		//Process
		pests(ratLoc[1][0],ratLoc[1][1]);
		
		//OP
		boolean flag=false;
		for(int i=1;i<=rats;i++)
		{
			if(!rat[i])
			{
				flag=true;
				System.out.println("No");
				break;
			}
		}
		if(!flag)
		{
			System.out.println("Yes");
		}
	}
	static void pests(int i,int j)
	{
                if(i==2 && j==3)
                    System.out.print(j);
		visited[i][j]=true;
		int poz=ratIn(i,j);
		if(poz>0)
		{
			rat[poz]=true;
		}
		if(i+1<=n)
			if(a[i+1][j] && !visited[i+1][j])
				pests(i+1,j);
		if(j+1<=n)
			if(a[i][j+1] && !visited[i][j+1])
				pests(i,j+1);
		if(i-1>0)
			if(a[i-1][j] && !visited[i-1][j])
				pests(i-1,j);
		if(j-1>0)
			if(a[i][j-1] && !visited[i][j-1])
				pests(i,j-1);	
	}
	static int ratIn(int a,int b)
	{
		for(int i=1;i<ratLoc.length;i++)
		{
			if(ratLoc[i][0]==a && ratLoc[i][1]==b)
				return i;
		}
		return -1;
	}
}