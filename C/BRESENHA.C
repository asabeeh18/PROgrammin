#include<stdio.h>
#include<graphics.h>
#include<conio.h>
#include<math.h>
int main()
{
	int gm,gd;
	int x1,y1,x2,y2,dx,dy,xinc,yinc,p,step,i;
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
	scanf("%d%d%d%d",&x1,&y1,&x2,&y2);

	dx=x2-x1;
	dy=y2-y1;
	p=2*dy-dx;
	yinc=dy/abs(dy);
	xinc=dx/abs(dx);
	if(abs(dx)>=abs(dy))
	{
		i=abs(dx);
		while((x1!=x2 || y1!=y2) && i--)
		{
			x1+=xinc;
			if(p<0)
				p+=2*abs(dx);
			else
			{
				y1+=yinc;
				p+=2*abs(dy)-2*abs(dx);
			}
			putpixel(x1,y1,RED);
		}
	}
	else
	{
		i=abs(dy);
		while((x1!=x2 || y1!=y2) && i--)
		{
			y1+=yinc;
			if(p<0)
				p+=2*abs(dx);
			else
			{
				x1+=xinc;
				p+=2*abs(dy)-2*abs(dx);
			}
			putpixel(x1,y1,RED);
		}
	}	
       getch();
       return 1;
}
