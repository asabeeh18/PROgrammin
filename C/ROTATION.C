#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>

void main()
{
	int gd,gm,v,i;
	float thetha,x[10],y[10];
	int x1[30];
	clrscr();
	printf("Enter the no. of vertices\n");
	scanf("%d",&v);
	printf("Enter the co ordinates");
	for(i=0;i<v;i++)
		scanf("%f %f",&x[i],&y[i]);
	printf("Enter the angle of rotation\n");
	scanf("%f",&thetha);
	thetha=(thetha*3.142/180);
	for(i=0;i<2*v;i=i+2)
	{
		x1[i]=x[i]*cos(thetha)-y[i]*sin(thetha);
		x1[i+1]=x[i]*sin(thetha)+y[i]*cos(thetha);
		printf("%d %d ",x[i],x[i+1]);
		//x[i+1]*cos(thetha)-y[i+1]*sin(thetha);
		//x[i+1]*sin(thetha)+y[i+1]*cos(thetha);
	}
	x1[2*v]=x1[0];
	x1[2*v+1]=x1[1];
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C://TURBOC3//BGI");
	for(i=0;i<v-1;i++)
	{
		line(x[i],y[i],x[i+1],y[i+1]);
	}
	line(x[0],y[0],x[v-1],y[v-1]);
	getch();
	drawpoly(v,x1);
	//line();
	getch();
       //	closegraph();
}