#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>

void main()
{
 int gd,gm,x1,y1,x2,y2,i,w[20],ca=1;
 float pk[20],qk[20],rk[20],u1=0,u2=1,x11,y11,x22,y22,dx,dy;

 detectgraph(&gd,&gm);
 initgraph(&gd,&gm,"c:\\tc\\bgi");

 printf("enter boundary cordinates of window\n");
 scanf("%d%d%d%d",&w[0],&w[1],&w[4],&w[5]);

 w[2]=w[4];
 w[3]=w[1];
 w[6]=w[0];
 w[7]=w[5];
 w[8]=w[0];
 w[9]=w[1];

 drawpoly(5,w);

 line(x1,y1,x2,y2);

 printf("enter end pt cordinates of line segment\n");
 scanf("%d%d%d%d",&x1,&y1,&x2,&y2);

 dx=(float)x2-x1;
 dy=(float)y2-y1;

 pk[1]=-dx;
 pk[2]=dx;
 pk[3]=-dy;
 pk[4]=dy;

 qk[1]=(float)x1-w[0];
 qk[2]=(float)w[1]-x1;
 qk[3]=(float)y1-w[4];
 qk[4]=(float)w[5]-y1;

 for(i=1;i<=4;i++)
 {
  if(pk[i]==0&&qk[i]<0)
   printf("not a clipping candidate\n");
   ca=0;
 }



 for(i=1;i<=4;i++)
 {
  rk[i]=qk[1]/pk[1];
 }


 for(i=1;i<=4;i++)
 {
  if(pk[i]<0)
  {
   if(u1<rk[i])
   {
     u1=rk[i];
   }
  }
  if(pk[i]>0)
  {
   if(u2>rk[i])
   {
    u2=rk[i];
   }
  }
 }

 if(u1>u2)
 {
  printf("not a clipping candidate\n");
  ca=0;
 }


  if(ca==1)
  {
   x11=x1+u1*dx;
   y11=y1+u1*dy;
   x22=x2+u2*dx;
   y22=y2+u2*dy;
  }

  getch();
  closegraph();

  detectgraph(&gd,&gm);
  initgraph(&gd,&gm,"c:\\tc\\bgi");
  line(x11,y11,x22,y22);
  drawpoly(5,w);

  getch();
 }
