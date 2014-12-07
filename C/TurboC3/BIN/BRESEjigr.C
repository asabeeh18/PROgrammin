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
	
	//yinc=dy/abs(dy);
	//xinc=dx/abs(dx);
	if(abs(dx)>=abs(dy))
	{
		i=abs(dx);
		p=2*dy-dx;
		while((x1!=x2 || y1!=y2) && i--)
		{
			
			if(p<0)
			{
				xinc=dx/abs(dx);
				p+=2*abs(dx);
				yinc=0;
			}	
			else
			{
					xinc=dx/abs(dx);
				yinc=dy/abs(dy);
				p+=2*abs(dy)-2*abs(dx);
			}
			x1+=xinc;
			y1+=yinc;
			putpixel(x1,y1,RED);
		}
	}
	else
	{
		p=2*dx-dy;
		i=abs(dy);
		while((x1!=x2 || y1!=y2) && i--)
		{
			if(p<0)
			{
				xinc=0;
				p+=2*abs(dy);
				yinc=dy/abs(dy);
			}	
			else
			{
					xinc=dx/abs(dx);
				yinc=dy/abs(dy);
				p+=2*abs(dy)-2*abs(dx);
			}
			x1+=xinc;
			y1+=yinc;
			putpixel(x1,y1,RED);
		}
	}	
       getch();
       return 1;
}
