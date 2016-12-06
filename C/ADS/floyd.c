/*
Ahmed Sabeeh
2016CS16
*/
/*
Write C program for Floyd-Warshall algorithm.
*/
#include<stdio.h>
void main()
{
	int a[512][512];
	int v,e,x,y,i,j,k,w;
	printf("Enter the number of vertices: ");
	scanf("%d",&v);
	printf("Enter the number of edges: ");
	scanf("%d",&e);
	printf("Enter the Edges in fromat vertex1 vertex2 weight: ");
	
	for(i=0;i<=v;i++)
		for(j=0;j<=v;j++)
			a[i][j]=99999;
	for(i=0;i<=v;i++)
		a[i][i]=0;
		
	for(i=0;i<e;i++)
	{
		scanf("%d %d %d",&x,&y,&w);
		a[x][y]=w;
		//a[y][x]=w;		
	}

	for(i=1;i<=v;i++)
	{
		for(j=1;j<=v;j++)
		{
			for(k=1;k<=v;k++)
			{
				if(a[j][k]>a[j][i]+a[i][k])
				{
					a[j][k]=a[j][i]+a[i][k];
				}
			}
		}
	}	
	printf("Minimum paths are:\n");
	
	printf("   ");
	for(i=1;i<=v;i++)
		printf("%2d ",i);
	printf("\n");
	for(i=1;i<=v;i++)
	{
		printf("%2d ",i);
		for(j=1;j<=v;j++)
		{
			printf("%2d ",a[i][j]);	
		}
		printf("\n");
	}
}
