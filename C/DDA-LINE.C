#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
void Initialize(void)
{
  int xasp, yasp;			/* Used to read the aspect ratio*/

  GraphDriver = DETECT; 		/* Request auto-detection	*/
  initgraph( &GraphDriver, &GraphMode, "" );
  ErrorCode = graphresult();		/* Read result of initialization*/
  if( ErrorCode != grOk ){		/* Error occured during init	*/
    printf(" Graphics System Error: %s\n", grapherrormsg( ErrorCode ) );
    exit( 1 );
  }

  getpalette( &palette );		/* Read the palette from board	*/
  MaxColors = getmaxcolor() + 1;	/* Read maximum number of colors*/

  MaxX = getmaxx();
  MaxY = getmaxy();			/* Read size of screen		*/

  getaspectratio( &xasp, &yasp );	/* read the hardware aspect	*/
  AspectRatio = (double)xasp / (double)yasp; /* Get correction factor	*/

}

void dda(int x1,int y1,int y1,int y2)
{
	int dx,dy,step;
	float xinc,yinc;
	Initialize();
	dx=x2-x1;
	dy=y2-y1;
	if(abs(dx)>=abs(dy))
		step=abs(dx);
	else
		step=abs(dy);
	xinc=(float)dx/step;
	yinc=(float)dy/step;
	putpixel(x1,y1,15);
	for(i=0;i<step;i++)
	{
		x1+=xinc;
		y1=y1+yinc;
		putpixel(x1,y1,15);
	}
}	
void main()
{

	int gdriver = DETECT, gmode, errorcode;
	char msg[80];
	initgraph(&gdriver, &gmode, "C:\TC\BGI");
	clrscr();
	printf("x1 and y1 then x2 y2 co-ords");
	scanf("%d %d %d %d",&x1,&y1,&x2,&y2);
	dda(x1,y1,x2,y2);
}	