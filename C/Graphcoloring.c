#include<stdio.h>
int x[20],g[20][20],v;
int color(int k,int i)
{
    int j;
	for(j=1;j<=k-1;j++)
		if(g[k][j]!=0 && x[j]==1)
			return 0;
	return 1;
}	
void graphcolor(int k)
{
	int i,j;
	for(i=1;i<=v;i++)
	{
		if(color(k,i))
		{
			x[k]=i;
			if(k==v)
			{
				for(j=1;j<=v;j++)
					printf("%d ",x[k]);
                return;    
			}
			else
				graphcolor(k+1);
		}
	}	
}		
				
void main()
{
	int i,j;
	printf("VERTEX ");
	scanf("%d",&v);
	printf("MAtrix ");
	for(i=0;i<v;i++)
		for(j=0;j<v;j++)
			scanf("%d",&g[i][j]);
	graphcolor(0);
}