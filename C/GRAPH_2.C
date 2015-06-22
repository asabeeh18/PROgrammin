//Graph
#include<conio.h>
#include<stdio.h>
#define M 20
int g[M][M],vis[M],v,e;
struct Q
{
	int a[M],front,rear;
};
struct Q q;
void enQ(int i)
{
	if(q.rear==-1)
		q.front++;
	q.rear++;
       q.a[q.rear]=i;
}
int deQ()
{
	int x=q.a[q.rear];
	q.rear--;
	if(q.rear==-1)
		q.front=-1;
	return x;
}
int isempty()
{
	if(q.rear==-1)
		return 1;
	return 0;
}
/*
void bfs(int i)
{
	int x,j;
	enQ(i);
	while(isempty()==0)
	{
		x=deQ();
		printf("%d ",x);
		vis[x]=1;
		for(j=1;j<=v;j++)
			if(g[x][j]==1 && vis[j]==0)
				enQ(j);
	}
}*/
void dfs(int i)
{
	int j;
	vis[i]=1;
	printf("%d ",i);
	for(j=1;j<=v;j++)
		if(g[i][j]==1 && vis[j]==0)
			dfs(j);
}
void main()
{
	int i,n,j,a,b;
	printf("Enter the number of Verices: ");
	scanf("%d",&v);
	printf("Enter the number of edges: ");
	scanf("%d",&e);
	//INIT
	q.front=-1;
	q.rear=-1;
	for(i=0;i<v;i++)
	{
		vis[i]=0;
		for(j=0;j<v;j++)
			g[i][j]=0;
	}
	printf("Enter the edges\n");
	for(i=0;i<e;i++)
	{
		scanf("%d %d",&a,&b);
		g[a][b]=g[b][a]=1;
	}
	dfs(1);
}