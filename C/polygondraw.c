//Scanline fill
#include<stdio.h>
#include<graphics.h>
#include<conio.h>
void main()
{
	int i,a[10][2],n,gm,gd;
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i][0]);
		scanf("%d",&a[i][1]);
	}
	a[n][0]=a[0][0];
	a[n][1]=a[0][1];
	detectgraph(&gm,&gd);
	initgraph(&gm,&gd,"C:\\TURBOC3\\bgi");
	setcolor(5);
	drawpoly(n+1,a);
}