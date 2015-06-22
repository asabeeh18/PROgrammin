#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
int i,n,j=0;
int xmin,xmax,ymin,ymax;
float x1,y1,x2,y2;
float point[2][2];

void clip(float e,float f,float m)
{
while(e<xmin|| e>xmax|| f<ymin|| f>ymax)
{
if(e<xmin)
{
f+=m*(xmin-e);
e=xmin;
}
else if(e>xmax)
{
f+=m*(xmax-e);
e=xmin;
}
if(f<ymin)
{
e+=(ymin-f)/m;
f=ymin;
}
else if(f>ymax)
{
e+=(ymax-f)/m;
f=ymax;
}
point[j][0]=e;
point[j][1]=f;
j++;
}
}

void main()
{
int gd=DETECT,gm;
int i,n;
float x[8],y[8],m;
clrscr();
initgraph(&gd,&gm,"C:\\tc\\BGI");
printf("Co ordinates for Window : ");
scanf("%d%d%d%d",&xmin,&ymin,&xmax,&ymax);

printf("Starting coordinates : ");
scanf("%f%f",&x1,&y1);
printf("Ending coordinates : ");
scanf("%f%f",&x2,&y2);

cleardevice();

rectangle(xmin,ymin,xmax,ymax);

line(x1,y1,x2,y2);

getch();
cleardevice();

m=(y2-y1)/(x2-x1);
clip(x1,y1,m);
clip(x2,y2,m);
rectangle(xmin,ymin,xmax,ymax);

if(point[0][0]==0&&point[0][1]==0) //x1 y1 inside x2 y2 outside
{
line(x1,y1,point[1][0],point[1][1]);
getch();
exit(0);
}
else if(point[1][0]==0&&point[1][1]==0) //x1 y1 outside x2 y2 inside
{
line(x1,y1,point[1][0],point[1][1]);
getch();
exit(0);
}
else if(point[0][0]==0&&point[0][1]==0&&point[1][0]==0&&point[1][1]==0) //x1 y1 inside x2 y2 inside
{
line(x1,y1,x2,y2);
getch();
exit(0);
}
else
{
line(point[0][0],point[0][1],point[1][0],point[1][1]); //x1 y1 outside x2 y2 outside
getch();
exit(0);
}

}