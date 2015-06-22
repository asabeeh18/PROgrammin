#include<stdio.h>
#include<graphics.h>
#include<conio.h>
void main()
{
	int gd,gm,i=0,d;
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
	//640 horizontal pixels
	//480 vertical pixels
	/*
	while(getch()!='c')
	{
		putpixel(100,i,15);
		printf("%d ",i);

		i++;
	}*/
	//320,240
	printf("Enter Delay");
	scanf("%d",&d);
	circle(320,240,200);
	circle(250,170,60);
	arc(320,240,225,315,150);
	for(i=0;i<121;i++)
	{
		setcolor(WHITE);
		circle(390,170,i%60);
		if(i%60==0)
		{
			setcolor(BLACK);
			circle(390,170,i%60);
			setcolor(WHITE);
			line(340,170,440,170);
			delay(d+50);
			setcolor(BLACK);
			line(340,170,440,170);
		}
		delay(d);
		setcolor(BLACK);
		circle(390,170,i%60);
	}
}