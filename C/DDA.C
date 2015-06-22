#include<conio.h>
#include<stdio.h>
#include<graphics.h>
#include<math.h>
#define COLOR 15

void main()
{
 int gd,gm ,i,size,j;
 float dx,dy,x1,x2,y1,y2,xinc,yinc,steps,x,y;
 clrscr();
 detectgraph(&gd,&gm);
 initgraph(&gd,&gm,"C:\\TC\\BGI");
 printf("Enter the Starting Co-Ordinates");
 scanf("%f %f",&x1,&y1);
 printf("Enter the Ending Co-Ordinates");
 scanf("%f %f",&x2,&y2);
 printf("Enter the Size");
 scanf("%d",&size);
 cleardevice();


 dx=x2-x1;
 dy=y2-y1;

 if(abs(dx)>abs(dy))
 steps=abs(dx);
 else
 steps=abs(dy);

 xinc=dx/steps;
 yinc=dy/steps;
 i=0;
 x=x1;
 y=y1;
/*
   |  |
 --------
   | X |
 --------
   | X |
The x marked are the pixel taken for ploting.
*/
 while(i<steps)
 {
 for(j=0;j<size;j++)
 {
 putpixel(x,y,COLOR);
 putpixel(x,y-j,COLOR);
 }

 x+=xinc;
 y+=yinc;
 i++;

 }
 getch();
 closegraph();

}

