#include<stdio.h>
#include<string.h>

int g[20][20];
int v,e;
int d[20],p[20],vis[20];
void creategraph()
{
int a,b,w,i,j;

printf("enter no. of vertices");
scanf("%d",&v);
printf("enter no. of edges");
scanf("%d",&e);

for(i=1;i<=v;i++)
for(j=1;j<=v;j++)
g[i][j]=0;


for(i=1;i<=e;i++)
{
printf("edge info\n");
scanf("%d %d",&a,&b);
printf("enter weight\n");
scanf("%d",&w);
g[a][b]=g[b][a]=w;
}
}

void prim()
{
int c,current,mincost=0,min,i;
current=1;
vis[current]=1;
d[current]=0;
c=1;

while(c!=v)
{
for(i=1;i<=v;i++)
{
if(g[current][i]!=0 && vis[i]!=1)
{
if(g[current][i]<d[i])
{
d[i]=g[current][i];
p[i]=current;
}
}
}
min=1000;
for(i=1;i<=v;i++)
{
if(vis[i]!=1 && d[i]<min)
{
min=d[i];
current=i;
}
}
vis[current]=1;
c=c+1;
}
for(i=i;i<=v;i++)
mincost=mincost+d[i];
printf("mincost=%d\n",mincost);
}
void main()
{
int i;
clrscr();
creategraph();
for(i=1;i<=v;i++)
{
p[i]=0;
vis[i]=0;
d[i]=1000;
}
prim();
getch();
}