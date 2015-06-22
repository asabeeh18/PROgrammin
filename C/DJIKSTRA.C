#include<stdio.h>
#include<conio.h>
void djikstra(int a[][10],int v)
{

	int visited[10],d[10],p[10],current=0,i,j,dc=0,mini=0,minj=0,dest;
	printf("\nDESTINATION\n");
	scanf("%d",&dest);
	for(i=0;i<v;i++)
	{
		d[i]=65000;
		visited[i]=0;
	}
	visited[current]=1;
	d[current]=0;
	dc=0;
	while(current!=dest)
	{
		for(i=0;i<v;i++)
			if(a[current][i]!=0 && visited[i]!=1)
				if(a[current][i]+dc<d[i] && a[current][i]!=0)
				{
					d[i]=a[current][i]+dc;
					p[i]=current;
				}
		for(i=0;i<v;i++)
			for(j=0;j<v;j++)
				if(a[i][j]<a[mini][minj] && visited[i]==0 || visited[j]==0)
				{
					mini=i;
					minj=j;
				}
		visited[current]=1;
		dc=d[current];

	}
	for(i=0;i<v;i++)
		printf("%d  %d",p[i],d[i]);
}
void main()
{
	int a[10][10],j,i,v;
	printf("Enter vertices");
	scanf("%d %d",&v);
	printf("Enter the adjacency Matrix");
	for(i=0;i<v;i++)
		for(j=0;j<v;j++)
			scanf("%d",&a[i][j]);
	djikstra(a,v);
}