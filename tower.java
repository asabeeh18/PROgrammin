import java.util.*;
class Tower
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		for(int q=0;q<t;q++)
		{
			int x=src.nextInt();
			int y=src.nextInt();
			int r=src.nextInt();
			int bl=src.nextInt();
			int bx=new int[bl];
			int by=new int[bl];
			for(int i=0;i<bl;i++)
			{
				bx[i]=src.nextInt();
				by[i]=src.nextInt();
			}	
			long maxd=0,m1,m2;
			for(int i=0;i<bl;i++)
				for(int j=i+1;j<bl;j++)
				{
					dist=(bx[i]-bx[j])*(bx[i]-bx[j])+(by[i]-by[j])*(by[i]-by[j]);
					if(dist>maxd)
					{
						maxd=dist;
						m1=i;
						m2=j;
					}
				}
			Equation of a circle!!??	