#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>

void main()
{
 int gd,gm,tx,ty,i,v,j;
 int x[100],y[100],a[100],b[100];

 printf("enter d number of vertices\n");
 scanf("%d",&v);

 printf("emter d cordinates\n");
 for(i=0;i<v;i++)
 {
  printf("x and y cordinate\n");
  scanf("%d%d",&x[i],&y[i]);
 }

 printf("enter tx and ty\n");
 scanf("%d%d",&tx,&ty);

 for(j=0;j<v;j++)
 {
  a[j]=x[j]+tx;
  b[j]=y[j]+ty;
 }

 for(j=0;j<v-1;j++)
 {
  line(x[j],y[j],x[j+1],y[j+1]);
 }
 line(x[0],y[0],x[v-1],y[v-1]);

 for(i=0;i<v-1;i++)
 {
  line(a[i],b[i],a[i+1],b[i+i]);
 }
 line(a[0],b[0],a[v-1],b[v-1]);

 getch();
 closegraph();
}