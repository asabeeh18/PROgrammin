#include<stdio.h>
#include<string.h>

int g[10][10];
int v,e;

void creategraph()
{
int a,b,w,i,j;

printf("enter no. of vertices");
scanf("%d",&v);
printf("enter no. of edges");
scanf("%d",&e);

for(i=1;i<=v;i++)
for(j=1;j<=v;j++)
    if(i==j)
        g[i][j]=0;
    else
        g[i][j]=32767;

for(i=1;i<=v;i++)
g[i][i]=0;
for(i=1;i<=e;i++)
{
printf("edge info\n");
scanf("%d %d",&a,&b);
printf("enter weight\n");
scanf("%d",&w);
g[a][b]=w;
}
}

void allpair()
{


int k,i,j;
for(k=1;k<=v;k++)
for(i=1;i<=v;i++)
for(j=1;j<=v;j++)
if(g[i][j]>g[i][k]+g[k][j])
  g[i][j]=g[i][k]+g[k][j];

printf("shortest distance:");
printf("from\t\tto\n");
for(i=1;i<=v;i++)
for(j=1;j<=v;j++)
printf("%d\t\t%d=%d\n",i,j,g[i][j]);
}

void main()
{
creategraph();
allpair();
}