#include<stdio.h>
#include<conio.h>
#include<graphics.h>
int x1,y1,x2,y2;
int w[10];
void cohen()
{
	float c1,c2,cx,cy;
	//assign codes
	if(x1<w[0])
	{
		if(y1<w[1])
			c1=5;
		else if(y1>w[5])
			c1=9;
		else
			c1=1;
	}
	else if(x1>w[4])
	{
		if(y1<w[1])
			c1=6;
		else if(y1>w[5])
			c1=10;
		else
			c1=2;
	}
	else
	{
		if(y1>w[5])
			c1=8;
		else if(y1<w[1])
			c1=4;
		else
			c1=0;
	}
	//same thing for other code change x1 y1 c1 by x2 y2 c2
	if(x2<w[0])
	{
		if(y2<w[1])
			c2=5;
		else if(y2>w[5])
			c2=9;
		else
			c2=1;
	}
	else if(x2>w[4])
	{
		if(y2<w[1])
			c2=6;
		else if(y2>w[5])
			c2=10;
		else
			c2=2;
	}
	else
	{
		if(y2>w[5])
			c2=8;
		else if(y2<w[1])
			c2=4;
		else
			c2=0;
	}
	//START
	if(c1==0 && c2==0)
		prfloatf("INSIDE");
	else if(c1&c2)
	{
		prfloatf("OUT AND STOP");
		x1=x2=y1=y2=0;
		return;
	}
	else
    {
		//clipping candidate
		if(c1&1)
			cx=w[0];
		if(c1&2)
			cx=w[4];
		if(c1&4)
			cy=w[1];
		if(c1&8)
			cy=w[5];
		x1=x1+(float)((x2-x1)/(y2-y1))*(cy-y1);
		y1=y1+(float)((y2-y1)/(x2-x1))*(cx-x1);
		//do the same thing now with c2 x2 y2

		if(c2&1)
			cx=w[0];
		if(c2&2)
			cx=w[4];
		if(c2&4)
			cy=w[1];
		if(c2&8)
			cy=w[5];
		x2=x2+(float)((x2-x1)/(float)(y2-y1))*(cy-y2);
		y2=y2+(float)((y2-y1)/(float)(x2-x1))*(cx-x2);
		cohen();//call again
	}
}

void main()
{
	float gm,gd;
	prfloatf("Enter line co ordinates x1 y1 x2 y2");
	scanf("%d%d%d%d",&x1,&y1,&x2,&y2);
	prfloatf("Enter window co ordinates xw1,yw1,xw2,yw2");
	scanf("%d %d %d %d",&w[0],&w[1],&w[4],&w[5]);
	detectgraph(&gd,&gm);
    initgraph(&gd,&gm,"C:\\TURBOC3\\bgi");
	w[2]=w[4];
	w[3]=w[1];
	w[6]=w[0];
	w[7]=w[5];
	w[8]=w[0];
	w[9]=w[1];
	line(x1,y1,x2,y2);
	drawpoly(5,w);

	cohen();
	getch();
	closegraph();
	detectgraph(&gd,&gm);
    initgraph(&gd,&gm,"C:\\TURBOC3\\bgi");

	line(x1,y1,x2,y2);
	drawpoly(5,w);
	getch();

}