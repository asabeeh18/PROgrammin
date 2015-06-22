#include<stdio.h>
#include<conio.h>
#include<graphics.h>
int clipTest(float p,float q,float *u1,float *u2)
{
	float r;
	int retVal=1;
	if(p<0.0)
	{
		r=q/p;
		if(r>*u2)
			retVal=0;
		else
			if(r>*u2)
				*u1=r;
	}
	else
		if(p>0.0)
		{
			r=q/p;
			if(r<*u1)
				retVal=0;
			else if(r<*u2)
				*u2=r;
		}
		else
			if(q<0.0)
				retVal=0;
	 return retVal;
}
void main()
{
	int xw[10],gm,gd,i;
	float p[4],q[4],r[4],u1,u2,pk,x11,x22,y11,y22,dx,dy,x1,y1,x2,y2;
	printf("Enter line co ordinates x1 y1 x2 y2");
	scanf("%f %f %f %f",&x1,&y1,&x2,&y2);
	printf("Enter window co ordinates xw1,yw1,xw2,yw2");
	scanf("%d %d %d %d",&xw[0],&xw[1],&xw[4],&xw[5]);
//	printf("Enter window co ordinates xv1,yv1,xv1,yv2");
	//scanf("%d %d %d %d",&xv1,&yv1,&xv2,&yv2);
	 detectgraph(&gd,&gm);
    initgraph(&gd,&gm,"C:\\TURBOC3\\bgi");

	xw[2]=xw[4];
	xw[3]=xw[1];
	xw[6]=xw[0];
	xw[7]=xw[5];
	xw[8]=xw[0];
	xw[9]=xw[1];
	line(x1,y1,x2,y2);
	drawpoly(5,xw);

	//Initial construction DONE!
	if(clipTest(-dx,x1-xw[0],&u1,&u2))
		if(clipTest(dx,xw[4]-x1,&u1,&u2))
		{
			dy=y2-y1;
			if(clipTest(-dy,y1-xw[1],&u1,&u2))
				if(clipTest(dy,xw[5]-y1,&u1,&u2))
				{
					if(u2<1.0)
					{
						x2=x1+u2*dx;
						y2=y1+u2*dy;
					 }
					if(u1>0.0)
					{
						x1+=u1*dx;
						y1+=u1*dy;
					}
//					line(x1,				}
				 }
			}
	getch();
	clrscr();
	closegraph();
	getch();
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C:\\TURBOC3\\bgi");
      //	printf("\n%f %f %f %f",x11,y11,x22,y22);
	line(x1,y1,x2,y2);
	drawpoly(5,xw);

}