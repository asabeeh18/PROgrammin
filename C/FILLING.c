#include<stdio.h>
#include<conio.h>
#include<graphics.h>
int fc=RED,bc=WHITE;
//void flood_fill(
void boundary_fill(int x,int y)
{
	if(getpixel(x,y)!=fc && getpixel(x,y)!=bc && getpixel(x,y)!=15)
	{
		putpixel(x,y,fc);
		boundary_fill(x+1,y);
		boundary_fill(x+1,y+1);
		boundary_fill(x,y+1);
		boundary_fill(x-1,y+1);
		boundary_fill(x-1,y);
		boundary_fill(x-1,y-1);
		
		boundary_fill(x,y-1);
		
		boundary_fill(x+1,y-1);
	}
}	
		
void main()
{
	int gd,gm,x,y;
	printf("SEED PIXEL");
	scanf("%d %d",&x,&y);
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
	circle(400,400,300);
	//flood_fill(x,y);
	getch();
	boundary_fill(x,y);
}	