#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>

void drawline(float x1,float y1, float x2, float y2)	
{	
	int i;
	float x,y,length,dx,dy;
	dx=abs(x2-x1);
	dy=abs(y2-y1);

	if(dx>=dy)
			length=dx;
	else	length=dy;

	dx=(x2-x1)/length;
	dy=(y2-y1)/length;

	x=x1 + 0.5;
	y=y1 + 0.5;

	putpixel(x,y,15);

	i=1;
	while(i<=length)
	{
		x=x + dx;
		y=y + dy;
		putpixel(x,y,15);
		i++;
	}
}

void main()
{
	float wx,wy,x1,x2,y1,y2,slope;
	int gd =DETECT,gm,i,thickness;
	clrscr();

	printf("Enter the two points\n");
	scanf("%f %f",&x1,&y1);
	scanf("%f %f",&x2,&y2);

	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C:\\TurboC3\\BGI");

	printf("Enter the reqd. thickness\n");
	scanf("%d",&thickness);
	cleardevice();
	slope=(float)(y2-y1)/(x2-x1);
	for(i=1;i<thickness;i++)
		drawline(x1+i*slope,y1-i*slope,x2+i*slope,y2-i*slope);

	getch();
	closegraph();
}