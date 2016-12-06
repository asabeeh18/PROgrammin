/*
Ahmed Sabeeh
2016CS16
*/
/*
Lab 10
Write program to implement BFS and DFS for a graph.
*/

#include<stdio.h>
#include<malloc.h>
int rear=-1,front=-1;
int *visited;

void dfs(int n,int g[n][n],int r)
{
	int i;
	for(i=0;i<n;i++)
	{
		if(g[r][i]==1 && visited[i]==0)
		{
			visited[i]=1;
			printf("%d ",i);
			dfs(n,g,i);
		}
	}
}
void main()
{
	int n,i,j,a,b,e;
	printf("Enter number of graph edges and vertices\n");
	scanf("%d %d",&e,&n);
	printf("Enter graph edge pairs, 0-indexed\n");
	int g[n][n];
	visited=(int*)malloc(sizeof(g[0]));
	for(i=0;i<n;i++)
	{
		visited[i]=0;
		for(j=0;j<n;j++)
			g[i][j]=0;
	}
	
	for(i=0;i<e;i++)
	{
		scanf("%d %d",&a,&b);
		g[a][b]=1;
		g[b][a]=1;
	}
	
	visited[0]=1;
	printf("%d ",0);	
	dfs(n,g,0);
	
}
