float easing=0.02;
float y=0.9*displayHeight;
//int dispalyWidth=displayWidth;
//int displayHeight=displayHeight;
void draw()
{
  background(100);
  int targetY=mouseY;
  y += (targetY - y) * easing;
  drawMan(0,y);
}
void setup()
{
  size(displayWidth,displayHeight);
  line(0.8*displayWidth,0,0.8*displayWidth,displayHeight);
  line(20,20,20,40);
  drawMan(0,0.9*displayHeight);
}
void drawMan(float a,float b)
{
  line(0.7*displayWidth,b,0.8*displayWidth,b);  //legs
  line(0.5*displayWidth,b,0.7*displayWidth,b);  //stem
  line(0.5*displayWidth,b,0.6*displayWidth,b);  //hands
  ellipse(0.45*displayWidth,b,0.1*displayWidth,0.1*displayWidth);  //head
}
