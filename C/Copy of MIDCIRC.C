#include<stdio.h>
#include<graphics.h>
#include<conio.h>
#include<math.h>
void symm(int xc,int yc,int x,int y)
{
	putpixel(xc+x,yc+y,RED);
	putpixel(xc-x,yc+y,RED);
	putpixel(xc+x,yc-y,RED);
	putpixel(xc-x,yc-y,RED);
	putpixel(xc+y,yc+x,RED);
	putpixel(xc+y,yc-x,RED);
	putpixel(xc-y,yc+x,RED);
	putpixel(xc-y,yc-x,RED);
	delay(40);
}
int main()
{
	int gm,gd;
	int x,y,xc,yc,r,p,i=0;
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
	scanf("%d%d%d",&xc,&yc,&r);
	p=1-r;
	x=0;
	y=r;
	symm(xc,yc,x,y);
	//while(y!=x-xc+yc)
	while(i<3.14*r/4)
	{
		if(p<0)
			p+=2*x+1;
		else
		{
			p+=2*(x-y)+1;
			y-=1;
		}
		x+=1;
		symm(xc,yc,x,y);
		i++;
	}
	getch();
	return 1;
}