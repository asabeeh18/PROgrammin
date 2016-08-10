import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
class Snake
{
	static int[][] grid;
	static int[][] box;
	static int exitMax[];
	//box array can be reduced to 3 1d arrays
	// doing with 1 1d array and 1 2d array ;
	static boolean[] entry,entryOld;
	public static void main(String ar[]) throws IOException
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		String s[]=r.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		grid=new int[n+1][m];	//fake last row is -infinite row
		box=new int[n][n];
		exitMax=new int[n];
		entry=new boolean[n];
		entryOld=new boolean[n];
		//init
		Arrays.fill(entry,true);
		// v seems a bit useless now 
		Arrays.fill(grid[n],Integer.MIN_VALUE);
		for(int i=0;i<n;i++)
		{
			s=r.readLine().split(" ");
			for(int j=0;j<m;j++)
			{
				grid[i][j]=Integer.parseInt(s[j]);
			}
		}
		
		//start
		for(int i=0;i<m;i++)
		{
			System.arraycopy(entry, 0, entryOld, 0, entry.length);
			for(int j=0;j<n;j++)
			{
				//entry point BLOCKED so copy points from last row and continue
				if(grid[j][i]==-1)
				{
					copyPrevPoints(j);
					entry[j]=false;
					continue;
				}
				// if can exit from prev col same row
				if(entryOld[j])
				for(int k=0;k<n;k++)
				{
					if(grid[k][i]==-1)
					{
						entry[k]=false;
						box[j][k]=0;
						continue;
					}
					//CORE LOGIC
					int jk=updown(i,j,k);
					if(j==0)
					box[j][k]=Math.max(0,jk);
					else
					box[j][k]=Math.max(box[j-1][k],jk);
				}
				//entry point BLOCKED "from last column" so copy points from last row and continue
				else
				{
					copyPrevPoints(j);   //DONOT put it with upper iF
				}
			}
			System.arraycopy(box[box.length-1], 0, exitMax, 0, box[0].length);
		}
		//find max exit val
		int max=-1;
		for(int i=0;i<box[0].length;i++)
		{
			if(box[n-1][i]>max && entry[i])
			max=box[n-1][i];
		}
		System.out.println(max);
	}
	
	//Go up AND down while adding points
	public static int updown(int i,int j,int k)
	{
		int up=0,down;
		//up actually goes down and down goes up ... ._."
		boolean exit1=true,exit2=true;
		if(i!=0)
		{
			up=exitMax[j];  //points from prev col
		}
		down=up;
		//entry or exit blocked
		if(grid[k][i]==-1 || grid[j][i]==-1)
		{
			if(grid[k][i]==-1)
			entry[k]=false;
			return 0;
		}
		//up
		for(int m=j;m!=k;m=(m+1)%grid.length)
		{
			if(grid[m][i]==-1)
			{
				up=Integer.MIN_VALUE;
				exit1=false;
				break;
			}
			if(grid[m][i]<0)
			{
				up=0;
				continue;
			}
			up+=grid[m][i];
		}
		up+=grid[k][i];
		//down actuall it goes up ..
		for(int m=j;m!=k;m=m-1==-1?grid.length-1:m-1)
		{
			if(grid[m][i]==-1)
			{
				down=Integer.MIN_VALUE;
				exit2=false;
				break;
			}
			if(grid[m][i]<0)
			{
				down=0;
				continue;
			}
			down+=grid[m][i];
		}
		down+=grid[k][i];
		
		
		//if u cant exit from UP or down a.k.a 'TRAPPED'
		if((!exit1 && !exit2))
		{
			entry[k]=false|entry[k];
			return 0;
		}
		entry[k]=true;
		return Math.max(0,Math.max(up,down));
	}
	public static void copyPrevPoints(int j)
	{   
		if(j!=0)
		System.arraycopy(box[j-1], 0, box[j], 0, exitMax.length);
		else
		System.arraycopy(exitMax, 0, box[j], 0, exitMax.length);
	}
}