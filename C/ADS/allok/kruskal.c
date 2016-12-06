/*
Ahmed Sabeeh
2016CS16
*/

/*
Kruskals Algorithm
*/
#include<stdio.h>
#define N 10
int MAX=99999;
int p[N];
void kruskal(int g[N][N],int n)
{
    int min,sum=0,ne=0,i,j,u,v,a,b;
    for(i=1;i<=n;i++)
    p[i]=0;
    while(ne<n-1)
    {
        min=999;
        for(i=1;i<=n;i++)
		{
		    for(j=1;j<=n;j++)
		    {
		        if(g[i][j]<min)
		        {
		            min=g[i][j];
		            u=a=i;
		            v=b=j;
		        }
		    }
		}
        while(p[u])
            u=p[u];
        while(p[v])
            v=p[v];
        if(u!=v)
        {
            ne++;
            sum+=min;
            printf("\nedge %d -->%d is %d ",a,b,min);
            p[v]=u;
        }
        g[a][b]=g[b][a]=999;
    }
    printf("Minimum cost spanning tree=%d",sum);
}

void main()
{
    int a[N][N],n,i,j;
    printf("No.of vertices: ");
    scanf("%d",&n);
	printf("Enter weight matrix\n");
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=n;j++)
        {
        	scanf("%d",&a[i][j]);
        }
    }
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=n;j++)
        {
            if(a[i][j]==0)
                a[i][j]=MAX;
        }
    }
    kruskal(a,n);
}
