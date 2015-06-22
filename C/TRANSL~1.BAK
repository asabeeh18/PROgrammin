#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>

void main()
{
	int gd,gm,v,i;
	float thetha,x[10],y[10],sx,sy;
	clrscr();
	printf("Enter the no. of vertices\n");
	scanf("%d",&v);
	printf("Enter the co ordinates");
	for(i=0;i<v;i++)
		scanf("%f %f",&x[i],&y[i]);
	printf("Enter the sx sy\n");
	scanf("%f %f",&sx,&sy);
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C://TURBOC3//BGI");
	for(i=0;i<v-1;i++)
	{
		line(x[i],y[i],x[i+1],y[i+1]);

	}
	line(x[0],y[0],x[v-1],y[v-1]);
	getch();
	for(i=0;i<v-1;i++)
			line(x[i]*sx,y[i]*sy,x[i+1]*sx,y[i+1]*sy);
	line(x[v-1]*sx,y[v-1]*sy,x[0]*sx,y[0]*sy);
	getch();
//	closegraph();
}