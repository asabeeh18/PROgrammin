#include<stdio.h>
#include<conio.h>
#include<graphics.h>

void main()
{
 int gd,gm,i,j,v,c;
 int x[10],y[10],a[10],b[10];

 detectgraph(&gd,&gm);
 initgraph(&gd,&gm,"C:\\tURBOC3\\BGI");

 printf("enter number of vertices\n");
 scanf("%d",&v);

 printf("enter d cordinates\n");
 for(i=0;i<v;i++)
 {
  printf("enter x and y cordinate\n");
  scanf("%d%d",&x[i],&y[i]);
 }

 printf("enter 1:reflection along x axis,2:reflection along y axis\n");
 scanf("%d",&c);

 switch(c)
 {
 case 1:for(i=0;i<v;i++)
	{
	 a[i]=x[i];
	 b[i]=-y[i];
	}
	break;
 case 2:for(i=0;i<v;i++)
	{
	 a[i]=-x[i];
	 b[i]=y[i];
	}
	break;
 }

 line(320,0,320,480);
 line(0,240,640,240);

 for(j=0;j<v-1;j++)
 {
  line(x[j]+320,y[j]+240,x[j+1]+320,y[j+1]+240);
  line(a[j]+320,b[j]+240,a[j+1]+320,b[j+1]+240);
 }
 line(x[0]+320,y[0]+240,x[v-1]+320,y[v-1]+240);
 line(a[0]+320,b[0]+240,a[v-1]+320,b[v-1]+240);

 getch();
 closegraph();
}


