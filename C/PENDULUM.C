#include<stdio.h>
#include<graphics.h>
#include<conio.h>
void main()
{
	int gd,gm,i=0,d,s=1,j;
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
	printf("Enter Delay");
	scanf("%d",&d);
	//strt 60,300 mid 320,400 end 580,300
	for(i=0,j=0;i<500 &&j<1000;i++,j++)
	{
		if(s==1)
		{
			setcolor(WHITE);
			circle(60+i,300+0.4*i,60);
			line(320,0,60+i,300+0.4*i);
			delay(d);
			setcolor(BLACK);
			circle(60+i,300+0.4*i,60);
			line(320,0,60+i,300+0.4*i);
			if(60+i==320)
			{
				s=2;
				i=0;
			}
		}
		else if(s==2)
		{
			setcolor(WHITE);
			circle(320+i,400-0.4*i,60);
			line(320,0,320+i,400-0.4*i);
			delay(d);
			setcolor(BLACK);
			circle(320+i,400-0.4*i,60);
			line(320,0,320+i,400-0.4*i);
			if(320+i==580)
			{
				s=3;
				i=0;
			}
		}
		else if(s==3)
		{
			setcolor(WHITE);
			circle(580-i,300+0.4*i,60);
			line(320,0,580-i,300+0.4*i);
			delay(d);
			setcolor(BLACK);
			circle(580-i,300+0.4*i,60);
			line(320,0,580-i,300+0.4*i);
			if(580-i==320)
			{
				s=4;
				i=0;
			}
		}
		else
		{
			setcolor(WHITE);
			circle(320-i,400-0.4*i,60);
			line(320,0,320-i,400-0.4*i);
			delay(d);
			setcolor(BLACK);
			circle(320-i,400-0.4*i,60);
			line(320,0,320-i,400-0.4*i);
			if(320-i==60)
			{
				s=1;
				i=0;
			}
		}
	  }
}