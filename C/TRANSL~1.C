#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>

void main()
{
	int gd,gm,v,i;
	float thetha,x[10],y[10],tx,ty;
	clrscr();
	printf("Enter the no. of vertices\n");
	scanf("%d",&v);
	printf("Enter the co ordinates");
	for(i=0;i<v;i++)
		scanf("%f %f",&x[i],&y[i]);
	printf("Enter the tx ty\n");
	scanf("%f %f",&tx,&ty);
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C://TURBOC3//BGI");
	for(i=0;i<v-1;i++)
	{
		line(x[i],y[i],x[i+1],y[i+1]);

	}
	line(x[0],y[0],x[v-1],y[v-1]);
	getch();
	for(i=0;i<v-1;i++)
			line(x[i]+tx,y[i]+ty,x[i+1]+tx,y[i+1]+ty);
	line(x[v-1]+tx,y[v-1]+ty,x[0]+tx,y[0]+ty);
	getch();
//	closegraph();
}