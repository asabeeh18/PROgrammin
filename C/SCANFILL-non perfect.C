//Scanline fill
#include<stdio.h>
#include<graphics.h>
#include<conio.h>
void scanfill()
{
	int ael[20],k=-1,f=1,i,j;
	setcolor(12);
	for(i=0;i<720;i++)
	{
		f=1;
		for(j=0;j<1200;j++)
		{
			if(getpixel(j,i)!=0)
			{
				ael[++k]=j;
				//for(l=j+1;l<1280;l++)
				//{
					//if(
			}
		}
		for(;k>0;k--)
		{
			delay(50);
			if(f==1)
			{
				line(ael[k],i,ael[k-1],i);
				f=0;
			}
			else
				f=1;
		}
		k--;
	}
}
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
	scanfill();
}