#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>

void main()
{
	float d;
	int gd ,gm,i,x,y,r;
	clrscr();

	printf("Enter the radius\n");
	scanf("%d",&r);
	
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C:\\TurboC3\\BGI");
               
	x=0;
	y=r;
	d=3-2*r;
	
	do
	{
		putpixel(200+x,200+y,15);
		putpixel(200+y,200+x,15);
		putpixel(200+y,200-x,15);
		putpixel(200+x,200-y,15);
		putpixel(200-x,200-y,15);
		putpixel(200-y,200-x,15);
		putpixel(200-y,200+x,15);
		putpixel(200-x,200+y,15);

		if(d<=0)
			d+=4*x +6;
		else
		{
			d+= 4*(x-y) +10;
			y--;
		}
		x++;
		delay(2000);
	}
	while(x<y);
	getch();
	closegraph();
}