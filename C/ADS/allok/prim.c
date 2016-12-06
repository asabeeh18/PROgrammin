/*
Ahmed Sabeeh
2016CS16
*/

/*
Prims Algorithm
*/
#include<stdio.h>
#define N 10
int MAX=99999;
void prim(int a[N][N],int n)
{
	int w[n+1],vis[n+1],ne=0,i,u,edge[n+1];
	for(i=0;i<=n;i++)
	{
		w[i]=MAX;
		vis[i]=0;
	}
	w[1]=0;
	//vis[1]=1;
	ne=1;
	while(ne<n)
	{
		//pick minimum unvisited vertex
		u=0;
		for(i=1;i<=n;i++)
		{
			if(w[u]>w[i] && vis[i]==0)
			{
				u=i;
			}
		}
		vis[u]=1;
		ne++;
		for(i=1;i<=n;i++)
		{
			//Adj and has lesser wt than previously recorded
			if(a[u][i]>0 && a[u][i]<w[i] && vis[i]==0)
			{
				w[i]=a[u][i];
				edge[i]=u;
			}
		}
	}
	for (i = 1;i<=n;i++)
      printf("%d - %d :%d\n",i,edge[i],w[i]);
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
    prim(a,n);
}


