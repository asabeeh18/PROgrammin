#include<stdio.h>
#include<graphics.h>
#include<conio.h>
#include<math.h>
int main()
{
	int gm,gd;
	int x1,y1,x2,y2,dx,dy,i,step,xinc,yinc;
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
	scanf("%d%d%d%d",&x1,&y1,&x2,&y2);

	dx=x2-x1;
	dy=y2-y1;
	if(abs(dy)<=abs(dx))
		step=abs(dx);
	else
		step=abs(dy);
	xinc=dx/step;
	yinc=dy/step;
	putpixel(x1,y1,RED);
  //	while(x1!=x2 && y1!=y2)
	for(i=0;i<step;i++)
	{
		x1+=xinc;
		y1+=yinc;
		putpixel(x1,y1,RED);
	}
	getch();
	return 1;
}