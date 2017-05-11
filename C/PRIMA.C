#include<stdio.h>
#include<conio.h>
void prims(int g[][10],int v)
{
	int visited[30],d[30],p[30],i,j,c=1,current=0,min,minc;
	for(i=0;i<v;i++)
	{
		visited[i]=0;
		d[i]=9999;
		p[i]=0;
	}
	while(c!=v)
	{
		for(i=0;i<v;i++)
			if(g[current][i]!=0 && visited[i]!=1)
				if(g[current][i]<d[i])
				{
					d[i]=g[current][i];
					p[i]=current;
				}
		for(i=0;i<v;i++)
		{
			if(visited[i]==0 && g[current][i]<min)
			{
				min=g[current][i];
				minc=i;
			}
		}
		printf("%d ",current);  0. 
		visited[current]=1;
		current=minc;
		c++;
	}
	for(i=0;i<v;i++)
		printf("%d   ",d[i]);
	for(i=0;i<v;i++)
		printf("%d   ",p[i]);
}
void main()
{
	int n,j,cost[30][30],i;
printf("n Enter the no. of vertices:- ");
 scanf("%d", &n);

 printf ("n Enter the costs of edges in matrix form:- ");
 for(i=0;i< n;i++)
     for(j=0;j< n;j++)
	 {
	  scanf("%d",&cost[i][j]);
		  if(cost[i][j]==0)
			cost[i][j]=9999;
	}
 printf("n The matrix is:- ");
    for(i=0;i< n;i++)
    {
      for(j=0;j< n;j++)
	   printf("%d  ",cost[i][j]);
      printf("\n");
    }
    prims(cost,n);
}