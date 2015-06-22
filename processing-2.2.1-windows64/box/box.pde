color pallete[]={color(255, 0, 0),color(0, 255, 0),color(0, 0, 255),color(0, 0, 0),color(255,255,255)};//rgb black white
int i;
int poz[][]={{0,0},{300,0},{0,300},{300,300}};
int spoz[][]={{0,150},{400,150}};
void make(int CT,int side,int col)
{
  fill(pallete[col]);
  rect(poz[CT-1][0]+side*70,poz[CT-1][1],30,30);
}
void smake(int CT,int col)
{
   fill(pallete[col]);
  rect(spoz[CT-1][0],spoz[CT-1][1],30,30);
}
void setup()
{
 print((1+1)%2);
  size(displayWidth,displayHeight);
  for(i=1;i<5;i++)
  {
    make(i,0,4);
    make(i,1,4);
  }
  for(i=1;i<3;i++)
  {
    smake(i,4);
    smake(i,4);
  }
  //fill()
  //fill colors
}
