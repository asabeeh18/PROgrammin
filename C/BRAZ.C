#include <stdio.h>
#include <stdlib.h>
#include <graphics.h>
#include <math.h>
#define COLOR 15
double fact(int n)
{
	int i;
	double f=1;
	for(i=1;i<=n;i++)
		f=f*i;
	return f;
}	
double BEZ(int k,int n,double u)
{
	return fact(n)/fact(n-k)/fact(k)*pow(u,k)*pow((1-u),n-k);
}	
	
void main()
{
	int x[4],gd,gm,i,n;	
	double xt,yt,t;
	printf("Enter the number of points");
	scanf("%d",&n);
	printf ("Enter the x and y coordinates\n");
	for (i=0; i<n; i=i+2)
	{
		scanf ("%d%d", &x[i], &x[i+1]);
	}
	detectgraph(&gd,&gm);
	initgraph (&gd, &gm, "C:\\TURBOC3\\BGI");
	
	getch();
}