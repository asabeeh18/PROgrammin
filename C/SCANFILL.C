//Scanline fill
#include<stdio.h>
#include<graphics.h>
#include<conio.h>
void vfloodfill(int x,int y)
{
	if(getpixel(x,y)!=5 && getpixel(x,y)!=12)
	{       delay(10);
		putpixel(x,y,12);
		vfloodfill(x,y-1);
		vfloodfill(x,y+1);
		vfloodfill(x-1,y);
		vfloodfill(x+1,y);
	}
}
void main()
{
	int i,a[10][2],n,gm,gd,sx,sy,x,y;
	scanf("%d %d %d",&x,&y,&n);
/*	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i][0]);
		scanf("%d",&a[i][1]);
	}
	a[n][0]=a[0][0];
	a[n][1]=a[0][1];
*/	scanf("%d %d",&sx,&sy);
	detectgraph(&gm,&gd);
	initgraph(&gm,&gd,"C:\\TURBOC3\\bgi");
	setcolor(5);
	circle(x,y,n);
	setcolor(12);
	vfloodfill(sx,sy);
}