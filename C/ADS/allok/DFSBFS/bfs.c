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
int isEmpty()
{
	if(rear==-1)
		return 1;
	return 0;
}
int insert(int *a,int n)
{
    /*
    if(rear>=N-1)
        return 0;
    */
    if(front==-1)
        front++;
    rear++;
    a[rear]=n;
    return 1;
}

int delete(int *a)
{
    int n,i;
    n=a[front];
    for(i=0;i<rear;i++)
        a[i]=a[i+1];
    rear--;
    if(rear==-1)
    	front=-1;
    return n;
}

void bfs(int n,int g[n][n],int r)
{
	int q[n],top=-1,i;
	for(i=0;i<n;i++)
	{
		if(g[r][i]==1)
		{
			insert(q,i);
		}
	}

	visited[r]=1;
	printf("%d ",r);
	while(!isEmpty())
	{
		r=q[0];
		delete(q);
		visited[r]=1;
		printf("%d ",r);
		for(i=0;i<n;i++)
		{
			if(r<n && g[r][i]==1)
			{
				if(visited[i]!=1)
					insert(q,i);
			}
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
	bfs(n,g,0);
	
}
