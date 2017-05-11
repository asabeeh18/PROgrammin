//KRSUKALLS ASSWIPE!
#include<stdio.h>
#include<conio.h>
void main()
{
	int i,v,v1,v2,x,visited[10],sl[20][3],j,T[10][10],g[10][10],arr[30],e,cost,c;
	printf("Vertices:");
	scanf("%d",&v);
	printf("Edges:");
	scanf("%d",&e);
	for(i=0;i<e;i++)
	{
		scanf("%d %d %d",&v1,&v2,&cost);
		g[v1][v2]=g[v2][v1]=cost;
		sl[i][2]=g[v1][v2];
		sl[i][1]=v2;
		sl[i][0]=v1;
			for(j=i;j>0 && sl[j-1][2]>g[v1][v2];j--)
			{
				sl[j][2]=sl[j-1][2];
				sl[j][1]=sl[j-1][1];
				sl[j][0]=sl[j-1][0];
			}
		sl[j][2]=g[v1][v2];
		sl[j][1]=v2;
		sl[j][0]=v1;
	}
	for(i=0;i<e;i++)
		printf("%d %d %d\n",sl[i][0],sl[i][1],sl[i][2]);
	for(i=0;i<v;i++)
	{
		visited[i]=0;
		for(j=0;j<v;j++)
			T[i][j]=-1;
	}
	//haajime
	for(j=0,c=0;j<v;c++)
	{
		if(visited[sl[c][0]]!=1 || visited[sl[c][1]]!=1)
		{
			printf("%d--%d  ",sl[c][0],sl[c][1]);
			arr[sl[c][0]]=sl[c][1];
			T[sl[c][0]][sl[c][1]]=sl[c][2];
			visited[sl[c][0]]=visited[sl[c][1]]=1;
			j++;
		}
	}
	printf("\nTREE:\n");
	for(i=0;i<=v;i++)
		printf("%d--",arr[i]);
		/*
		for(j=0;j<v;j++)
			if(T[i][j]!=-1)
				printf("%d %d %d---",i,j,T[i][j]);*/
	getch();
}		