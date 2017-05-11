#include<stdio.h>
#include<conio.h>
#include<string.h>
#define SIZE 5
int g[SIZE][SIZE],x[SIZE],n,v,e;
int color(int k,int i)
{
 int j;
 for(j=1;j<=k-1;j++)
 {
 if(g[j][k]!=0&&x[j]==i)
 return 0;
 }
 return 1;
}

void graphcolor(int k)
{
 int i,j;
 for(i=1;i<=n;i++)
 {
  if(color(k,i))
  {
  x[k]=i;
  if(k==v)
  {
  for(j=1;j<=v;j++)
  printf("%d ",x[j]);
  if(j==v+1)
  {
  printf("\n");
  }
  }
  else
  graphcolor(k+1);
  }
 }
}
void main()
{
 int e1,e2,i;
 clrscr();
 printf("Enter no of Vertices\n");
 scanf("%d",&v);
 printf("Enter no of Edges\n");
 scanf("%d",&e);
 printf("Enter Connected Vertices\n");
 for(i=1;i<=e;i++)
 {
 scanf("%d%d",&e1,&e2);
 g[e1][e2]=g[e2][e1]=1;
 }
 printf("Enter no of Colors\n");
 scanf("%d",&n);
 printf("Possible Answers are:\n");
 graphcolor(1);
 getch();
}