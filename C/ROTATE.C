#include<stdio.h>
#include<conio.h>
#include<math.h>
#include<graphics.h>
int main(void)
{
	double x;
	float a=0;
	int x1,y1,x2,y2,x3,y3,x4,y4;
	int gm,gd;
	fflush(stdin);
	 detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C:\\TURBOC3\\bgi");
	putpixel(20,30,RED);
	printf("Enter line points");
	scanf("%d %d %d %d",&x1,&y1,&x2,&y2);
	line(x1,y1,x2,y2);
	getch();
	printf("Enter angle");
	scanf("%f",&a);
	printf("%f ",a);
	a=(a*3.14)/180;
	printf("%f ",&a);
	y3=y1*cos(a)+x1*sin(a);
	x3=x1*cos(a)-y1*sin(a);
	y4=y2*cos(a)+x2*sin(a);
	x4=x2*cos(a)-y2*sin(a);
	line(x3,y3,x4,y4);
	line(x1*cos(a)-y1*sin(a),y1*cos(a)+x1*sin(a),x2*cos(a)-y2*sin(a),y2*cos(a)+x2*sin(a));
     /*  //	a=0;
//        fflush(stdin);
	b=a;

	x=sin(a);
	printf("%lf  %lf %lf \n",sin(a),b,b/180.0*3.14);
	*/
	getch();
	return 0;
}