
#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>

void main()
{
 int gd,gm,sx,sy,i,j,v;
 int x[10],y[10],a[10],b[10];

 detectgraph(&gd,&gm);
 initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");

 printf("enter number of vertices\n");
 scanf("%d",&v);

 printf("enter d cordinates\n");

 for(i=0;i<v;i++)
 {
  printf("enter x and y cordinates\n");
  scanf("%d%d",&x[i],&y[i]);
 }

 printf("enter sx and sy\n");
 scanf("%d%d",&sx,&sy);

  for(i=0;i<v-1;i++)
 {
  line(x[i],y[i],x[i+1],y[i+1]);
  line(x[i]*sx,y[i]*sy,x[i+1]*sx,y[i+1]*sy);
 }
 line(x[0],y[0],x[v-1],y[v-1]);
 line(x[0]*sx,y[0]*sy,x[v-1]*sx,y[v-1]*sy);

 getch();
 closegraph();
}