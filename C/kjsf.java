import java.util.*;
class Main
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		while(t--!=0)
		{
			int n=src.nextInt();
			int m=src.nextInt();
			int a[][]=new int[m][2];
			for(int i=0;i<m;m++)
			{
				a[i][0]=src.nextInt();
				a[i][1]=src.nextInt();
			}
			for(int i=0;i<n;i++
				for(int j=0;j<n;j++)
				{
					if( (i+1,j+2), (i+1,j-2), (i-1,j+2), (i-1,j-2), (i+2,j+1), (i+2,j-1), (i-2,j+1), (i-2,j-1)