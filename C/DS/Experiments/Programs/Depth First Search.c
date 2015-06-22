#include<stdio.h>
#include<conio.h>
int visited[10];
int g[10][10];
int v,e;
void dfs(int i)
{
	int j;
	printf("%d\t",i);
	visited[i]=1;
	for(j=1;j<=v;j++)
	{
		if(g[i][j]!=0&&visited[j]!=1)
			dfs(j);
	}
}

void main()
{
	int a,b,i,j;
	printf("Enter the number of vertices \n");
	scanf("%d",&v);
	printf("Enter the number of edges \n");
	scanf("%d",&e);
	for(i=1;i<=v;i++)
		for(j=1;j<=v;j++)
			g[i][j]=0;
	for(i=1;i<=v;i++)
		visited[i]=0;
	printf("enter edges info....\n");
	for(i=1;i<=e;i++)
	{
		printf("Enter the vertices...\n");
		scanf("%d",&a);
		scanf("%d",&b);
		g[a][b]=g[b][a]=1;
	}
	dfs(1);
}

