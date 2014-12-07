//Persistant Version--Harder and Crappier
#include<stdio.h>
#include<graphics.h>
#include<math.h>
void rotation(int v,float x[],float y[])
{
	float thetha;
	int i;
	printf("Enter the angle of rotation\n");
	scanf("%f",&thetha);
	thetha=(thetha*3.142/180);
	for(i=0;i<v-1;i++)
	{
		line(x[i]*cos(thetha)-y[i]*sin(thetha),x[i]*sin(thetha)+y[i]*cos(thetha),x[i+1]*cos(thetha)-y[i+1]*sin(thetha),x[i+1]*sin(thetha)+y[i+1]*cos(thetha));
		x[i]=x[i]*cos(thetha)-y[i]*sin(thetha);
		y[i]=x[i]*sin(thetha)+y[i]*cos(thetha);

	}
	x[v-1]=x[v-1]*cos(thetha)-y[v-1]*sin(thetha);
	y[v-1]=x[v-1]*sin(thetha)+y[v-1]*cos(thetha);
	
	line(x[0],y[0],x[v-1],y[v-1]);
	getch();
}
void scaling(int v,float x[],float y[])
{
	float sx,sy;
	int i;
	printf("Enter the sx sy\n");
	scanf("%f %f",&sx,&sy);
	for(i=0;i<v-1;i++)
	{
		line(x[i]*sx,y[i]*sy,x[i+1]*sx,y[i+1]*sy);
		x[i]=x[i]*sx;		//Saving new co-ords
		y[i]=y[i]*sy;
	}
	x[v-1]=x[v-1]*sx;
	y[v-1]=y[v-1]*sy;
	
	line(x[v-1],y[v-1],x[0],y[0]);
	getch();
}
void translation(int v,float x[],float y[])
{
	float tx,ty;
	int i;
	printf("Enter the tx ty\n");
	scanf("%f %f",&tx,&ty);
	for(i=0;i<v-1;i++)
	{
		line(x[i]+tx,y[i]+ty,x[i+1]+tx,y[i+1]+ty);
		x[i]=x[i]+tx;
		y[i]=y[i]+ty;
	}
	x[v-1]=x[v-1]+tx;
	y[v-1]=y[v-1]+ty;
	
	line(x[v-1],y[v-1],x[0],y[0]);
	getch();
}
void main()
{
	int gd,gm,v,ch,i;
	float thetha,x[10],y[10];
	clrscr();
	printf("Enter the no. of vertices\n");
	scanf("%d",&v);
	printf("Enter the co ordinates");
	for(i=0;i<v;i++)
		scanf("%f %f",&x[i],&y[i]);
	detectgraph(&gd,&gm);
	initgraph(&gd,&gm,"C://TURBOC3//BGI");

	for(i=0;i<v-1;i++)
		line(x[i],y[i],x[i+1],y[i+1]);
	line(x[0],y[0],x[v-1],y[v-1]);
	while(ch!=4)
	{
		printf("Enter Choice \n1.Translation \n2.Scaling \n3.Rotation\n4.Exit");\
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: translation(v,x,y);
					break;
			case 2: scaling(v,x,y);
					break;
			case 3: rotation(v,x,y);
					break;
			case 4: break;
			default:printf("\nWRONG CHOICE!!\n");
		}
	}	
}	