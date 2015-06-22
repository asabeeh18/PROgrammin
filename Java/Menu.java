import java.io.*;
class Main
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int j,day=1,dish=1,bud=1;
		while(day!=0 && dish!=0 && bud!=0)
		{
			day=Integer.parseInt(br.readLine());
			dish=Integer.parseInt(br.readLine());
			bud=Integer.parseInt(br.readLine());
			int cost[]=new int[dish];
			int ben[]=new int[dish];
			int maxben[]=new int[dish];
			//int mincost[]=new int[dish];
			maxben[0]=0;
			//mincost[0]=0;
			for(int i=0;i<dish;i++)
			{
				cost[i]=Integer.parseInt(br.readLine());
				ben[i]=Integer.parseInt(br.readLine());
				int	x=ben[i];
				for(j=i;j>0 && ben[j-1]>x;j--)
					maxben[j]=maxben[j-1];
				maxben[j]=i;
			}
			for(int i=0;i<dish;i++)
				System.out.println(maxben[i]);
			int i=0,k=0,s=0;
			int dishes[]=new int[day];
			double tben=0,tcost=0;
			while(i!=day)
			{
				if(s==1 && k==2)
					k-=2;
				tcost+=cost[maxben[dish-k]];
				if(tcost>bud)
				{
					tcost-=cost[maxben[dish-k]];
					i--;
					k++;
					s=0;
				}
				else
				{
					tben+=ben[maxben[dish-k]];
					dishes[i]=maxben[dish-k];
					s=1;
				}	
				i++;
				k++;
			}	
			for(i=0;i<dish;i++)
				System.out.println(dishes[i]);
			/*BEST CASE
			for(int i=dish;i<day;i--)
			{
				if(i!=dish && ben[maxben[i]]<ben[maxben[i+1]/2])
					i++;
				else if(i!=dish && ben[maxben[i]]==ben[maxben[i+1]/2])
					if(!(cost[maxben[i]]<cost[maxben[i+1]]))
						i++;	
				tcost+=cost[maxben[i]];
				tben+=ben[maxben[i]];	
			}
			System.out.println(tcost+" "+tben);
			/*
			int tbud=0;
			for(int i=dish;i<day;i--)
				tbud+=cost[mincost[i]];
			if(	
				
				
			/for(int i=0;i<dish;i++)
				System.out.println(mincost[i]+""+maxben[i]);*/
		
		}
	}	
}		